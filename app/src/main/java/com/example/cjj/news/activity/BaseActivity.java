package com.example.cjj.news.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Activity抽象基类
 *
 * Created by CJJ on 2016/3/10.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public Context context; //上下文实例

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResourceId());

        context=getApplicationContext();
        initViews();   //初始化views
    }


    /**
     * 显示toast
     * @param msg
     */
    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



    /**
     * 设置布局文件id
     * @return
     */
    protected abstract int setLayoutResourceId();

    /**
     * 初始化views
     */
    protected abstract void initViews();
}
