package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.myapp.App;
import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityFileCheckBinding;
import com.myapp.utils.LogUtils;

import java.io.File;
import java.io.IOException;

public class FileCheckActivity extends BaseActivity<ActivityFileCheckBinding> implements View.OnClickListener {


    @Override
    protected void initView() {
        binding.setClick(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_file_check;
    }

    @Override
    public void onClick(View v) {
        SharedPreferences hahah1 = getSharedPreferences("hahah", Context.MODE_PRIVATE);
        SharedPreferences.Editor hahah = hahah1.edit();
        hahah.putString("99999","-----").apply();




        StringBuilder sb=new StringBuilder("");
        File file=Environment.getExternalStorageDirectory();
        sb.append(file.getParent()).append("||");
        sb.append(file.exists());
        if (file.exists()) sb.append(file.getAbsolutePath());
        sb.append("\n");
        sb.append("0-------------------------------------");
        sb.append("\n");
        File file1=new File(getExternalCacheDir().getAbsolutePath());

        sb.append(file1.getParent()).append("||");
        sb.append(file1.exists());
        if (file1.exists()) sb.append(file1.getAbsolutePath());
        sb.append("\n");

        sb.append("1-------------------------------------");
        sb.append("\n");
        File file2=Environment.getDataDirectory();

        sb.append(file2.getParent()).append("||");
        sb.append(file2.exists());
        if (file2.exists()) sb.append(file2.getAbsolutePath());
        sb.append("\n");

        sb.append("2-------------------------------------");
        sb.append("\n");
        File file3=Environment.getRootDirectory();

        sb.append(file3.getParent()).append("||");
        sb.append(file3.exists());
        if (file3.exists()) sb.append(file3.getAbsolutePath());
        sb.append("\n");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            sb.append("3-------------------------------------");
            sb.append("\n");
            File file4= null;
            file4 = getDataDir();
            sb.append(file4.exists());
            if (file4.exists()) sb.append(file4.getAbsolutePath());
            if (file4.isDirectory()){
                for (File listFile : file4.listFiles()) {
                    if (listFile.isFile()){
                        sb.append("!=").append(listFile.getName());
                    }else if (listFile.isDirectory()){
                        sb.append("@=").append(listFile.getName());
                    }
                }
            }else if (file4.isFile()){
                sb.append(file4.getName());
            }
            sb.append(file4.getAbsolutePath());

            sb.append("\n");
        }





        File file5=new File(file1.getAbsolutePath(),"98.zip");
        sb.append(file5.exists());
        if (!file5.exists()){
            try {
                boolean newFile = file5.createNewFile();
                LogUtils.d("打印创建文件"+newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        binding.setText(sb.toString());

    }
}
