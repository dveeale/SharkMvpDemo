package com.home;

import com.SplashScreen.SplashContarct;
import com.base.BasePresenter;
import com.base.BaseView;

/**
 * Created by dveeale on 16/12/27.
 */

public interface HomeContarct {
    interface View extends BaseView<SplashContarct.Presenter> {
        void initViews();
    }

    interface Presenter extends BasePresenter {

    }
}
