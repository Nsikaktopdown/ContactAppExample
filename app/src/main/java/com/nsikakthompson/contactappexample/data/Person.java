package com.nsikakthompson.contactappexample.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nsikak on 2/15/18.
 */
@Entity(tableName = Person.TABLE_NAME)
public class Person {

    public static final String TABLE_NAME = "my_contacts";

    @Ignore
    @SerializedName("data")
    List<Person> data;


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    public String contactName;

    @SerializedName("phone")
    @ColumnInfo(name = "phone")
    public String contactPhone;

    @ColumnInfo(name = "photo")
    @SerializedName("photo")
    public  String photoUrl;

    public Person(int id, String contactName, String contactPhone, String photoUrl) {
        this.id = id;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.photoUrl = photoUrl;
    }

    public List<Person> getData() {
        return data;
    }

    public void setData(List<Person> data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Person() {

    }



}
