package com.SplashScreen;

import android.os.Handler;

/**
 * Created by dveeale on 16/12/26.
 */

public class SplashPresenter implements SplashContarct.Presenter {

    SplashContarct.View mSplashView;

    private Handler mHandler=new Handler();

    public SplashPresenter(SplashContarct.View mSplashView){
        this.mSplashView=mSplashView;
    }

    @Override
    public void DelayJumpToHome() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSplashView.JumpToHome();
            };
        },0);

    }

    @Override
    public void start() {

    }
}
