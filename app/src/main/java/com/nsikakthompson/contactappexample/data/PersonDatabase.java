package com.nsikakthompson.contactappexample.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Nsikak on 2/16/18.
 */
@Database(entities = {Person.class}, version = 1)
public abstract class PersonDatabase extends RoomDatabase {

    public  abstract PersonDao personDao();
}
