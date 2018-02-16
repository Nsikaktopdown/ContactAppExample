package com.nsikakthompson.contactappexample.data;

import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nsikak on 2/15/18.
 */
@Entity
public class Person {

    public  Person(){

    }

    @SerializedName("data")
    List<Person> data;
    @SerializedName("name")
    private  String mContactName;
    @SerializedName("phone")
    private  String mContactPhone;
    @SerializedName("photo")
    private  String mPhotoUrl;


    public List<Person> getData() {
        return data;
    }

    public void setData(List<Person> data) {
        this.data = data;
    }

    public String getmPhotoUrl() {
        return mPhotoUrl;
    }

    public void setmPhotoUrl(String mPhotoUrl) {
        this.mPhotoUrl = mPhotoUrl;
    }

    @Override
    public String toString() {
        return "Person{" +
                "mContactName='" + mContactName + '\'' +
                ", mContactPhone='" + mContactPhone + '\'' +
                '}';
    }

    public String getmContactName() {
        return mContactName;
    }

    public void setmContactName(String mContactName) {
        this.mContactName = mContactName;
    }

    public String getmContactPhone() {
        return mContactPhone;
    }

    public void setmContactPhone(String mContactPhone) {
        this.mContactPhone = mContactPhone;
    }
}
