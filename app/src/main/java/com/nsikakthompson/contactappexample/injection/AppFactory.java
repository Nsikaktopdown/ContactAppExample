package com.nsikakthompson.contactappexample.injection;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.nsikakthompson.contactappexample.AppController;

/**
 * Created by Nsikak on 2/15/18.
 */

public class AppFactory extends ViewModelProvider.NewInstanceFactory {

    private AppController application;

    public AppFactory(AppController application) {
        this.application = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        T t = super.create(modelClass);
        if (t instanceof AppComponent.Injectable) {
            ((AppComponent.Injectable) t).inject(application.getAppComponent());
        }
        return t;
    }
}
