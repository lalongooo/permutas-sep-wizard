package com.permutassep.inegifacil.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class State implements Parcelable {

    @Expose
    private int id;
    private String mStateName;

    public State(int id, String stateName) {
        this.id = id;
        this.mStateName = stateName;
    }

    public String getStateName() {
        return mStateName;
    }
    public void setStateName(String stateName) {
        this.mStateName = stateName;
    }
    public int getId() {
        return id;
    }
    public void setId(int iD) {
        id = iD;
    }

    @Override
    public int describeContents() {
        return id;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(mStateName);
    }
}
