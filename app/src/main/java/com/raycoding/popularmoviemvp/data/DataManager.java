package com.raycoding.popularmoviemvp.data;

import com.raycoding.popularmoviemvp.data.db.DbHelper;
import com.raycoding.popularmoviemvp.data.network.ApiHelper;
import com.raycoding.popularmoviemvp.data.prefs.PreferencesHelper;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 03/05/18.
 */

public interface DataManager extends DbHelper, ApiHelper, PreferencesHelper {
}
