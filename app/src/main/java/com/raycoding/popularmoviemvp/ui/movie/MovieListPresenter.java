package com.raycoding.popularmoviemvp.ui.movie;

import android.util.Log;

import com.raycoding.popularmoviemvp.data.DataManager;
import com.raycoding.popularmoviemvp.data.network.model.MovieResponse;
import com.raycoding.popularmoviemvp.ui.base.BasePresenter;
import com.raycoding.popularmoviemvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 04/05/18.
 */

public class MovieListPresenter<V extends MovieListMvpView> extends BasePresenter<V> implements MovieListMvpPresenter<V> {
    private static final String TAG = "MovieListPresenter";
    @Inject
    public MovieListPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        getMovies();
    }

    private void getMovies() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager().getPopularMovies(1)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<MovieResponse>() {
                    @Override
                    public void accept(MovieResponse movieResponse) {
                        getMvpView().hideLoading();
                        if (movieResponse.getResults().size() > 0)
                            getMvpView().setupRecyclerView(movieResponse.getResults());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "accept: " + throwable.getCause());
                        getMvpView().hideLoading();
                    }
                }));
    }
}
