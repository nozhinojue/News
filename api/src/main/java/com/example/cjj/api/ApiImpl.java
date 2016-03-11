package com.example.cjj.api;

import android.content.Context;

import com.example.cjj.api.util.okhttp.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Request;

/**
 * Created by CJJ on 2016/3/10.
 */
public class ApiImpl implements ApiInterface {
    private static String myAPIKey="68f081859a99d672e259e2f4b1d4cae9";


    @Override
    public void getPicJsonData(final ApiCallbackListener ApiCallbackListener) {
        String urlStr="http://service.picasso.adesk.com/v1/wallpaper/category";

        Request request = new Request.Builder()
                .url(urlStr)
                .build();
        OkHttpUtil.getInstance().getJsonFromServer(request, new OkHttpUtil.MyCallBack() {
            @Override
            public void onFailure(Call call, IOException e) {
                ApiCallbackListener.onFailure("请求失败");
            }

            @Override
            public void onResponse(String json) {
                ApiCallbackListener.onSuccessed(json);
            }
        });
    }

    /**
     * 获取musicjson数据
     *
     * @param type                不同的音乐类型,1、2、3....
     * @param apiCallbackListener
     */
    @Override
    public void getMusicJsonData(int type, final ApiCallbackListener apiCallbackListener) {
                //天天动听的APi
        String Muisc_Recommend="http://api.dongting.com/" +
                "favorite/song/plaza?from=android&api_version=1.0&agent=none&user_id=0&language=zh&random="+type;

        Request request = new Request.Builder()
                .url(Muisc_Recommend)
                .build();
        OkHttpUtil.getInstance().getJsonFromServer(request, new OkHttpUtil.MyCallBack() {
            @Override
            public void onFailure(Call call, IOException e) {
               apiCallbackListener.onFailure("获取音乐数据失败！");
            }

            @Override
            public void onResponse(String json) {
               apiCallbackListener.onSuccessed(json);
            }
        });
    }


    @Override
    public void getNewsJsonData(String url, int pageNum, final ApiCallbackListener apiCallbackListener) {
        String urlStr=url+ "?"+"num=10&page="+pageNum;

        Request request=new Request.Builder()
                .header("apikey",myAPIKey)
                .url(urlStr)
                .build();
        OkHttpUtil.getInstance().getJsonFromServer(request, new OkHttpUtil.MyCallBack() {
            @Override
            public void onFailure(Call call, IOException e) {
               apiCallbackListener.onFailure("获取新闻数据失败。");
            }

            @Override
            public void onResponse(String json) {
               apiCallbackListener.onSuccessed(json);
            }
        });
    }

    @Override
    public void getPicDetailJsonData(String id, int skipNum, final ApiCallbackListener apiCallbackListener) {
        String urlStr="http://service.picasso.adesk.com/v1/wallpaper/category/"
                +id+"/wallpaper?order=new&adult=false&limit=30&first=0&skip="+skipNum;

        Request request = new Request.Builder()
                .url(urlStr)
                .build();
        OkHttpUtil.getInstance().getJsonFromServer(request, new OkHttpUtil.MyCallBack() {
            @Override
            public void onFailure(Call call, IOException e) {
                apiCallbackListener.onFailure("获取PicDetailJsonData数据失败");
            }

            @Override
            public void onResponse(String json) {
               apiCallbackListener.onSuccessed(json);
            }
        });
    }


}
