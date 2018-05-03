package com.raycoding.popularmoviemvp.data.db;

import com.raycoding.popularmoviemvp.data.db.model.DaoMaster;
import com.raycoding.popularmoviemvp.data.db.model.DaoSession;
import com.raycoding.popularmoviemvp.data.db.model.Movie;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDbHelper implements DbHelper {
    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Observable<Long> insertMovie(final Movie movie) {
        return Observable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return mDaoSession.getMovieDao().insert(movie);
            }
        });
    }

    @Override
    public Observable<List<Movie>> getAllMovies() {
        return Observable.fromCallable(new Callable<List<Movie>>() {
            @Override
            public List<Movie> call() throws Exception {
                return mDaoSession.getMovieDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Movie> getMovieById(final Long movieId) {
        return Observable.fromCallable(new Callable<Movie>() {
            @Override
            public Movie call() throws Exception {
                return mDaoSession.getMovieDao().load(movieId);
            }
        });
    }

    @Override
    public Observable<Boolean> saveMovie(final Movie movie) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getMovieDao().insert(movie);
                return true;
            }
        });
    }
}
