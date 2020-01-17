package com.myapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.myapp.R;
import com.myapp.activity.TraceActivity;
import com.myapp.databinding.ItemListTraceBinding;
import com.myapp.utils.network.TracerouteContainer;

public class TraceListAdapter extends BaseBindingAdapter<TracerouteContainer, ItemListTraceBinding> {
    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.item_list_trace;
    }

    @Override
    protected void onBindItem(ItemListTraceBinding binding, TracerouteContainer item, int position) {


        TracerouteContainer currentTrace = getItem(position);

        if (position % 2 == 1) {
            binding.getRoot().setBackgroundResource(R.drawable.table_odd_lines);
        } else {
            binding.getRoot().setBackgroundResource(R.drawable.table_pair_lines);
        }

        if (currentTrace.isSuccessful()) {
            binding.imageViewStatusPing.setImageResource(R.drawable.check);
        } else {
            binding.imageViewStatusPing.setImageResource(R.drawable.cross);
        }

        binding.textViewNumber.setText(position + "");
        binding.textViewIp.setText(currentTrace.getHostname() + " (" + currentTrace.getIp() + ")");
        binding.textViewTime.setText(currentTrace.getMs() + "ms");

    }
}
