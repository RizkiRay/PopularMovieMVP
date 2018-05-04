package com.raycoding.popularmoviemvp.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.raycoding.popularmoviemvp.di.ActivityContext;
import com.raycoding.popularmoviemvp.ui.movie.MovieListMvpPresenter;
import com.raycoding.popularmoviemvp.ui.movie.MovieListMvpView;
import com.raycoding.popularmoviemvp.ui.movie.MovieListPresenter;
import com.raycoding.popularmoviemvp.utils.rx.AppSchedulerProvider;
import com.raycoding.popularmoviemvp.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 03/05/18.
 */

@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity context) {
        return new LinearLayoutManager(context);
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    MovieListMvpPresenter<MovieListMvpView> provideMoviePresenter(MovieListPresenter<MovieListMvpView> presenter){
        return presenter;
    }
}
