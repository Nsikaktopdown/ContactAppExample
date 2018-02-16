package com.nsikakthompson.contactappexample;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.nsikakthompson.contactappexample.injection.AppComponent;
import com.nsikakthompson.contactappexample.injection.AppModule;
import com.nsikakthompson.contactappexample.injection.DaggerAppComponent;

/**
 * Created by Nsikak on 2/15/18.
 */

public class AppController extends Application {

    private final AppComponent appComponent = createAppComponent();

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
    }

    protected AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}