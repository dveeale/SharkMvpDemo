package com.home.news;

import android.content.Context;

import com.listener.NetWorkCallBackListener;
import com.retrofit.news.NewsApi;
import com.retrofit.news.NewsResult;
import com.retrofit.news.NewsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dveeale on 16/12/28.
 */

public class NewsModelImpl {

    private Context mContext;

    private NetWorkCallBackListener<NewsResult> mListener;

    private NewsApi mNewsApi;
    private NewsService mNewsService;

    public NewsModelImpl(Context mContext, NetWorkCallBackListener<NewsResult> mListener){
        this.mContext=mContext;
        this.mListener=mListener;
        initRetrofit();
    }

    private void initRetrofit(){
        mNewsApi=NewsApi.getApi();
        mNewsService=mNewsApi.getService();
    }

    /**
     * 网络读取首页数据，默认是20条
     * @param type 新闻类型，默认是toutiao
     * @param endKey 设置第一页读取条数，暂时不用
     * @param qid 渠道名称，这个是百思的
     * **/
    public void LoadNetData(String type,String endKey,String qid){
        Call<NewsResult> call=mNewsService.getRefreshResult(type,endKey,qid);
        call.enqueue(new Callback<NewsResult>() {
            @Override
            public void onResponse(Call<NewsResult> call, Response<NewsResult> response) {
                if(response.isSuccessful()){
                    NewsResult result=response.body();
                    mListener.onSuccess(result,false);
                }
            }

            @Override
            public void onFailure(Call<NewsResult> call, Throwable t) {
                    mListener.onFailure(call.toString());
            }
        });
    }

    /**
     * 网络读取更多数据，默认是20条
     * @param type 新闻类型，默认是toutiao
     * @param startKey 开始的key,一般是上一页最后一条的
     * @param qid 渠道名称，这个是百思的
     * **/
    public void LoadMoreNetData(String type,String startKey,String qid){
        Call<NewsResult> call=mNewsService.getNextResult(type,startKey,qid);
        call.enqueue(new Callback<NewsResult>() {
            @Override
            public void onResponse(Call<NewsResult> call, Response<NewsResult> response) {
                if(response.isSuccessful()){
                    NewsResult result=response.body();
                    mListener.onSuccess(result,true);
                }
            }

            @Override
            public void onFailure(Call<NewsResult> call, Throwable t) {
                mListener.onFailure(call.toString());
            }
        });
    }
}
