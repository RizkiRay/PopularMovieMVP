package com.raycoding.popularmoviemvp.ui.movie;

import com.raycoding.popularmoviemvp.data.network.model.MovieResult;
import com.raycoding.popularmoviemvp.ui.base.MvpView;

import java.util.List;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 04/05/18.
 */

public interface MovieListMvpView extends MvpView {
    void setupRecyclerView(List<MovieResult> movies);
}
