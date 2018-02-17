package com.nsikakthompson.contactappexample.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.nsikakthompson.contactappexample.api.ContactApiService;
import com.nsikakthompson.contactappexample.data.Person;
import com.nsikakthompson.contactappexample.data.PersonDatabase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Nsikak on 2/15/18.
 */

public class ContactRepoImpl implements ContactRepo {

    public static final String TAG = ContactRepoImpl.class.getSimpleName();


    Context context;
    ContactApiService contactApiService;
    MutableLiveData<List<Person>> contactList = new MutableLiveData<List<Person>>();
    private Disposable searchDisposable;
    @Inject
    PersonDatabase personDatabase;
    private Person person;


    public ContactRepoImpl(ContactApiService contactApiService, PersonDatabase personDatabase) {
        this.contactApiService = contactApiService;
        this.personDatabase = personDatabase;

    }


    @Override
    public void addContact() {
        if (searchDisposable != null) {
            searchDisposable.dispose();
        }
        searchDisposable = contactApiService.getContactService()
                .delay(600, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.computation())
                .subscribe(response -> {
                     Log.d("contacts", response.getData().get(0).contactName);
                    personDatabase.personDao().addContact(response.getData());

                }, throwable -> Log.d("failed", throwable.getMessage()));





    }

    @Override
    public LiveData<List<Person>> getContact() {

        return personDatabase.personDao().getAllContacts();


    }
}