package com.myapp.utils.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.myapp.R;

import androidx.databinding.BindingAdapter;

/**
 * Created by lihaipeng on 2018/5/3.
 */

public class ImageViewAdapter {
    static RequestOptions options = new RequestOptions()
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)//预加载图片
            .error(R.mipmap.ic_launcher)//加载失败显示图片
            .priority(Priority.HIGH)//优先级
            .centerCrop();
    static RequestOptions circleOptions=new RequestOptions()
            .centerCrop();
    static RequestOptions roundOptions=new RequestOptions();
    /**
     * 普通加载类
     * @param view
     */
    @BindingAdapter("android:src")
    public static void loadImage(ImageView view,String url){
        Glide.with(view.getContext())
                .load(url)
                .apply(options)
                .into(view);

    }
    /**
     * 普通加载类
     * @param view
     */
    @BindingAdapter("android:bindsrc")
    public static void loadImage(ImageView view,int src){
        view.setImageResource(src);

    }
    @BindingAdapter("android:src")
    public static void loadImage(ImageView view,String url,String resId){
        Glide.with(view.getContext())
                .load(url)
                .apply(options)
                .thumbnail(Glide.with(view.getContext()).load(url))
                .into(view);

    }

    /**
     * 显示圆形图片
     * @param view
     * @param url
     */
    @BindingAdapter("android:circle_imageurl")
    public static void loadCircleImage(ImageView view,String url){
        circleOptions.placeholder(0);
        Glide.with(view.getContext())
                .load(url)
                .apply(circleOptions)
                .apply(RequestOptions.circleCropTransform())
                .into(view);

    }
    @BindingAdapter("android:circle_resid")
    public static void loadCircleImage(ImageView view,int url){
        circleOptions.placeholder(0);
        Glide.with(view.getContext())
                .load(url)
                .apply(circleOptions)
                .apply(RequestOptions.circleCropTransform())
                .into(view);

    }

    @BindingAdapter({"android:circle_imageurl","android:thumbnail_imageurl"})
    public static void loadCircleImage(ImageView view,String url,int resId){
        circleOptions.placeholder(resId);
        Glide.with(view.getContext())
                .load(url)
                .apply(circleOptions)
                .apply(RequestOptions.circleCropTransform())
                .into(view);

    }

    /**
     * 显示圆角图片
     * @param view
     * @param url
     */
    @BindingAdapter({"android:round_imageurl","android:radius"})
    public static void loadRoundImage(ImageView view,String url,int mRadius){
        int radius=5;
        roundOptions.transform(new GlideRoundTransform(mRadius==0?radius:mRadius));
        roundOptions.placeholder(0);
        Glide.with(view.getContext())
                .load(url)
                .apply(roundOptions)
                .into(view);
    }

    @BindingAdapter({"android:round_imageurl","android:thumbnail_imageurl","android:radius"})
    public static void loadRoundImage(ImageView view,String url,int resId,int mRadius){
        int radius=5;
        roundOptions.transform(new GlideRoundTransform(mRadius==0?radius:mRadius));
        roundOptions.placeholder(resId);
        roundOptions.error(resId);
        Glide.with(view.getContext())
                .load(url)
                .apply(roundOptions)
                .into(view);
    }
}
