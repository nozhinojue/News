package com.example.cjj.core;

import com.example.cjj.api.ApiCallbackListener;
import com.example.cjj.api.ApiImpl;
import com.example.cjj.model.MusicMainData;
import com.example.cjj.model.NewItemData;
import com.example.cjj.model.PicTypeData;
import com.example.cjj.model.PicTypeDetailData;
import com.google.gson.Gson;

/**
 * Created by CJJ on 2016/3/10.
 */
public class AppActionImpl implements AppActionInterface {


    @Override
    public void getPicData(final ActionCallbackListener<PicTypeData> actionCallbackListener) {
        new ApiImpl().getPicJsonData(new ApiCallbackListener() {
            @Override
            public void onSuccessed(String jsonResult) {
                Gson gson = new Gson();
                PicTypeData picTypeData = gson.fromJson(jsonResult, PicTypeData.class);
                actionCallbackListener.onSuccessed(picTypeData);
            }

            @Override
            public void onFailure(String errorMsg) {
                actionCallbackListener.onFailure(errorMsg);
            }
        });
    }

    /**
     * 获取MusicMainData数据
     *
     * @param type  不同的音乐类型,1、2、3....
     * @param actionCallbackListener
     */
    @Override
    public void getMusicData(int type, final ActionCallbackListener<MusicMainData> actionCallbackListener) {
        new ApiImpl().getMusicJsonData(type, new ApiCallbackListener() {
            @Override
            public void onSuccessed(String jsonResult) {
                Gson gson = new Gson();
                MusicMainData musicMainData = gson.fromJson(jsonResult, MusicMainData.class);
                actionCallbackListener.onSuccessed(musicMainData);
            }

            @Override
            public void onFailure(String errorMsg) {
                actionCallbackListener.onFailure(errorMsg);
            }
        });
    }

    @Override
    public void getNewsData(String url, int pageNum, final ActionCallbackListener<NewItemData> actionCallbackListener) {
        new ApiImpl().getNewsJsonData(url, pageNum, new ApiCallbackListener() {
            @Override
            public void onSuccessed(String jsonResult) {
                Gson gson = new Gson();
                NewItemData newItemData= gson.fromJson(jsonResult, NewItemData.class);
                actionCallbackListener.onSuccessed(newItemData);
            }

            @Override
            public void onFailure(String errorMsg) {
                actionCallbackListener.onFailure(errorMsg);
            }
        });
    }

    @Override
    public void getPicDetailData(String id, int skipNum, final ActionCallbackListener<PicTypeDetailData> actionCallbackListener) {
        new ApiImpl().getPicDetailJsonData(id, skipNum, new ApiCallbackListener() {
            @Override
            public void onSuccessed(String jsonResult) {
                Gson gson = new Gson();
                PicTypeDetailData picTypeDetailData = gson.fromJson(jsonResult, PicTypeDetailData.class);
                actionCallbackListener.onSuccessed(picTypeDetailData);
            }

            @Override
            public void onFailure(String errorMsg) {
                actionCallbackListener.onFailure(errorMsg);
            }
        });
    }


}
