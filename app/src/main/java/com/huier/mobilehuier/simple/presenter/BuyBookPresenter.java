package com.huier.mobilehuier.simple.presenter;

import com.huier.mobilehuier.simple.activity.BuyBookActivity;
import com.huier.mobilehuier.simple.bean.DingTestBean;
import com.huier.mobilehuier.simple.callback.ValueCallBack;
import com.huier.mobilehuier.simple.model.BuyBookModel;
import com.huier.mobilehuier.simple.model.IBuyBookModel;
import com.huier.mobilehuier.simple.view.IBuyBookView;

import java.util.List;

/**
 * 作者：张玉辉
 * 时间：2017/10/9.
 * 在构造方法中，我们需要传入一个IBookView，实际上我们的Activity已经实现IBookView了，所以这里实际上传的是
 * 具体的Activity，也就是this就行了。然后model我们可以直接new出来用。
 * 在initData中我们是进行了具体的网络请求，网络请求我们是不是要弹一个Dialog出来，直接在这mView.loading();
 * 调用就行了。然后请求成功onSuccess()里面让Dialog消失，提醒适配器刷新。失败的话onFail()里面提示Dialog消失，
 * 然后ListView设置失败页面什么的。
 */

public class BuyBookPresenter extends BasePresenter<BuyBookActivity> implements IBuyBookPresenter {
    private IBuyBookView  mView;
    private IBuyBookModel mModel;

    public BuyBookPresenter(IBuyBookView iBuyBookView) {
        this.mView = iBuyBookView;
        this.mModel = new BuyBookModel();
    }


    @Override
    public List<DingTestBean> getAdapterData() {
        return mModel.getAdapterData();
    }

    @Override
    public void initData() {
        //在这里弹出loading
        mModel.getTestData(new ValueCallBack<List<DingTestBean>>() {
            @Override
            public void onSuccess(List<DingTestBean> dingTestBeans) {
                //在这里取消loading
                //简单数据操作可以在presenter里完成
                mModel.getAdapterData().addAll(dingTestBeans);
                mView.refreshAdapter();
            }

            @Override
            public void onFail(String code) {
                //在这里取消loading
                mView.showToast(code);
                mView.onEmpty();
            }
        });
    }
}
