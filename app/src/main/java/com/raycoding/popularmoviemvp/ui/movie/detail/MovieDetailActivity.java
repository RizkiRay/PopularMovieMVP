package com.raycoding.popularmoviemvp.ui.movie.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.raycoding.popularmoviemvp.BuildConfig;
import com.raycoding.popularmoviemvp.R;
import com.raycoding.popularmoviemvp.data.network.model.MovieResult;
import com.raycoding.popularmoviemvp.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 07/05/18.
 */

public class MovieDetailActivity extends BaseActivity implements MovieDetailMvpView {

    private static final String EXTRA_MOVIE = "EXTRA_MOVIE";
    @Inject
    MovieDetailMvpPresenter<MovieDetailMvpView> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar_layout)
    AppBarLayout mAppBarLayout;

    @BindView(R.id.image_poster)
    ImageView mImagePoster;
    @BindView(R.id.text_rate)
    TextView mTextRate;

    @BindView(R.id.image_favorite)
    ImageView mImageFavorite;
    @BindView(R.id.text_title)
    TextView mTextTitle;
    @BindView(R.id.text_release_date)
    TextView mTextReleaseDate;
    @BindView(R.id.text_synopsis)
    TextView mTextSynopsis;

    private MovieResult mMovie;

    public static Intent getStartIntent(Context context, MovieResult movie) {
        Intent i = new Intent(context, MovieDetailActivity.class);
        i.putExtra(EXTRA_MOVIE, movie);
        return i;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        getActivityComponent().inject(this);
        setUnbinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        setUp();
    }

    @Override
    protected void setUp() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        mMovie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        Glide.with(this).load(BuildConfig.IMAGE_URL + mMovie.PosterPath)
                .apply(new RequestOptions().centerCrop())
                .into(mImagePoster);

        mTextTitle.setText(mMovie.OriginalTitle);
        mTextRate.setText(String.valueOf(mMovie.VoteAverage));
        mTextSynopsis.setText(mMovie.Overview);
        mTextReleaseDate.setText(mMovie.ReleaseDate);

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
