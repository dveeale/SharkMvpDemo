package com.home;

/**
 * Created by dveeale on 16/12/27.
 */

public class HomePresonter implements HomeContarct.Presenter{
    HomeContarct.View mHomeView;

    public HomePresonter(HomeContarct.View mHomeView){
        this.mHomeView=mHomeView;
    }

    @Override
    public void start() {

    }
}
