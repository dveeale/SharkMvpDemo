package com.home;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * 首页ViewPager适配器
 * 
 * @author dveeale
 *
 */
public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {

	private Context context;
	private List<Class<?>> mList;
	private List<Bundle> mBundleList;

	public HomeFragmentPagerAdapter(FragmentManager fm, Context context, List<Class<?>> fragments, List<Bundle> bundles) {
		super(fm);
		this.context = context;
		mList = fragments;
		mBundleList = bundles;
	}

	@Override
	public Fragment getItem(int arg0) {
		return Fragment.instantiate(context, mList.get(arg0).getName(),mBundleList.get(arg0));
	}

	@Override
	public int getCount() {
		return mList == null ? 0 : mList.size();
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
//		删除super.destoryItem(container, postion, object);是为了不让fragment被回收
//		下次划过来再create一次
//		super.destroyItem(container, position, object);
	}
	
	
}
