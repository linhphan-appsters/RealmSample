package com.example.linh.realmsample;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

/**
 * Created by linh on 14/06/2017.
 */

public class RealmExampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("examples.realm").build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
