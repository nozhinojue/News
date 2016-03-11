package com.example.cjj.api;

/**
 * api的处理结果回调监听
 *
 * Created by CJJ on 2016/3/10.
 */
public interface ApiCallbackListener {
    /**
     * 成功时调用
     *
     * @param jsonResult  json数据
     */
    void onSuccessed(String jsonResult);

    /**
     * 失败时调用
     *
     * @param errorMsg 错误信息
     */
    void onFailure(String errorMsg);
}
