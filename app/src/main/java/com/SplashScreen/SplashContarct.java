package com.SplashScreen;

import com.base.BasePresenter;
import com.base.BaseView;

/**
 * Created by dveeale on 16/12/26.
 */

public interface SplashContarct {
    interface View extends BaseView<Presenter> {
        void findViews();
        void initViews();
        void initViewsData();

        void showTips();

        void JumpToHome();
    }

    interface Presenter extends BasePresenter {
        void DelayJumpToHome();
    }
}
