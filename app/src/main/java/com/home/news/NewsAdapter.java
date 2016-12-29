package com.home.news;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bean.MainItemBean;
import com.example.dveeale.sharkmvpdemo.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.network.Urls;
import com.refreshview.recyclerview.BaseRecyclerAdapter;
import com.retrofit.news.NewsItem;
import com.retrofit.news.NewsResult;
import com.util.ControllerListenerUtil;
import com.util.DpPxConvert;
import com.util.MyUtils;
import com.util.StringUtil;
import com.widget.CommonRecyclerViewHolder;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Author： dveeale
 */
public class NewsAdapter extends BaseRecyclerAdapter<CommonRecyclerViewHolder> {

    private Context context;

    private List<NewsItem> mNewsDatas;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void SetDataList(List<NewsItem> mNewsDatas){
        this.mNewsDatas=mNewsDatas;
    }

    @Override
    public CommonRecyclerViewHolder getViewHolder(View view) {
        return new CommonRecyclerViewHolder(view);
    }

    @Override
    public CommonRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news_layout, parent, false);
        return new CommonRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommonRecyclerViewHolder holder, int position, boolean isItem) {
        CommonRecyclerViewHolder viewHolder=holder;
        final NewsItem mNewsItem = mNewsDatas.get(position);

        viewHolder.setText(R.id.NewsTitleTextView,mNewsItem.getTitle())
                .setText(R.id.NewsSourceTextView,mNewsItem.getSource())
                .setText(R.id.NewsDateTextView,mNewsItem.getDate())
                .setDraweeView(R.id.NewsDraweeView,mNewsItem.getmImages().get(0).getSrc(),(int)DpPxConvert.dip2px(context, 70));
    }


    @Override
    public int getAdapterItemCount() {
        int size=0;
        if(mNewsDatas!=null&&mNewsDatas.size()>0){
            size=mNewsDatas.size();
        }
        return size;
    }

}
