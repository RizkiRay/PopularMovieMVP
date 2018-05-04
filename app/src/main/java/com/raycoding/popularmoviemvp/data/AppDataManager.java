package com.raycoding.popularmoviemvp.data;

import android.content.Context;

import com.raycoding.popularmoviemvp.data.db.DbHelper;
import com.raycoding.popularmoviemvp.data.db.model.Movie;
import com.raycoding.popularmoviemvp.data.network.ApiHelper;
import com.raycoding.popularmoviemvp.data.network.model.MovieResponse;
import com.raycoding.popularmoviemvp.data.prefs.PreferencesHelper;
import com.raycoding.popularmoviemvp.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 03/05/18.
 */

@Singleton
public class AppDataManager implements DataManager {

    private Context mContext;
    private DbHelper mDbHelper;
    private ApiHelper mApiHelper;
    private PreferencesHelper mPreferencesHelper;

    @Inject
    AppDataManager(@ApplicationContext Context context, DbHelper dbHelper, ApiHelper apiHelper, PreferencesHelper prefHelper){
        mContext = context;
        mDbHelper = dbHelper;
        mApiHelper = apiHelper;
        mPreferencesHelper = prefHelper;
    }

    @Override
    public Observable<Long> insertMovie(Movie movie) {
        return mDbHelper.insertMovie(movie);
    }

    @Override
    public Observable<List<Movie>> getAllMovies() {
        return mDbHelper.getAllMovies();
    }

    @Override
    public Observable<Movie> getMovieById(Long movieId) {
        return mDbHelper.getMovieById(movieId);
    }

    @Override
    public Observable<Boolean> saveMovie(Movie movie) {
        return mDbHelper.saveMovie(movie);
    }

    @Override
    public Observable<MovieResponse> getPopularMovies(int page) {
        return mApiHelper.getPopularMovies(page);
    }

    @Override
    public Observable<MovieResponse> getTopRatedMovies(int page) {
        return mApiHelper.getTopRatedMovies(page);
    }
}
