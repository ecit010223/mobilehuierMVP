package com.huier.mobilehuier.simple.presenter;

import com.huier.mobilehuier.simple.activity.BaseActivity;

/**
 * 作者：张玉辉
 * 时间：2017/10/9.
 * 这里为什么用了个泛型？为了让人一看这个Presenter就知道这对应着哪个Activity,实际上这可以不加的，
 * 但是我觉得加上去更好。便于后来人也便于自己以后再来修改这个类。
 */

public abstract class BasePresenter<T extends BaseActivity> {
    abstract void initData();
}
