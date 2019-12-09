package com.myapp.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import com.myapp.App;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;


/**
 */
public class SDCardUtils {

    public static final MediaType MEDIA_TYPE_PLAIN = MediaType.parse("text/plain;charset=utf-8");
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8");
    public static final MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
    public static String feedbackLogDir = Environment.getExternalStorageDirectory() +
            "/mobileplus/feedback/";
    public static String logPath_Name = "logInfo.txt";
    public static String logDirPath = SDCardUtils.getStoragePath(App.context) +"/";

    public static String getLogZipName(){
        return DeviceUtil.getPackageName()+"siplogfile";
    }
    public static boolean SDCardIsReady() {
//        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
//            return true;
//        else
//            return false;
        return true;
    }

    public static File getExternalCacheDownloadDir() {
        File downloadDir = new File(App.context.getExternalCacheDir(), "Download");
        if (!downloadDir.exists()) {
            downloadDir.mkdirs();
        }
        return downloadDir;
    }

    public static String getStoragePath(Context context) {

        String cachePath = context.getExternalCacheDir().getAbsolutePath();
//        LogUtils.d("文件路径：" + cachePath);
        return cachePath;
    }

    public static String getFileDir(Context context) {
        return context.getFilesDir().getAbsolutePath();
    }

    static File file;

    public static void save(Object response, long startsPoint, String fileName) {
        String string = null;
        try {
            string = response.toString();
            LogUtils.d("打印数据" + string);
        } catch (Exception e) {
            LogUtils.e(e);
        }

        BufferedInputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(string.getBytes()));
        String path = SDCardUtils.getStoragePath(App.context);
        file = new File(path, fileName);

        FileChannel channelOut = null;
        // 随机访问文件，可以指定断点续传的起始位置
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            //Chanel NIO中的用法，由于RandomAccessFile没有使用缓存策略，直接使用会使得下载速度变慢，亲测缓存下载3.3秒的文件，用普通的RandomAccessFile需要20多秒。
            channelOut = randomAccessFile.getChannel();
            // 内存映射，直接使用RandomAccessFile，是用其seek方法指定下载的起始位置，使用缓存下载，在这里指定下载位置。
            MappedByteBuffer mappedBuffer = channelOut.map(FileChannel.MapMode.READ_WRITE, startsPoint, string.length());
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                mappedBuffer.put(buffer, 0, len);
            }
        } catch (IOException e) {
            LogUtils.e(e);
        } finally {
            try {
                inputStream.close();
                if (channelOut != null) {
                    channelOut.close();
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                LogUtils.d("打印数据--" + file.getAbsolutePath() + "===" + file.exists());
            } catch (IOException e) {
                LogUtils.e(e);
            }
        }
    }


    /**
     * 删除指定文件夹下所有文件
     *
     * @param path 文件夹完整绝对路径
     * @return
     */
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        if (tempList == null) {
            return flag;
        }
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);// 再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 删除文件夹
     *
     * @param folderPath 文件夹完整绝对路径
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); // 删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            myFilePath.delete(); // 删除空文件夹
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }


    public static boolean isSDCardExist() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static String readString(String path) {
        String result = "";
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
            String s = "";
            while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
                result = result + s + "\n";
            }
            br.close();
        } catch (Exception e) {
            LogUtils.e(e);
        }
        return result;
    }


    /**
     * @return
     * @see {@linkplain #getMyCacheDir(String)}
     */
    public static String getMyCacheDir() {
        return getMyCacheDir(null);
    }

    /**
     * 获取或创建Cache目录
     *
     * @param bucket 临时文件目录，bucket = "/cache/" ，则放在"sdcard/linked-joyrun/cache"; 如果bucket=""或null,则放在"sdcard/linked-joyrun/"
     */
    public static String getMyCacheDir(String bucket) {
        String dir;

        // 保证目录名称正确
        if (bucket != null) {
            if (!bucket.equals("")) {
                if (!bucket.endsWith("/")) {
                    bucket = bucket + "/";
                }
            }
        } else
            bucket = "";

        String joyrun_default = "/html/";

        if (isSDCardExist()) {
            dir = Environment.getExternalStorageDirectory().toString() + joyrun_default + bucket;
        } else {
            dir = Environment.getDownloadCacheDirectory().toString() + joyrun_default + bucket;
        }

        File f = new File(dir);
        if (!f.exists()) {
            f.mkdirs();
        }
        return dir;
    }

    public static String getPortFilePath() {


        return "port.txt";
    }
    /**
     * 保存错误信息到文件中
     *
     * @return 返回文件名称, 便于将文件传送到服务器
     */
    static boolean mkdir;

    @SuppressLint("CheckResult")
    public static void saveLogInfo2File(final String s, final String s1) {
        Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {

                synchronized (SDCardUtils.class){
                    try {
                        if (SDCardUtils.SDCardIsReady()) {

                            File dir = new File(logDirPath);
                            if (!dir.exists()) {
                                mkdir = dir.mkdir();
                            }
                            File tempFile=new File(logDirPath+logPath_Name);
                            if (!tempFile.exists()){
                                tempFile.createNewFile();
                            }

                        }

                        FileOutputStream fos = new FileOutputStream(logDirPath+logPath_Name , true);
                        fos.write(TimeUtil.formatSystemTime(s,s1).getBytes());
                        fos.close();
                        LogUtils.d("");
                    } catch (Exception e) {
                        LogUtils.e(e);
                    }
                }

            }
        }).subscribeOn(Schedulers.io())
                .subscribe();

    }

    /**
     * 保存错误信息到文件中
     *
     * @return 返回文件名称, 便于将文件传送到服务器
     */

    @SuppressLint("CheckResult")
    public static void delateLogInfoFile() {
        Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                try {
                    boolean flag=false;
                    if (SDCardUtils.SDCardIsReady()) {
                        File file = new File(logDirPath+logPath_Name);
                        if (file.exists()) {
                            flag=file.delete();
                        }

                    }

                } catch (Exception e) {
                    LogUtils.e(e);
                }

            }
        }).subscribeOn(Schedulers.io())
                .subscribe();

    }
    /**
     * 保存错误信息到文件中
     *
     * @return 返回文件名称, 便于将文件传送到服务器
     */

    public static void saveCrashInfo2File(String content, String fileName) {
        String path = null;

        try {
            if (SDCardUtils.SDCardIsReady()) {
                path = SDCardUtils.getStoragePath(App.context) + "/crash/";
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
            }
            FileOutputStream fos = new FileOutputStream(path + fileName, false);
            fos.write(content.getBytes());
            fos.close();
        } catch (Exception e) {
            LogUtils.e(e);
        }

    }

    /**
     * 保存错误信息到文件中
     *
     * @return 返回文件名称, 便于将文件传送到服务器
     */

    public static String getFile2String(String fileName) {
        String path = SDCardUtils.getStoragePath(App.context) + "/crash/";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path, fileName)));
            String readLine = reader.readLine();
            StringBuilder stringBuilder = new StringBuilder();
            while (readLine != null) {
                stringBuilder.append(readLine);
                readLine = reader.readLine();
            }
            reader.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            LogUtils.e(e);
            return "";
        }

    }

    public static String getFilePath() {//Context context
        boolean hasSDCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (hasSDCard) {
            return App.context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getPath();
        } else
            return Environment.getDownloadCacheDirectory().getPath();
    }

    /**
     * 判断文件路径是否已经存在
     *
     * @param filePath 文件路径
     */
    private static boolean isFileExists(String filePath) {
        try {
            File file = new File(filePath);
            return file.exists();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getSDPath() {//Context context
        boolean hasSDCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (hasSDCard) {
            return Environment.getExternalStorageDirectory().toString();
        } else
            return Environment.getDownloadCacheDirectory().toString();
    }


    /** 根据文件名获取MIME类型 */
    public static MediaType guessMimeType(String fileName) {

        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        fileName = fileName.replace("#", "");   //解决文件名中含有#号异常的问题
        String contentType = fileNameMap.getContentTypeFor(fileName);
        if (contentType == null) {
            return MEDIA_TYPE_STREAM;
        }
        return MediaType.parse(contentType);
    }
    /**
     * 删除文件，可以是文件或文件夹
     *
     * @param delFile 要删除的文件夹或文件名
     * @return 删除成功返回true，否则返回false
     */
    @SuppressLint("CheckResult")
    public static void delete(final String delFile) {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                File file = new File(delFile);
                if (!file.exists()) {
                    //"删除文件失败:" + delFile + "不存在！"
                    LogUtils.d("文件不存在");
                } else {
                    if (file.isFile())
                        deleteSingleFile(delFile);
                    else
                        deleteDirectory(delFile);
                }
            }
        }).subscribeOn(Schedulers.io())
                .subscribe();
    }
    /**
     * 删除单个文件
     *
     * @param filePath$Name 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    private static boolean deleteSingleFile(String filePath$Name) {
        File file = new File(filePath$Name);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                Log.e("--Method--", "Copy_Delete.deleteSingleFile: 删除单个文件" + filePath$Name + "成功！");
                return true;
            } else {
                //"删除单个文件" + filePath$Name + "失败！"
                LogUtils.d("删除单个文件" + filePath$Name + "失败！");
                return false;
            }
        } else {
            // "删除单个文件失败：" + filePath$Name + "不存在！"
            LogUtils.d("删除单个文件失败：" + filePath$Name + "不存在！");
            return false;
        }
    }

    /**
     * 删除目录及目录下的文件
     *
     * @param filePath 要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    private static boolean deleteDirectory(String filePath) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!filePath.endsWith(File.separator))
            filePath = filePath + File.separator;
        File dirFile = new File(filePath);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            //"删除目录失败：" + filePath + "不存在！"
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (File file : files) {
            // 删除子文件
            if (file.isFile()) {
                flag = deleteSingleFile(file.getAbsolutePath());
                if (!flag)
                    break;
            }
            // 删除子目录
            else if (file.isDirectory()) {
                flag = deleteDirectory(file
                        .getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            //"删除目录失败！"
            LogUtils.d("删除目录失败！");
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            Log.e("--Method--", "Copy_Delete.deleteDirectory: 删除目录" + filePath + "成功！");
            return true;
        } else {
            //"删除目录：" + filePath + "失败！"
            LogUtils.d("删除目录：" + filePath + "失败！");
            return false;
        }
    }
}

