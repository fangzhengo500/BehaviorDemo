package com.loosu.behaviordemo.adapter.listview;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2018/7/30/030.
 */

public abstract class AListAdapter<T> extends AbsListAdapter<ListViewHolder> {
    protected List<T> mDatas = null;

    public List<T> getDatas() {
        return mDatas;
    }

    public void setDatas(List<T> datas) {
        mDatas = datas;
    }

    @Override
    protected ListViewHolder createViewHolder(int position, @NonNull View itemView) {
        return new ListViewHolder(itemView);
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Nullable
    @Override
    public T getItem(int position) {
        return mDatas == null ? null : mDatas.get(position);
    }
}
