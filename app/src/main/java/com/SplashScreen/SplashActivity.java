package com.SplashScreen;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.dveeale.sharkmvpdemo.R;

public class SplashActivity extends AppCompatActivity {

    SplashView mSplashView;
    SplashPresenter mSplashPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        mSplashView=new SplashView(this);
        mSplashPresenter=new SplashPresenter(mSplashView);

        mSplashPresenter.DelayJumpToHome();

    }
}
