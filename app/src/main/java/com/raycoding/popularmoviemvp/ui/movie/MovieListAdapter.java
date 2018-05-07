package com.raycoding.popularmoviemvp.ui.movie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.raycoding.popularmoviemvp.BuildConfig;
import com.raycoding.popularmoviemvp.R;
import com.raycoding.popularmoviemvp.data.network.model.MovieResult;
import com.raycoding.popularmoviemvp.ui.movie.detail.MovieDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 07/05/18.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private static final String TAG = "MovieListAdapter";
    private Context mContext;
    private List<MovieResult> mMovies;

    MovieListAdapter(List<MovieResult> mMovies) {
        this.mMovies = mMovies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieResult movie = mMovies.get(position);
        Log.i(TAG, "onBindViewHolder: " + BuildConfig.IMAGE_URL + movie.getPosterPath());
        Glide.with(mContext).load(BuildConfig.IMAGE_URL + movie.getPosterPath())
                .apply(new RequestOptions().centerCrop())
                .into(holder.imagePoster);
        holder.textTitle.setText(movie.getOriginalTitle());
        holder.textShortDesc.setText(movie.getOverview());
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_poster)
        ImageView imagePoster;

        @BindView(R.id.text_title)
        TextView textTitle;

        @BindView(R.id.text_short_desc)
        TextView textShortDesc;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.container)
        void onItemClicked(){
            mContext.startActivity(MovieDetailActivity.getStartIntent(mContext));
        }
    }
}
