package com.raycoding.popularmoviemvp.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 03/05/18.
 */

public interface SchedulerProvider {
    Scheduler ui();
    Scheduler computation();
    Scheduler io();
}
