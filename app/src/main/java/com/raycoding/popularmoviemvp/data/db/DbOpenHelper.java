package com.raycoding.popularmoviemvp.data.db;

import android.content.Context;

import com.raycoding.popularmoviemvp.data.db.model.DaoMaster;
import com.raycoding.popularmoviemvp.di.ApplicationContext;
import com.raycoding.popularmoviemvp.di.DatabaseInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper {
    @Inject
    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        super(context, name);
    }
}
