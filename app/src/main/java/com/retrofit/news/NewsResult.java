package com.retrofit.news;

import java.util.List;

/**
 * Created by dveeale on 16/12/28.
 */

public class NewsResult {
    private String stat;
    private List<NewsItem> data;

    public List<NewsItem> getData() {
        return data;
    }

    public void setData(List<NewsItem> data) {
        this.data = data;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
