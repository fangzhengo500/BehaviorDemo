package com.loosu.behaviordemo.adapter.recyclerview;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewParent;

/**
 * Created by Administrator on 2018/7/11.
 */

public class RecyclerViewHelper {
    private RecyclerViewHelper() {
    }

    /**
     * 获取 RecyclerView 父容器;
     *
     * @param view view
     * @return may be null
     */
    @Nullable
    public static RecyclerView getParentRecyclerView(@Nullable View view) {
        if (view == null) {
            return null;
        }

        RecyclerView recyclerView = null;
        ViewParent parent = view.getParent();
        if (parent instanceof RecyclerView) {
            recyclerView = (RecyclerView) parent;

        } else if (parent instanceof View) {
            recyclerView = getParentRecyclerView((View) parent);

        }

        return recyclerView;
    }

    /**
     * 获取本View 对应的 RecyclerView.ViewHolder
     *
     * @param view view
     * @return may be null
     */
    @Nullable
    public static RecyclerView.ViewHolder getViewHolder(@Nullable View view) {
        RecyclerView.ViewHolder holder = null;
        RecyclerView recyclerView = getParentRecyclerView(view);
        if (recyclerView != null) {
            holder = recyclerView.findContainingViewHolder(view);
        }
        return holder;
    }

    /**
     * 获取本View 对应的 RecyclerView.ViewHolder 的 RecyclerView.ViewHolder.itemView
     *
     * @param view view
     * @return may be null
     */
    @Nullable
    public static View getParentViewHolderItemView(@Nullable View view) {
        View itemView = null;
        RecyclerView recyclerView = getParentRecyclerView(view);
        if (recyclerView != null) {
            itemView = recyclerView.findContainingItemView(view);
        }
        return itemView;
    }
}
