package com.example.cjj.news.application;

import android.app.Application;

import com.example.cjj.news.util.imageLoader.ImageLoaderSetting;


/**
 * Created by CJJ on 2016/2/21.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化配置ImageLoader基本属性,最好放在Application中(只能配置一次,如多次配置,则会默认第一次的配置参数)
        new ImageLoaderSetting().initImageLoader(getApplicationContext());
    }

}
