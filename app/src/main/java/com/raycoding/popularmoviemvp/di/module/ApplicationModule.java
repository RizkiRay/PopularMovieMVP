package com.raycoding.popularmoviemvp.di.module;

import android.app.Application;
import android.content.Context;

import com.raycoding.popularmoviemvp.data.AppDataManager;
import com.raycoding.popularmoviemvp.data.DataManager;
import com.raycoding.popularmoviemvp.data.db.AppDbHelper;
import com.raycoding.popularmoviemvp.data.db.DbHelper;
import com.raycoding.popularmoviemvp.data.db.DbOpenHelper;
import com.raycoding.popularmoviemvp.data.network.ApiHelper;
import com.raycoding.popularmoviemvp.data.network.AppApiHelper;
import com.raycoding.popularmoviemvp.data.prefs.AppPreferencesHelper;
import com.raycoding.popularmoviemvp.data.prefs.PreferencesHelper;
import com.raycoding.popularmoviemvp.di.ApplicationContext;
import com.raycoding.popularmoviemvp.di.DatabaseInfo;
import com.raycoding.popularmoviemvp.di.PreferenceInfo;
import com.raycoding.popularmoviemvp.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 03/05/18.
 */

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providePrefName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePrefHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }
}
