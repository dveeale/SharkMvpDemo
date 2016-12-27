package com.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.SplashScreen.SplashContarct;
import com.example.dveeale.sharkmvpdemo.R;
import com.home.find.FindFragment;
import com.home.more.MoreFragment;
import com.home.news.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dveeale on 16/12/27.
 */

public class HomeView implements HomeContarct.View{

    private FragmentActivity mActivity;

    private Button mNewsButton;
    private Button mFindButton;
    private Button mMoreButton;

    private ViewPager mViewPager;
    private HomeFragmentPagerAdapter mHomeFragmentPagerAdapter;

    private List<Class<?>> mList;
    private List<Bundle> mBundleList;

    public HomeView(FragmentActivity mActivity){
        this.mActivity=mActivity;
    }

    @Override
    public void initViews() {
        findViews();
        init();
    }

    @Override
    public void setPresenter(SplashContarct.Presenter presenter) {

    }

    private void findViews(){
        mNewsButton=(Button)mActivity.findViewById(R.id.HomeButton);
        mFindButton=(Button)mActivity.findViewById(R.id.FindButton);
        mMoreButton=(Button)mActivity.findViewById(R.id.MoreButton);
        mViewPager=(ViewPager)mActivity.findViewById(R.id.viewPager);
    }

    private void init(){
        mViewPager.setOnPageChangeListener(pageChangeListener);
        mNewsButton.setOnClickListener(clickListener);
        mFindButton.setOnClickListener(clickListener);
        mMoreButton.setOnClickListener(clickListener);
        initData();

    }

    private void initData() {
        mList = new ArrayList<Class<?>>();
        mBundleList = new ArrayList<Bundle>();
        mList.add(NewsFragment.class);
        mBundleList.add(null);
        mList.add(FindFragment.class);
        mBundleList.add(null);

        mList.add(MoreFragment.class);
        mBundleList.add(null);

        mHomeFragmentPagerAdapter = new HomeFragmentPagerAdapter(mActivity.getSupportFragmentManager(), mActivity,
                mList,mBundleList);
        mViewPager.setAdapter(mHomeFragmentPagerAdapter);
        mNewsButton.setSelected(true);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.HomeButton:
                    mViewPager.setCurrentItem(0);
                    break;
                case R.id.FindButton:
                    mViewPager.setCurrentItem(1);
                    break;
                case R.id.MoreButton:
                    mViewPager.setCurrentItem(2);
                    break;
            }
        }
    };

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {

        /**
         * 滑动停止时调用
         *
         * @param position
         *            当前页面位置
         */
        @Override
        public void onPageSelected(int position) {
            setSelectedPosition(position);
        }

        /**
         * 页面开始滑动到停止之前一直得到调用
         *
         * @param arg0
         *            当前可见第一个页面的position
         * @param arg1
         *            当前页面偏移百分比
         * @param arg2
         *            当前页面偏移像素位置
         */
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        /**
         * 滑动状态改变时被调用
         *
         * @param atate
         *            有3个值，0：滑动结束 1：手指按下 2：手指抬起
         */
        @Override
        public void onPageScrollStateChanged(int atate) {
        }
    };

    private void setSelectedPosition(int position) {
        switch (position) {
            case 0:
                mNewsButton.setSelected(true);
                mFindButton.setSelected(false);
                mMoreButton.setSelected(false);
                break;
            case 1:
                mNewsButton.setSelected(false);
                mFindButton.setSelected(true);
                mMoreButton.setSelected(false);
                break;
            case 2:
                mNewsButton.setSelected(false);
                mFindButton.setSelected(false);
                mMoreButton.setSelected(true);
                break;
        }
    }

}
