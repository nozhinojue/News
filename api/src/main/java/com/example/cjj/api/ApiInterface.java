package com.example.cjj.api;

import android.content.Context;

/**
 * api接口
 *
 * Created by CJJ on 2016/3/10.
 */
public interface ApiInterface {
    /**
     * 异步获取图片json数据.
     *
     * @param apiCallbackListener 回调接口
     */
    void getPicJsonData(ApiCallbackListener apiCallbackListener);

    /**
     * 获取musicjson数据
     * @param type  不同的音乐类型,1、2、3....
     * @param apiCallbackListener
     */
    void getMusicJsonData(int type,ApiCallbackListener apiCallbackListener);


    void getNewsJsonData(String url,int pageNum, ApiCallbackListener apiCallbackListener);

    void getPicDetailJsonData(String id,int skipNum, ApiCallbackListener apiCallbackListener);

}
