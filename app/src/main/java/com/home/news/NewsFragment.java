package com.home.news;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dveeale.sharkmvpdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private NewsView mNewsView;
    private NewsPresonter mNewsPresonter;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_news, container, false);
        mNewsView.setPresenter(mNewsPresonter);
        mNewsView.initViews(view);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mNewsView=new NewsView(context);
        mNewsPresonter=new NewsPresonter(context,mNewsView);
    }
}
