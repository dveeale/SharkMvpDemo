package com.SplashScreen;

import android.content.Context;
import android.content.Intent;

import com.home.HomeActivity;

/**
 * Created by dveeale on 16/12/26.
 */

public class SplashView implements SplashContarct.View{

    Context mContext;

    public SplashView(Context mContext){
        this.mContext=mContext;
    }

    @Override
    public void findViews() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public void initViewsData() {

    }

    @Override
    public void showTips() {

    }

    @Override
    public void JumpToHome() {
        mContext.startActivity(new Intent(mContext, HomeActivity.class));

    }

    @Override
    public void setPresenter(SplashContarct.Presenter presenter) {

    }
}
