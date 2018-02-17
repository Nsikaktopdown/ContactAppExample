package com.nsikakthompson.contactappexample.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Nsikak on 2/16/18.
 */
@Dao
public interface PersonDao {
    @Query("SELECT * FROM " + Person.TABLE_NAME )
    LiveData<List<Person>> getAllContacts();

    @Insert(onConflict = REPLACE)
    void addContact(List<Person> person);

}
