package com.nsikakthompson.contactappexample.repo;

import android.arch.lifecycle.LiveData;

import com.nsikakthompson.contactappexample.data.Person;

import java.util.List;

/**
 * Created by Nsikak on 2/15/18.
 */

public interface ContactRepo
{
   void fetchContact();

    LiveData<List<Person>> getContact();
}
