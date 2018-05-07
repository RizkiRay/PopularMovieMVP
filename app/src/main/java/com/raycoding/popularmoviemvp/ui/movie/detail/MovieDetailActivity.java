package com.raycoding.popularmoviemvp.ui.movie.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.raycoding.popularmoviemvp.R;
import com.raycoding.popularmoviemvp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 07/05/18.
 */

public class MovieDetailActivity extends BaseActivity implements MovieDetailMvpView {

    @Inject
    MovieDetailMvpPresenter<MovieDetailMvpView> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar_layout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.title)
    TextView mToolbarTitle;
//
    @BindView(R.id.image_poster)
    ImageView mImagePoster;
//    @BindView(R.id.image_favorite)
//    ImageView mImageFavorite;

    public static Intent getStartIntent(Context context) {
        Intent i = new Intent(context, MovieDetailActivity.class);
        return i;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        getActivityComponent().inject(this);
        setUnbinder(ButterKnife.bind(this));

//        Glide.with(this).load(R.drawable.uday_teguh)
//                .apply(new RequestOptions().centerCrop())
//                .into(mImagePoster);
//        Glide.with(this).load(R.drawable.ic_favorite_border)
//                .apply(new RequestOptions().centerCrop())
//                .into(mImageFavorite);

        mPresenter.onAttach(this);
        setUp();
    }

    @Override
    protected void setUp() {
        mToolbar.setTitle("Detail");
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
//        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            int scrollRange = -1;
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                //Initialize the size of the scroll
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                //Check if the view is collapsed
//                if (scrollRange + verticalOffset == 0) {
////                    toolbar.setBackgroundColor(ContextCompat.getColor(MovieDetailActivity.this, R.color.colorPrimary));
//                    mToolbarTitle.setText(getString(R.string.app_name));
//                } else {
//                    getSupportActionBar().setTitle(" ");
//                    mToolbarTitle.setText(" ");
//                }
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
