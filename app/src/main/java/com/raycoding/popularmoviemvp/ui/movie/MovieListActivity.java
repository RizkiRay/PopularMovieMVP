package com.raycoding.popularmoviemvp.ui.movie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.raycoding.popularmoviemvp.R;
import com.raycoding.popularmoviemvp.data.network.model.MovieResult;
import com.raycoding.popularmoviemvp.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 04/05/18.
 */

public class MovieListActivity extends BaseActivity implements MovieListMvpView {

    @Inject
    MovieListMvpPresenter<MovieListMvpView> mPresenter;

    @Inject
    GridLayoutManager mGridLayoutManager;

    @BindView(R.id.recyler_movie)
    RecyclerView mRecyclerMovie;
    @BindView(R.id.pbar_loading)
    ProgressBar pbarLoading;

    public static Intent getStartIntent(Context context) {
        Intent i = new Intent(context, MovieListActivity.class);
        return i;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        getActivityComponent().inject(this);
        setUnbinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        setUp();
    }

    @Override
    protected void setUp() {
    }

    @Override
    public void setupRecyclerView(List<MovieResult> movies) {
        MovieListAdapter adapter = new MovieListAdapter(movies);
        mRecyclerMovie.setLayoutManager(mGridLayoutManager);
        mRecyclerMovie.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        super.showLoading();
        pbarLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        pbarLoading.setVisibility(View.GONE);
    }
}
