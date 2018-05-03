package com.raycoding.popularmoviemvp.data.network;

import android.net.Uri;

import com.raycoding.popularmoviemvp.BuildConfig;

import java.net.URL;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 03/05/18.
 */

public final class ApiEndpoint {
    private ApiEndpoint(){}
    private static final String POPULAR_MOVIE_URL = "popular?";
    private static final String TOP_RATED_MOVIE_URL = "top_rated?";

    private static final String PARAM_API_KEY = "api_key";
    private static final String PARAM_PAGE = "page";

    static String getPopularMovieUrl(int page){
        Uri build = Uri.parse(BuildConfig.BASE_URL + POPULAR_MOVIE_URL)
                .buildUpon()
                .appendQueryParameter(PARAM_API_KEY, BuildConfig.API_KEY)
                .appendQueryParameter(PARAM_PAGE, String.valueOf(page))
                .build();
        return build.toString();
    }

    static String getTopRatedMovieUrl(int page){
        Uri build = Uri.parse(BuildConfig.BASE_URL + TOP_RATED_MOVIE_URL)
                .buildUpon()
                .appendQueryParameter(PARAM_API_KEY, BuildConfig.API_KEY)
                .appendQueryParameter(PARAM_PAGE, String.valueOf(page))
                .build();
        return build.toString();
    }
}
