package com.home;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.base.BaseActivity;
import com.example.dveeale.sharkmvpdemo.R;

public class HomeActivity extends BaseActivity {

    HomeView mHomeView;
    HomePresonter mHomePersonter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mHomeView=new HomeView(this);
        mHomePersonter=new HomePresonter(mHomeView);
        mHomeView.setPresenter(mHomePersonter);

        /*--设置标题头--*/
        title = getString(R.string.app_name);
        isSetLogo = true;

        mHomeView.initViews();
    }
}
