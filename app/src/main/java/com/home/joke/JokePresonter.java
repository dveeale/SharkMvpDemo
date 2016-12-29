package com.home.joke;

import android.content.Context;
import android.os.AsyncTask;

import com.bean.MainItemBean;
import com.home.news.NewsView;
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
 * Created by dveeale on 16/12/28.
 */

public class JokePresonter implements JokeContarct.Presenter{

    private Context mContext;
    private JokeView mJokeView;


    private List<MainItemBean> mainItemBeanList = new ArrayList<>();
    private int rqcnt = 18;
    private int page = 1;

    private int r = 56712;

    private String articles = "11793" + new Random().nextInt(10) + new Random().nextInt(10) + new Random().nextInt(10) + new Random().nextInt(10);


    public JokePresonter(Context mContext,JokeView mJokeView){
        this.mContext=mContext;
        this.mJokeView=mJokeView;
    }

    @Override
    public void LoadNetData(String info) {{
        {
            mJokeView.StopListRefresh();
            page=1;
            rqcnt += 2;
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
                                    mainItemBeanList.clear();
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
                                    mJokeView.UpdatePage(mainItemBeanList);

                                }
                            }
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    mJokeView.ShowToast("数据加载失败");
                }

                @Override
                protected String doInBackground(String... params) {
                    return NetUtil.httpGetUtil(mContext, Urls.ARTICLE_LIST_REFRESH + "&readarticles=[" + articles + "]&rqcnt=" + rqcnt + "&r=519baad91478749" + r);
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }

    }

    @Override
    public void LoadNetMoreData(String info) {{
        {
            page++;
            r += new Random().nextInt(1000000);
            rqcnt += 2;
            new AsyncTask<String, String, String>() {
                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    try {
                        mJokeView.StopListLoadMore();
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
                                        int t = new Random().nextInt(30);
                                        if (t == 0) {
                                            t += 1;
                                        }
                                        if (i < t) {
                                            articles += mainItemBean.getId();
                                            if (i != t - 1) {
                                                articles += ",";
                                            }
                                        }
                                    }

                                    mJokeView.UpdatePage(mainItemBeanList);
                                }
                            }
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    mJokeView.ShowToast("数据加载失败");
                }

                @Override
                protected String doInBackground(String... params) {
                    return NetUtil.httpGetUtil(mContext, Urls.ARTICLE_LIST_LOAD_MORE + "page=" + page + "&readarticles=[" + articles + "]&rqcnt=" + rqcnt + "&r=519baad91478749" + r);
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }

    }

    @Override
    public void LoadLocalData(String info) {

    }

    @Override
    public void start() {

    }
}
