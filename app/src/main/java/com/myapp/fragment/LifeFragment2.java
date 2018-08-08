package com.myapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapp.R;
public class LifeFragment2 extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.v("life_2","onattach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("life_2","oncreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("life_2","oncreateview");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_life_fragment2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v("life_2","onactivitycreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("life_2","onstart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("life_2","onresume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v("life_2","onpause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("life_2","onstop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v("life_2","ondestroyview");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("life_2","ondestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v("life_2","ondetach");
    }
}
