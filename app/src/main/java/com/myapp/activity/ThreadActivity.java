package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityThreadBinding;
import com.myapp.utils.LogUtils;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.function.Consumer;

public class ThreadActivity extends BaseActivity<ActivityThreadBinding> implements View.OnClickListener {

    Thread thread;
    int finalI = 0;
    @Override
    protected void initView() {
        binding.setClick(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_thread;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.thread_id1:
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(2000);

                    }
                });
                LogUtils.d("thread状态"+thread.isAlive()+"--"+thread.getPriority());
                thread.start();
                LogUtils.d("thread状态"+thread.isAlive());
                break;
            case R.id.thread_id2:
                LogUtils.d("thread状态"+thread.isAlive());
                break;
            case R.id.thread_id3:
                final long difTime=System.currentTimeMillis();
                ExecutorService executorService = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    executorService = Executors.newSingleThreadExecutor( );
                }
                for (int i=0;i<1000;i++){

                    executorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            LogUtils.d("线程名=="+finalI+"=="+Thread.currentThread().getName());
                            acountNum(difTime);
                        }
                    });
                }



                break;
            case R.id.thread_id4:
                 int COUNT_BITS = Integer.SIZE - 3;
                int CAPACITY   = (1 << COUNT_BITS) - 1;
                int num=1;
                for (int i=0;i<COUNT_BITS;i++){
                    num=num*2;
                }
                LogUtils.d("打印数据"+COUNT_BITS+"===="+Integer.MAX_VALUE+"===="+Integer.SIZE+"----"+CAPACITY+"----"+num);
                break;

        }
    }

    private synchronized void acountNum(long difTime) {
        if (finalI ==999){
            LogUtils.d("截止时间"+(System.currentTimeMillis()-difTime));
            LogUtils.d("线程总数"+Thread.getAllStackTraces().size());
        }
        finalI++;
        LogUtils.d("截止时间是我们定的，");
    }
}
