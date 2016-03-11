package com.example.cjj.core;

/**
 * Created by CJJ on 2016/3/10.
 */
public interface ActionCallbackListener<T> {
    void onSuccessed(T data);
    void onFailure(String errorMsg);
}
