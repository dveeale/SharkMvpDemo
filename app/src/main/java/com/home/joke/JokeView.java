package com.home.joke;

import android.content.Context;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.bean.MainItemBean;
import com.example.dveeale.sharkmvpdemo.R;
import com.home.news.NewsAdapter;
import com.home.news.NewsPresonter;
import com.refreshview.XRefreshView;
import com.refreshview.XRefreshViewFooter;

import java.util.List;

/**
 * Created by dveeale on 16/12/28.
 */

public class JokeView implements JokeContarct.CView{

    private Context mContext;
    private JokePresonter mJokePresonter;

    private Toolbar toolbar_one;

    private RecyclerView rvMain;
    private XRefreshView refreshMain;
    private JokeAdapter mJokeAdapter;

    public JokeView(Context mContext){
        this.mContext=mContext;
    }

    private void init(){
        {
            toolbar_one.setTitle("开心一刻");
            toolbar_one.setLogo(R.drawable.simle_logo_01);

            rvMain.setLayoutManager(new GridLayoutManager(mContext, GridLayoutManager.VERTICAL, 1, false));

            mJokeAdapter = new JokeAdapter(mContext);
            mJokeAdapter.setCustomLoadMoreView(new XRefreshViewFooter(mContext));
            rvMain.setAdapter(mJokeAdapter);

            mJokePresonter.LoadNetData("");

            refreshMain.setPullLoadEnable(true);
            refreshMain.setAutoLoadMore(true);
            refreshMain.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
                @Override
                public void onRefresh() {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mJokePresonter.LoadNetData("");
                        }
                    }, 1000);
                }

                @Override
                public void onLoadMore(boolean isSilence) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mJokePresonter.LoadNetMoreData("");
                        }
                    }, 1000);
                }
            });
        }
    }

    private void findViews(View mView){
        toolbar_one = (Toolbar) mView.findViewById(R.id.toolbar_one);

        rvMain = (RecyclerView) mView.findViewById(R.id.rvMain);
        refreshMain = (XRefreshView) mView.findViewById(R.id.refreshMain);

//        fabMainToTop = (FloatingActionButton) mView.findViewById(R.id.fabMainToTop);
    }

    @Override
    public void initViews(View mView) {
        findViews(mView);
        init();
    }

    @Override
    public void UpdatePage(List<MainItemBean> mainItemBeanList) {
        mJokeAdapter.SetDataList(mainItemBeanList);

        mJokeAdapter.notifyDataSetChanged();
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


    @Override
    public void setPresenter(JokePresonter presenter) {
        mJokePresonter=presenter;
    }
}
