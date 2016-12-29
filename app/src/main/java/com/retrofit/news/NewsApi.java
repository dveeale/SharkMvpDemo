package com.retrofit.news;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dveeale on 16/12/28.
 */

public class NewsApi {

    private NewsService service;

    public static NewsApi getApi(){
        return SingleHolder.newsApi;
    }

    private static class SingleHolder{
        public static NewsApi newsApi=new NewsApi();
    }

    public NewsService getService(){
        return service;
    }

    private NewsApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://newswifiapi.dfshurufa.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        service = retrofit.create(NewsService.class);
    }


}
