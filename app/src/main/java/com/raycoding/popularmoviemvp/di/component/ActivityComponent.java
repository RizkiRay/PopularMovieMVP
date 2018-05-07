package com.raycoding.popularmoviemvp.di.component;

import com.raycoding.popularmoviemvp.di.PerActivity;
import com.raycoding.popularmoviemvp.di.module.ActivityModule;
import com.raycoding.popularmoviemvp.ui.movie.MovieListActivity;
import com.raycoding.popularmoviemvp.ui.movie.detail.MovieDetailActivity;

import dagger.Component;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 03/05/18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MovieListActivity activity);

    void inject(MovieDetailActivity activity);
}
