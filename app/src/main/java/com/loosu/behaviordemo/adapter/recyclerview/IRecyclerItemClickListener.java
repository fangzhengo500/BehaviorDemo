package com.loosu.behaviordemo.adapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2018/5/27/027.
 */

public interface IRecyclerItemClickListener {
    public void onItemClick(RecyclerView parent, int position, RecyclerView.ViewHolder holder, View view);
}
