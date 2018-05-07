package com.raycoding.popularmoviemvp;

import android.app.Application;

import com.raycoding.popularmoviemvp.data.DataManager;
import com.raycoding.popularmoviemvp.di.component.ApplicationComponent;
import com.raycoding.popularmoviemvp.di.component.DaggerApplicationComponent;
import com.raycoding.popularmoviemvp.di.module.ApplicationModule;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 03/05/18.
 */

public class MyApp extends Application {
    @Inject
    DataManager mDataManager;

    @Inject
    CalligraphyConfig mCalligraphyConfig;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent mApplicationComponent) {
        this.mApplicationComponent = mApplicationComponent;
    }
}
