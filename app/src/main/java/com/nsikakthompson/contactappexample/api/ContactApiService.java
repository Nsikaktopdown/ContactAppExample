package com.nsikakthompson.contactappexample.api;

import com.nsikakthompson.contactappexample.data.Person;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Nsikak on 2/16/18.
 */

public interface ContactApiService {

    @GET("Contact.json")
    @Headers({"Content-Type: application/json", "Host: rawgit.com"})
    Flowable<Person> getContactService();
}
