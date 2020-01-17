package com.myapp.customview;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.myapp.App;
import com.myapp.R;


/**
 * Created by kangxin on 2017/9/27.
 */

public class ProgressWebView extends WebView {
    private ProgressBar mProgressBar;
    private CountDownTimer timer;

    public ProgressWebView(Context context) {
        super(context);
        initView(context);
    }
    public ProgressWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ProgressWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }




    private void initView(Context context) {
        mProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        mProgressBar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 3, 0, 0));
        addView(mProgressBar);

        mProgressBar.setProgressDrawable(App.context.getResources().getDrawable(R.drawable.web_progress_bar_states));
        getSettings().setDomStorageEnabled(true);
        setWebChromeClient(new WebChromeClient());
    }

    public class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                mProgressBar.setVisibility(GONE);
                cancelCountDownTimer();
            } else {
                if (mProgressBar.getVisibility() == GONE)
                    mProgressBar.setVisibility(VISIBLE);
                mProgressBar.setProgress(newProgress);
                starCountDownTimer();
            }
            super.onProgressChanged(view, newProgress);
        }

    }

    private void cancelCountDownTimer() {
        if (timer != null) {
            timer.cancel();
        }
        timer = null;
    }

    private void starCountDownTimer() {
        if (timer == null) {
            timer = new CountDownTimer(15000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    Toast.makeText(App.context,"加载失败",Toast.LENGTH_SHORT).show();
                }
            };
            timer.start();
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        LayoutParams lp = (LayoutParams) mProgressBar.getLayoutParams();
        lp.x = l;
        lp.y = t;
        mProgressBar.setLayoutParams(lp);
        super.onScrollChanged(l, t, oldl, oldt);
    }
}

