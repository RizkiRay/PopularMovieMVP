package com.raycoding.popularmoviemvp.data.network;

import com.raycoding.popularmoviemvp.data.network.model.MovieResponse;

import io.reactivex.Observable;


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 03/05/18.
 */

public interface ApiHelper {
    Observable<MovieResponse> getPopularMovies(int page);
    Observable<MovieResponse> getTopRatedMovies(int page);
}
