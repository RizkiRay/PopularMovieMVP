package com.raycoding.popularmoviemvp.ui.movie;

import com.raycoding.popularmoviemvp.data.DataManager;
import com.raycoding.popularmoviemvp.ui.base.BasePresenter;
import com.raycoding.popularmoviemvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 04/05/18.
 */

public class MovieListPresenter<V extends MovieListMvpView> extends BasePresenter<V> implements MovieListMvpPresenter<V> {
    @Inject
    public MovieListPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
