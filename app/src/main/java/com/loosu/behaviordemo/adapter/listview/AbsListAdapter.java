package com.loosu.behaviordemo.adapter.listview;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.loosu.behaviordemo.adapter.IAViewHolder;


/**
 * Created by Administrator on 2018/7/30/030.
 */

public abstract class AbsListAdapter<VH extends AbsListAdapter.ViewHolder> extends BaseAdapter {

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VH holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(getItemViewLayoutId(position), parent, false);
            holder = createViewHolder(position, convertView);
            convertView.setTag(holder);
        } else {
            holder = (VH) convertView.getTag();
        }
        onBindViewData(holder, position);
        return convertView;
    }

    protected abstract VH createViewHolder(int position, @NonNull View convertView);

    protected abstract int getItemViewLayoutId(int position);

    protected abstract void onBindViewData(VH holder, int position);

    public static abstract class ViewHolder implements IAViewHolder {
        public View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
        }

        @Override
        public View getItemView() {
            return itemView;
        }
    }
}
