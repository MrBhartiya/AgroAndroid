package com.mrbhartiya.education.ui.view;

import android.content.Context;

import java.util.List;


public interface BaseView {

    /*Required to implement for Activity
     * Not required to implement for Fragment
     * */
    public Context getContext();

    /*implemented in BaseActivity and BaseFragment*/
    public void enableLoadingBar(boolean enable);

    /*implemented in BaseActivity and BaseFragment*/
    public void onError(String reason);

    /*implemented in BaseActivity and BaseFragment*/
    public void onInfo(String message);



    /*implemented in BaseActivity and BaseFragment*/
    public void onForceUpdate();

    /*implemented in BaseActivity and BaseFragment*/
    public void onSoftUpdate();


}
