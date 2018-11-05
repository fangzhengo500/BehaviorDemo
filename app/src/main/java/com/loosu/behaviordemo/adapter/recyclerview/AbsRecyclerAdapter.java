package com.loosu.behaviordemo.adapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/5/17/017.
 * 通用的RecyclerAdapter
 */

public abstract class AbsRecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> implements View.OnClickListener {
    private IRecyclerItemClickListener mItemClickListener;

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(getItemLayoutId(viewType), parent, false);
        RecyclerHolder holder = new RecyclerHolder(itemView);
        //holder.setOnItemClickListener(this);
        holder.itemView.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        onBindViewData(holder, position);
    }

    public void setItemClickListener(IRecyclerItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    protected abstract int getItemLayoutId(int viewType);

    protected abstract void onBindViewData(RecyclerHolder holder, int position);

    public abstract Object getItem(int position);

    @Override
    public void onClick(View v) {
        RecyclerView recyclerView = RecyclerViewHelper.getParentRecyclerView(v);
        RecyclerView.ViewHolder holder = recyclerView.findContainingViewHolder(v);
        if (v == holder.itemView) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(recyclerView,holder.getAdapterPosition(),holder,v);
            }
        }
    }
}
