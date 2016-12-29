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
import com.retrofit.news.NewsItem;
import com.retrofit.news.NewsResult;

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

    private List<NewsItem> mNewsDatas;


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

                refreshMain.stopRefresh();
                mNewsPresonter.LoadNetData("");
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                if(mNewsDatas!=null&&mNewsDatas.size()>0){
                    String key=mNewsDatas.get(mNewsDatas.size()-1).getRowkey();
                    mNewsPresonter.LoadNetMoreData(key);
                }


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
    public void UpdatePage(NewsResult mNewsResult,boolean isMore) {

        if (isMore) {
            refreshMain.stopLoadMore();
            mNewsDatas.addAll(mNewsResult.getData());
        }else{
            mNewsDatas=mNewsResult.getData();
        }

        mNewsAdapter.SetDataList(mNewsDatas);
        mNewsAdapter.notifyDataSetChanged();
    }


    @Override
    public void ShowToast(String info) {
        Toast.makeText(mContext, info, Toast.LENGTH_SHORT).show();
    }


    private void findViews(View mView){
        toolbar_one = (Toolbar) mView.findViewById(R.id.toolbar_one);

        rvMain = (RecyclerView) mView.findViewById(R.id.rvMain);
        refreshMain = (XRefreshView) mView.findViewById(R.id.refreshMain);

        fabMainToTop = (FloatingActionButton) mView.findViewById(R.id.fabMainToTop);
    }


}
