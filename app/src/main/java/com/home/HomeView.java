package com.home;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.SplashScreen.SplashContarct;
import com.SplashScreen.SplashPresenter;
import com.example.dveeale.sharkmvpdemo.R;
import com.home.find.FindFragment;
import com.home.more.MoreFragment;
import com.home.news.NewsFragment;
import com.home.setting.SettingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dveeale on 16/12/27.
 */

public class HomeView implements HomeContarct.View{

    private AppCompatActivity mActivity;

    private FragmentManager fragmentManager;

    private HomePresonter mHomePresonter;

    /*--控件定义--*/
    private ImageView tab_img1;
    private TextView tab_text1;

    private ImageView tab_img2;
    private TextView tab_text2;

    private ImageView tab_img3;
    private TextView tab_text3;

    private ImageView tab_img4;
    private TextView tab_text4;

    private NewsFragment mNewsFragment;
    private FindFragment mFindFragment;
    private MoreFragment mMoreFragment;
    private SettingFragment mSettingFragment;

    /*--数据变量定义--*/
    private static String[] FRAGMENT_TAGS = new String[]{"1", "2", "3", "4"};
    private View[] tabs = new View[4];
    private int current = 1;
    private int currentTab = -1;

    public HomeView(AppCompatActivity mActivity){
        this.mActivity=mActivity;
    }

    @Override
    public void setPresenter(HomePresonter mHomePresonter) {
        this.mHomePresonter=mHomePresonter;
    }

    @Override
    public void initViews() {
        findViews();
        init();
    }



    private void findViews(){
        tabs[0] = mActivity.findViewById(R.id.tab_one);
        tab_img1 = (ImageView) mActivity.findViewById(R.id.tab_img1);
        tab_text1 = (TextView) mActivity.findViewById(R.id.tab_text1);

        tabs[1] = mActivity.findViewById(R.id.tab_two);
        tab_img2 = (ImageView) mActivity.findViewById(R.id.tab_img2);
        tab_text2 = (TextView) mActivity.findViewById(R.id.tab_text2);

        tabs[2] = mActivity.findViewById(R.id.tab_three);
        tab_img3 = (ImageView) mActivity.findViewById(R.id.tab_img3);
        tab_text3 = (TextView) mActivity.findViewById(R.id.tab_text3);

        tabs[3] = mActivity.findViewById(R.id.tab_four);
        tab_img4 = (ImageView) mActivity.findViewById(R.id.tab_img4);
        tab_text4 = (TextView) mActivity.findViewById(R.id.tab_text4);


    }

    private void init(){
        for (int i = 0; i < tabs.length; i++) {
            final int j = i;
            tabs[i].setTag(i);
            tabs[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectTab(j);
                }
            });
        }
        fragmentManager = mActivity.getSupportFragmentManager();
        selectTab(current);
        initData();

    }

    private void initData() {


    }

    private void selectTab(int tab) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (tab) {
            case 0:
                if (currentTab != 0) {
                    clearTabSelection();
                    hideFragement(fragmentTransaction);
                    tab_text1.setTextColor(Color.parseColor("#78e0ff"));
                    tab_img1.setImageResource(R.drawable.simle_logo_00);
                    tab_img2.setImageResource(R.drawable.simle_logo_02);
                    tab_img3.setImageResource(R.drawable.simle_logo_03);
                    tab_img4.setImageResource(R.drawable.simle_logo_04);
                    if (mNewsFragment == null) {
                        mNewsFragment = new NewsFragment();
                        fragmentTransaction.add(R.id.container, mNewsFragment, FRAGMENT_TAGS[0]);
                    } else {
                        fragmentTransaction.show(mNewsFragment);
                    }
                    current = 0;
                    currentTab = 0;
                }
                break;
            case 1:
                if (currentTab != 1) {
                    clearTabSelection();
                    hideFragement(fragmentTransaction);
                    tab_text2.setTextColor(Color.parseColor("#78e0ff"));
                    tab_img1.setImageResource(R.drawable.simle_logo_01);
                    tab_img2.setImageResource(R.drawable.simle_logo_00);
                    tab_img3.setImageResource(R.drawable.simle_logo_03);
                    tab_img4.setImageResource(R.drawable.simle_logo_04);
                    if (mFindFragment == null) {
                        mFindFragment = new FindFragment();
                        fragmentTransaction.add(R.id.container, mFindFragment, FRAGMENT_TAGS[1]);
                    } else {
                        fragmentTransaction.show(mFindFragment);
                    }
                    current = 1;
                    currentTab = 1;
                }
                break;
            case 2:
                if (currentTab != 2) {
                    clearTabSelection();
                    hideFragement(fragmentTransaction);
                    tab_text3.setTextColor(Color.parseColor("#78e0ff"));
                    tab_img1.setImageResource(R.drawable.simle_logo_01);
                    tab_img2.setImageResource(R.drawable.simle_logo_02);
                    tab_img3.setImageResource(R.drawable.simle_logo_00);
                    tab_img4.setImageResource(R.drawable.simle_logo_04);
                    if (mMoreFragment == null) {
                        mMoreFragment = new MoreFragment();
                        fragmentTransaction.add(R.id.container, mMoreFragment, FRAGMENT_TAGS[2]);
                    } else {
                        fragmentTransaction.show(mMoreFragment);
                    }
                    current = 2;
                    currentTab = 2;
                }
                break;
            case 3:
                if (currentTab != 3) {
                    clearTabSelection();
                    hideFragement(fragmentTransaction);
                    tab_text4.setTextColor(Color.parseColor("#78e0ff"));
                    tab_img1.setImageResource(R.drawable.simle_logo_01);
                    tab_img2.setImageResource(R.drawable.simle_logo_02);
                    tab_img3.setImageResource(R.drawable.simle_logo_03);
                    tab_img4.setImageResource(R.drawable.simle_logo_00);
                    if (mSettingFragment == null) {
                        mSettingFragment = new SettingFragment();
                        fragmentTransaction.add(R.id.container, mSettingFragment, FRAGMENT_TAGS[3]);
                    } else {
                        fragmentTransaction.show(mSettingFragment);
                    }
                    current = 3;
                    currentTab = 3;
                }
                break;
        }
        fragmentTransaction.commit();
    }


    /**
     * 设置为默认颜色
     */
    private void clearTabSelection() {
        tab_text1.setTextColor(Color.RED);
        tab_text2.setTextColor(Color.RED);
        tab_text3.setTextColor(Color.RED);
        tab_text4.setTextColor(Color.RED);
    }

    /**
     * 默认隐藏所有的fragment
     *
     * @param fragmentTransaction
     */

    private void hideFragement(FragmentTransaction fragmentTransaction) {
        if (mNewsFragment != null) {
            fragmentTransaction.hide(mNewsFragment);
        }
        if (mFindFragment != null) {
            fragmentTransaction.hide(mFindFragment);
        }
        if (mMoreFragment != null) {
            fragmentTransaction.hide(mMoreFragment);
        }
        if (mSettingFragment != null) {
            fragmentTransaction.hide(mSettingFragment);
        }
    }


}
