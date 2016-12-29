package com.home.news;

import android.content.Context;

import com.listener.NetWorkCallBackListener;
import com.retrofit.news.NewsResult;


/**
 * Created by dveeale on 16/12/27.
 */

public class NewsPresonter implements  NewsContarct.Presenter,NetWorkCallBackListener<NewsResult>{

    private Context mContext;
    private NewsView mNewsView;
    private NewsModelImpl mNewsModelImpl;


    public NewsPresonter(Context mContext,NewsView mNewsView){
        this.mContext=mContext;
        this.mNewsView=mNewsView;
        mNewsModelImpl=new NewsModelImpl(mContext,this);
    }

    @Override
    public void start() {

    }



    @Override
    public void LoadNetData(String info) {
        mNewsModelImpl.LoadNetData("toutiao","","baisi");
    }

    @Override
    public void LoadNetMoreData(String startKey) {
        mNewsModelImpl.LoadMoreNetData("toutiao",startKey,"baisi");
    }

    @Override
    public void LoadLocalData(String info) {

    }


    @Override
    public void onSuccess(NewsResult result,boolean isMore) {
        mNewsView.UpdatePage(result,isMore);
    }

    @Override
    public void onFailure(String json) {
        mNewsView.ShowToast(json);
    }
}
