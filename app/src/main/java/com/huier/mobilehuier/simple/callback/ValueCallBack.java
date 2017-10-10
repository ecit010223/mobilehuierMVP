package com.huier.mobilehuier.simple.callback;

/**
 * 作者：张玉辉
 * 时间：2017/10/9.
 */

public interface ValueCallBack<T> {
    void onSuccess(T t);

    void onFail(String code);
}
