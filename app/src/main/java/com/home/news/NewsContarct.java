package com.home.news;

import android.view.View;

import com.base.BasePresenter;
import com.base.BaseView;
import com.bean.MainItemBean;
import com.retrofit.news.NewsResult;

import java.util.List;

/**
 * Created by dveeale on 16/12/27.
 */

public interface NewsContarct {
    interface CView extends BaseView<NewsPresonter> {
        void initViews(View mView);
        void UpdatePage(NewsResult mNewsResult,boolean isMore);
        void ShowToast(String info);

    }

    interface Presenter extends BasePresenter {
        void LoadNetData(String info);
        void LoadNetMoreData(String startKey);
        void LoadLocalData(String info);
    }
}
