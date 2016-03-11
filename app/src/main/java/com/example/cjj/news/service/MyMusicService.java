package com.example.cjj.news.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by CJJ on 2016/3/4.
 */
public class MyMusicService  extends Service {
    private MyMediaPlayer myMediaPlayer;
    @Override
    public void onCreate() {
        super.onCreate();
        myMediaPlayer=new MyMediaPlayer(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myMediaPlayer.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
