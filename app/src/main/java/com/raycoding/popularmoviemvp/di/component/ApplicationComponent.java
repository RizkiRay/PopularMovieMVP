package com.raycoding.popularmoviemvp.di.component;

import android.app.Application;
import android.content.Context;

import com.raycoding.popularmoviemvp.MyApp;
import com.raycoding.popularmoviemvp.data.DataManager;
import com.raycoding.popularmoviemvp.di.ApplicationContext;
import com.raycoding.popularmoviemvp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 03/05/18.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MyApp app);

    @ApplicationContext
    Context context();

    Application application();
    DataManager getDataManager();
}
