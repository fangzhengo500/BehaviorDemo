package com.loosu.behaviordemo.adapter.recyclerview;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/17/017.
 * 通用的RecyclerAdapter
 */

public abstract class ARecyclerAdapter<T> extends AbsRecyclerAdapter {
    protected List<T> mDatas = new ArrayList<>();

    public ARecyclerAdapter(@Nullable List<T> datas) {
        if (datas != null) {
            mDatas = datas;
        }
    }

    public List<T> getDatas() {
        return mDatas;
    }

    public void setDatas(List<T> datas) {
        mDatas = datas;
    }

    @Override
    protected void onBindViewData(RecyclerHolder holder, int position) {
        onBindViewData(holder, position, mDatas);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    protected abstract void onBindViewData(RecyclerHolder holder, int position, List<T> datas);
}
