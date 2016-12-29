package com.home.joke;


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
public class JokeFragment extends Fragment {

    private JokeView mJokeView;
    private JokePresonter mJokePresonter;

    public JokeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_joke, container, false);
        mJokeView.setPresenter(mJokePresonter);
        mJokeView.initViews(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mJokeView=new JokeView(context);
        mJokePresonter=new JokePresonter(context,mJokeView);
    }
}
