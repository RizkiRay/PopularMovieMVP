package com.raycoding.popularmoviemvp.utils.base;

import android.support.annotation.StringRes;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 04/05/18.
 */

public interface MvpView {
    void showLoading();

    void hideLoading();
    
    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();
}
