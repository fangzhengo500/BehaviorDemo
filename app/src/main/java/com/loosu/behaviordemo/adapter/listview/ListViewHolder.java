package com.loosu.behaviordemo.adapter.listview;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/7/30/030.
 */

public class ListViewHolder extends AbsListAdapter.ViewHolder {

    private SparseArray<View> mViews = new SparseArray<>();

    public ListViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public <T extends View> T getView(@IdRes int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    @Override
    public void setText(@IdRes int viewId, @StringRes int resId) {
        View view = getView(viewId);
        ((TextView) view).setText(view.getContext().getString(resId));
    }

    @Override
    public void setText(@IdRes int viewId, CharSequence text) {
        View view = getView(viewId);
        ((TextView) view).setText(text);
    }

    @Override
    public void setText(TextView view, @StringRes int resId) {
        view.setText(view.getContext().getString(resId));
    }

    @Override
    public void setText(TextView view, CharSequence text) {
        view.setText(text);
    }

    @Override
    public void setTextColor(int viewId, @ColorInt int color) {
        View view = getView(viewId);
        ((TextView) view).setTextColor(color);
    }

    @Override
    public void setImageResource(@IdRes int viewId, @DrawableRes int resId) {
        View view = getView(viewId);
        ((ImageView) view).setImageResource(resId);
    }

    @Override
    public void setImageDrawable(int viewId, Drawable drawable) {
        View view = getView(viewId);
        ((ImageView) view).setImageDrawable(drawable);
    }
}
