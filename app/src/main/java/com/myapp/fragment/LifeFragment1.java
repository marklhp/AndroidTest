package com.myapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapp.R;

import androidx.fragment.app.Fragment;


public class LifeFragment1 extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.v("life_1","onattach");
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("life_1","oncreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("life_1","oncreateview");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_life_fragment1, container, false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v("life_1","onactivitycreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("life_1","onstart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("life_1","onresume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v("life_1","onpause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("life_1","onstop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v("life_1","ondestroyview");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("life_1","ondestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v("life_1","ondetach");
    }
}
