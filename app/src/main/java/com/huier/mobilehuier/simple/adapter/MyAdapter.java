package com.huier.mobilehuier.simple.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huier.mobilehuier.R;
import com.huier.mobilehuier.simple.bean.DingTestBean;

import java.util.List;

/**
 * 作者：张玉辉
 * 时间：2017/10/9.
 */

public class MyAdapter extends BaseAdapter {
    private List<DingTestBean> mListData;
    private Context mContext;

    public MyAdapter(Context context, List<DingTestBean> listData) {
        this.mContext = context;
        this.mListData = listData;
    }

    @Override
    public int getCount() {
        return mListData == null ? 0 : mListData.size();
    }

    @Override
    public DingTestBean getItem(int position) {
        return mListData == null ? null : mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        MyViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.lst_item, null);
            viewHolder = new MyViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(getItem(position).getName());
        viewHolder.number.setText("(" + mListData.get(position).getNumber() + "人)");
        viewHolder.time.setText(mListData.get(position).getTime());
        return convertView;
    }

    class MyViewHolder {
        TextView name;
        TextView number;
        TextView time;

        public MyViewHolder(View convertView) {
            name = (TextView) convertView.findViewById(R.id.name);
            number = (TextView) convertView.findViewById(R.id.number);
            time = (TextView) convertView.findViewById(R.id.time);
        }
    }
}
