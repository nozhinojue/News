package com.example.cjj.news.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
        context=getApplicationContext();
    }

}
