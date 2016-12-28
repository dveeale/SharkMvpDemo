package com.home.news;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.bean.MainItemBean;
import com.network.NetUtil;
import com.network.Urls;
import com.util.StringUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dveeale on 16/12/27.
 */

public class NewsPresonter implements  NewsContarct.Presenter{

    private Context mContext;
    private NewsView mNewsView;

    private List<MainItemBean> mainItemBeanList = new ArrayList<>();
    private int rqcnt = 18;
    private int page = 1;

    private int r = 56712;

    private String articles = "11793" + new Random().nextInt(10) + new Random().nextInt(10) + new Random().nextInt(10) + new Random().nextInt(10);


    public NewsPresonter(Context mContext,NewsView mNewsView){
        this.mContext=mContext;
        this.mNewsView=mNewsView;
    }

    @Override
    public void start() {

    }



    @Override
    public void LoadNetData(String info) {
        {
            r += new Random().nextInt(1000000);
            new AsyncTask<String, String, String>() {
                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    try {
                        if (!StringUtil.isNullOrEmpty(s)) {
                            articles = "11793" + new Random().nextInt(10) + new Random().nextInt(10) + new Random().nextInt(10) + new Random().nextInt(10) + ",";
                            JSONObject jsonObject = new JSONObject(s);
                            if (jsonObject != null) {
                                JSONArray items = jsonObject.optJSONArray("items");
                                if (items != null) {
                                    int itemLength = items.length();
                                    for (int i = 0; i < itemLength; i++) {
                                        MainItemBean mainItemBean = new MainItemBean(items.optJSONObject(i));
                                        mainItemBeanList.add(mainItemBean);
                                        if (i < 8) {
                                            articles += mainItemBean.getId();
                                            if (i != 7) {
                                                articles += ",";
                                            }
                                        }
                                    }
                                    mNewsView.UpdatePage(mainItemBeanList);

                                }
                            }
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    mNewsView.ShowToast("数据加载失败");
                }

                @Override
                protected String doInBackground(String... params) {
                    return NetUtil.httpGetUtil(mContext, Urls.ARTICLE_LIST_REFRESH + "&readarticles=[" + articles + "]&rqcnt=" + rqcnt + "&r=519baad91478749" + r);
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }

    @Override
    public void LoadNetMoreData(String info) {

    }

    @Override
    public void LoadLocalData(String info) {

    }
}
