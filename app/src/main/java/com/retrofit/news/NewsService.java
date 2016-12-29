package com.retrofit.news;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dveeale on 16/12/28.
 */

public interface NewsService {
    @GET("/jsonnew/refresh")
    Call<NewsResult> getRefreshResult(@Query("type") String type,
                               @Query("endkey") String endkey,
                               @Query("qid") String qid);

    @GET("/jsonnew/next")
    Call<NewsResult> getNextResult(@Query("type") String type,
                               @Query("startkey") String endkey,
                               @Query("qid") String qid);
}
