package com.nsikakthompson.contactappexample.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.nsikakthompson.contactappexample.api.ContactApiService;
import com.nsikakthompson.contactappexample.data.Person;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Nsikak on 2/15/18.
 */

public class ContactRepoImpl implements ContactRepo {

    public static final String TAG = ContactRepoImpl.class.getSimpleName();


    Context context;
    Person person;
    ContactApiService contactApiService;
    MutableLiveData<List<Person>> contactList = new MutableLiveData<List<Person>>();
    private Disposable searchDisposable;


    public ContactRepoImpl(ContactApiService contactApiService) {
        this.contactApiService = contactApiService;

    }


    @Override
    public void fetchContact() {
        if (searchDisposable != null) {
            searchDisposable.dispose();
        }
        searchDisposable = contactApiService.getContactService()
                .delay(600, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    // Log.d("search", searchString);

                    contactList.postValue(response.getData());

                }, throwable -> Log.d("failed", throwable.getMessage()));


    }

    @Override
    public LiveData<List<Person>> getContact() {


        return contactList;


    }
}