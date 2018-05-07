package com.raycoding.popularmoviemvp.ui.movie.detail;

import com.raycoding.popularmoviemvp.data.DataManager;
import com.raycoding.popularmoviemvp.ui.base.BasePresenter;
import com.raycoding.popularmoviemvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 07/05/18.
 */

public class MovieDetailPresenter<V extends MovieDetailMvpView> extends BasePresenter<V> implements MovieDetailMvpPresenter<V> {
    @Inject
    public MovieDetailPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
