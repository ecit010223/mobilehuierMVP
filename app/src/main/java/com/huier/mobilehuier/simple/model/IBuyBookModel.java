package com.huier.mobilehuier.simple.model;

import com.huier.mobilehuier.simple.bean.DingTestBean;
import com.huier.mobilehuier.simple.callback.ValueCallBack;

import java.util.List;

/**
 * 作者：张玉辉
 * 时间：2017/10/9.
 */

public interface IBuyBookModel {
    /**
     * 获取模拟数据
     */
    void getTestData(ValueCallBack<List<DingTestBean>> callBack);


    /**
     * 返回本地adapter数据
     * @return
     */
    List<DingTestBean> getAdapterData();
}
