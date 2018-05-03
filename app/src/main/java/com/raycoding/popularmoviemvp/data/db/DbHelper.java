package com.raycoding.popularmoviemvp.data.db;


import com.raycoding.popularmoviemvp.data.db.model.Movie;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {
    Observable<Long> insertMovie(Movie movie);

    Observable<List<Movie>> getAllMovies();

    Observable<Movie> getMovieById(Long movieId);

    Observable<Boolean> saveMovie(Movie movie);
}
