package com.myapp.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;


import com.myapp.callback.ListItemOnclickInte;
import com.myapp.utils.ResourcesUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihaipeng on 2018/5/14.
 * 适配器基类
 */

public abstract class BaseBindingAdapter<M,B extends ViewDataBinding> extends RecyclerView.Adapter {
    protected List<M> items;
    protected ListItemOnclickInte onClickInte;
    public BaseBindingAdapter() {
        items=new ArrayList<>();
    }
    public BaseBindingAdapter(ListItemOnclickInte itemOnclickInte) {
        this.items = new ArrayList<>();
        this.onClickInte =itemOnclickInte;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        B binding= DataBindingUtil.inflate(ResourcesUtils.getInflater(),this.getLayoutResId(viewType),parent,false);
        return new BaseBindingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        B binding = DataBindingUtil.getBinding(holder.itemView);

        if (onClickInte !=null) binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickInte.onItemclick(v.getId(),position,items.get(position));
            }
        });
        this.onBindItem(binding,this.items.get(position),position);
//        try {
//
//        }catch (Exception e){
//            e.printStackTrace();
//            LogUtils.d("-=-=-==-="+this.toString());
//        }
        binding.executePendingBindings();



    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    protected abstract int getLayoutResId(int viewType);
    protected abstract void onBindItem(B binding, M item, int position);
    public void add (M m){
        items.add(m);
    }

    public List<M> getItems() {
        return items;
    }
    public M getItem(int position) {
        if (position<0||position>items.size()){
            return null;
        }else {
            return items.get(position);
        }
    }

    public void removeItem(int position){
        if (items!=null&position>=0&&position<items.size()){
            items.remove(position);
        }
        notifyDataSetChanged();
    }
    public void setItems(ArrayList<M> items) {
        this.items = items;
        notifyDataSetChanged();
    }
    public void refreshData(@NonNull List<M> list){
        items.clear();
        items.addAll(list);
        notifyDataSetChanged();
    }
}
