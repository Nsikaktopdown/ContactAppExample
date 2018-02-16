package com.nsikakthompson.contactappexample.injection;

import com.nsikakthompson.contactappexample.ui.MainAcivityViewmodel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Nsikak on 2/15/18.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainAcivityViewmodel mainAcivityViewmodel);

    interface  Injectable{
        void inject(AppComponent appComponent);

    }
}
