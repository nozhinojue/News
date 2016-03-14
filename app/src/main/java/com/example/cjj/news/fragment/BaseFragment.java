package com.example.cjj.news.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Fragment抽象基类
 *
 * Created by CJJ on 2016/3/14.
 */
public abstract class BaseFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutResourceId(), container, false);

        initViews(view);//初始化views
        return view;
    }


    /**
     * 显示toast
     * @param msg
     */
    protected void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }



    /**
     * 设置布局文件id
     * @return
     */
    protected abstract int setLayoutResourceId();

    /**
     * 初始化views
     */
    protected abstract void initViews(View view);
}
