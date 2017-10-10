package com.huier.mobilehuier.simple.activity;

import android.app.Activity;
import android.os.Bundle;

import com.huier.mobilehuier.simple.presenter.BasePresenter;

/**
 * 作者：张玉辉
 * 时间：2017/10/9.
 * 这是我们Acticity的基类，可以看到这里有个泛型，注意了，前方高能。这个泛型还必须继承BasePresenter，
 * 这个首先为了让人一看到这个Activity就知道对应着那个Presenter；其次最重要的就是为了下面那个成员变量
 * basepresenter，我们写一个抽象的方法要求返回泛型T，而这个泛型T又继承了BasePresenter,那么我们就得到了
 * 具体Presenter的成员变量，可以直接用这个成员变量来调用Presenter中的方法了。
 */

public abstract class BaseActivity <T extends BasePresenter> extends Activity {
    protected T basepresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        basepresenter = initPresent();
        onPrepare();
    }

    abstract T initPresent();

    abstract int getLayout();

    abstract void initView();

    abstract void onPrepare();
}
