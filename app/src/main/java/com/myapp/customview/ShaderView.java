package com.myapp.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.myapp.R;

import androidx.annotation.Nullable;

/**
 * Created by lihaipeng on 2018/7/26.
 */

public class ShaderView extends View {
    private final Path mPath = new Path();
    private final Matrix matrix = new Matrix();
    private final Bitmap bitmap;

    // 放大镜的半径
    private static final int RADIUS = 80;

    // 放大倍数
    private static final int FACTOR = 2;
    private int mCurrentX, mCurrentY;

    public ShaderView(Context context) {
        super(context);
        mPath.addCircle(RADIUS, RADIUS, RADIUS, Path.Direction.CW);
        matrix.setScale(FACTOR, FACTOR);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.custom_img);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPath.addCircle(RADIUS, RADIUS, RADIUS, Path.Direction.CW);
        matrix.setScale(FACTOR, FACTOR);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.custom_img);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mCurrentX = (int) event.getX();
        mCurrentY = (int) event.getY();

        invalidate();
        return true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 底图
        canvas.drawBitmap(bitmap, 0, 0, null);

        // 剪切
        canvas.translate(mCurrentX - RADIUS, mCurrentY - RADIUS);
        canvas.clipPath(mPath);

        // 画放大后的图
        canvas.translate(RADIUS - mCurrentX * FACTOR, RADIUS - mCurrentY * FACTOR);
        canvas.drawBitmap(bitmap, matrix, null);
    }
}
