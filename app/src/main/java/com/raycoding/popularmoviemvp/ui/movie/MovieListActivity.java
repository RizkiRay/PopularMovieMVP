package com.raycoding.popularmoviemvp.ui.movie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.raycoding.popularmoviemvp.R;
import com.raycoding.popularmoviemvp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 04/05/18.
 */

public class MovieListActivity extends BaseActivity implements MovieListMvpView {

    @Inject
    MovieListMvpPresenter<MovieListMvpView> mPresenter;

    @BindView(R.id.text_view)
    TextView mTextView;

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
}
