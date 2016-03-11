package com.example.cjj.core;

import com.example.cjj.api.ApiCallbackListener;
import com.example.cjj.model.MusicMainData;
import com.example.cjj.model.NewItemData;
import com.example.cjj.model.PicTypeData;
import com.example.cjj.model.PicTypeDetailData;

/**
 * Created by CJJ on 2016/3/11.
 */
public interface AppActionInterface {

    /**
     * 获取PicTypeData数据
     *
     * @param actionCallbackListener 回调监听
     */
    void getPicData(ActionCallbackListener<PicTypeData> actionCallbackListener);

    /**
     * 获取MusicMainData数据
     *
     * @param type                不同的音乐类型,1、2、3....
     * @param actionCallbackListener
     */
    void getMusicData(int type,ActionCallbackListener<MusicMainData> actionCallbackListener);

    /**
     * 获取新闻数据
     *
     * @param url   路径url
     * @param pageNum   页数
     * @param actionCallbackListener
     */
    void getNewsData(String url,int pageNum, ActionCallbackListener<NewItemData> actionCallbackListener);

    /**
     * 获取图片详细数据。
     * @param id
     * @param skipNum
     * @param actionCallbackListener
     */
    void getPicDetailData(String id,int skipNum, ActionCallbackListener<PicTypeDetailData> actionCallbackListener);

}
