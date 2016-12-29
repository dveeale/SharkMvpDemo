package com.listener;

/**
 * Created by dveeale on 16/12/28.
 */

public interface NetWorkCallBackListener<T> {

    void onSuccess(T result,boolean isMore);
    void onFailure(String json);
}
