package com.nsikakthompson.contactappexample.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.nsikakthompson.contactappexample.api.ContactApiService;
import com.nsikakthompson.contactappexample.data.Person;
import com.nsikakthompson.contactappexample.injection.AppComponent;
import com.nsikakthompson.contactappexample.repo.ContactRepo;

import java.util.List;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Nsikak on 2/15/18.
 */

public class MainAcivityViewmodel extends ViewModel implements AppComponent.Injectable {

    public static final String TAG = MainAcivityViewmodel.class.getSimpleName();
    @Inject
    ContactRepo contactRepo;
    @Inject
    Retrofit retrofit;
    @Inject
    Gson gson;
    @Inject
    OkHttpClient okHttpClient;
    @Inject
    ContactApiService contactApiService;


    @Override
    public void inject(AppComponent appComponent) {
        appComponent.inject(this);
        contactRepo.fetchContact();


    }

    public LiveData<List<Person>> getContact() {

        return contactRepo.getContact();
    }


}
