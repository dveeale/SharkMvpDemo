package com.home.news;

import android.content.Context;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.bean.MainItemBean;
import com.example.dveeale.sharkmvpdemo.R;
import com.refreshview.XRefreshView;
import com.refreshview.XRefreshViewFooter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dveeale on 16/12/27.
 */

public class NewsView implements NewsContarct.CView {

    private Context mContext;

    private NewsPresonter  mNewsPresonter;

    private Toolbar toolbar_one;

    private RecyclerView rvMain;
    private XRefreshView refreshMain;
    private NewsAdapter mNewsAdapter;

    private FloatingActionButton fabMainToTop;



    public NewsView(Context mContext){
        this.mContext=mContext;
    }

    private void init(){
        toolbar_one.setTitle(mContext.getString(R.string.app_name));
        toolbar_one.setLogo(R.drawable.simle_logo_01);

        rvMain.setLayoutManager(new GridLayoutManager(mContext, GridLayoutManager.VERTICAL, 1, false));

        mNewsAdapter = new NewsAdapter(mContext);
        mNewsAdapter.setCustomLoadMoreView(new XRefreshViewFooter(mContext));
        rvMain.setAdapter(mNewsAdapter);

        mNewsPresonter.LoadNetData("");

        refreshMain.setPullLoadEnable(true);
        refreshMain.setAutoLoadMore(true);
        refreshMain.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mNewsPresonter.LoadNetData("");
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore(boolean isSilence) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mNewsPresonter.LoadNetMoreData("");
                    }
                }, 1000);
            }
        });
    }

    @Override
    public void setPresenter(NewsPresonter mNewsPresonter) {
        this.mNewsPresonter=mNewsPresonter;
    }


    @Override
    public void initViews(View mView) {
        findViews(mView);
        init();
    }

    @Override
    public void UpdatePage(List<MainItemBean> mainItemBeanList) {

        mNewsAdapter.SetDataList(mainItemBeanList);

        mNewsAdapter.notifyDataSetChanged();
    }

    @Override
    public void ShowToast(String info) {
        Toast.makeText(mContext, info, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void StopListRefresh() {
        refreshMain.stopRefresh();
    }

    @Override
    public void StopListLoadMore() {
        refreshMain.stopLoadMore();
    }

    private void findViews(View mView){
        toolbar_one = (Toolbar) mView.findViewById(R.id.toolbar_one);

        rvMain = (RecyclerView) mView.findViewById(R.id.rvMain);
        refreshMain = (XRefreshView) mView.findViewById(R.id.refreshMain);

        fabMainToTop = (FloatingActionButton) mView.findViewById(R.id.fabMainToTop);
    }


}
