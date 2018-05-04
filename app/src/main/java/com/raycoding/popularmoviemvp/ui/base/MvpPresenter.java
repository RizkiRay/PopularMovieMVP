package com.raycoding.popularmoviemvp.ui.base;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 04/05/18.
 */

public interface MvpPresenter<V extends MvpView> {
    void onAttach(V mvpView);
    void onDetach();
}
