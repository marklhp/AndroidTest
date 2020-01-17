package com.myapp.myfragment;

import androidx.lifecycle.ViewModelProviders;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapp.App;
import com.myapp.R;
import com.myapp.base.BaseFragment;
import com.myapp.databinding.Test1Fragment2Binding;
import com.myapp.utils.LogUtils;
import com.myapp.utils.SDCardUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Test1Fragment extends BaseFragment<Test1Fragment2Binding> {

    private Test1ViewModel mViewModel;
    private PackageManager packageManager;
    private String packageName;

    public static Test1Fragment newInstance() {
        return new Test1Fragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.test1_fragment2;
    }

    @Override
    protected void initView() {
         packageManager = App.context.getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(PackageManager.MATCH_UNINSTALLED_PACKAGES);
        for (PackageInfo installedPackage : installedPackages) {
            String appName = installedPackage.applicationInfo.loadLabel(
                    packageManager).toString();
            // 获取到应用所在包的名字,即在AndriodMainfest中的package的值。
             packageName = installedPackage.packageName;
            try {
                if (TextUtils.equals(packageName,"com.android.server.telecom")){


                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                String sourceDir = packageManager.getApplicationInfo(packageName, 0).sourceDir;
                                File file=new File(sourceDir);
                                InputStream inputStream=new FileInputStream(file);
                                File externalFilesDir = App.context.getExternalFilesDir(Environment.DIRECTORY_PODCASTS);
                                OutputStream outputStream=new FileOutputStream(new File(externalFilesDir,file.getName()));
                                byte[] bytes=new byte[1024];
                                int bytelength=0;
                                while ((bytelength = inputStream.read(bytes)) != -1) {
                                    outputStream.write(bytes, 0, bytelength);
                                }
                                outputStream.close();
                                inputStream.close();
                                LogUtils.d("da========="+sourceDir);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void initData() {

    }



}
