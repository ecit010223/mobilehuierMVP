package com.huier.mobilehuier.simple.activity;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.huier.mobilehuier.R;
import com.huier.mobilehuier.simple.adapter.MyAdapter;
import com.huier.mobilehuier.simple.presenter.BuyBookPresenter;
import com.huier.mobilehuier.simple.view.IBuyBookView;

/**
 * 作者：张玉辉
 * 时间：2017/10/9.
 */

public class BuyBookActivity extends BaseActivity<BuyBookPresenter> implements IBuyBookView {
    private Context mContext = null;
    private Toolbar mToolbar = null;
    private Button mBtnRequest = null;
    private ListView mListView = null;
    private MyAdapter mAdapter = null;

    @Override
    BuyBookPresenter initPresent() {
        return new BuyBookPresenter(this);
    }

    @Override
    int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    void initView() {
        mContext = this;
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mBtnRequest = (Button)findViewById(R.id.btn_request);
        mListView = (ListView) findViewById(R.id.listview);
    }

    @Override
    void onPrepare() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"NavigationOnClickListener",Toast.LENGTH_LONG).show();
            }
        });
        mToolbar.setTitle("ToolBar");
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(mContext,"OnMenuItemClickListener",Toast.LENGTH_LONG).show();
                return true;
            }
        });

        //按钮事件注册
        mBtnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basepresenter.initData();
            }
        });

        mAdapter = new MyAdapter(this, basepresenter.getAdapterData());
        mListView.setAdapter(mAdapter);
        basepresenter.initData();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void refreshAdapter() {
        mAdapter.notifyDataSetChanged();
    }

    public void onEmpty() {
        mListView.setEmptyView(null);
    }
}
