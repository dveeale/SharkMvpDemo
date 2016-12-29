package com.widget;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.util.ControllerListenerUtil;
import com.util.DpPxConvert;
import com.util.MyUtils;

/**
 * Created by dveeale on 16/12/29.
 */

public class CommonRecyclerViewHolder extends RecyclerView.ViewHolder{

    //所有控件的集合
    private SparseArray<View> mViews;

    //复用的View
    private View mConvertView;

    public CommonRecyclerViewHolder(View itemView) {
        super(itemView);
        this.mViews = new SparseArray<>();
        mConvertView=itemView;
    }

    /**
     * 通过ViewId获取控件
     *
     * @param viewId View的Id
     * @param <T>    View的子类
     * @return 返回View
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为文本设置text
     *
     * @param viewId view的Id
     * @param text   文本
     * @return 返回ViewHolder
     */
    public CommonRecyclerViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 为DraweeView设置图片地址宽度
     *
     * @param viewId view的Id
     * @param url   图片加载地址
     * @param width  图片显示宽度，会根据图片大小算出显示高度
     * @return 返回ViewHolder
     */
    public CommonRecyclerViewHolder setDraweeView(int viewId, String url,int width) {
        SimpleDraweeView draweeView=getView(viewId);
        ControllerListenerUtil.setControllerListener(draweeView, url, width);
        return this;
    }
}
