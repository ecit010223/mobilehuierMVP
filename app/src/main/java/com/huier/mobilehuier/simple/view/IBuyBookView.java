package com.huier.mobilehuier.simple.view;

/**
 * 作者：张玉辉
 * 时间：2017/10/9.
 * 包含了Activity的一系列关于UI操作，然后用Activity实现，这样Presenter就可以调用了
 */

public interface IBuyBookView {
    /**
     * 提示toast
     */
    void showToast(String msg);

    /**
     * 刷新adapter
     */
    void refreshAdapter();

    void onEmpty();
}
