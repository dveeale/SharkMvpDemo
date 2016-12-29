package com.home.joke;

import android.view.View;

import com.base.BasePresenter;
import com.base.BaseView;
import com.bean.MainItemBean;
import com.home.news.NewsPresonter;

import java.util.List;

/**
 * Created by dveeale on 16/12/28.
 */

public interface JokeContarct {
    interface CView extends BaseView<JokePresonter> {
        void initViews(View mView);
        void UpdatePage(List<MainItemBean> mainItemBeanList);
        void ShowToast(String info);
        void StopListRefresh();
        void StopListLoadMore();
    }

    interface Presenter extends BasePresenter {
        void LoadNetData(String info);
        void LoadNetMoreData(String info);
        void LoadLocalData(String info);
    }
}
