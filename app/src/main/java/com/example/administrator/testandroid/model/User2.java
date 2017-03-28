package com.example.administrator.testandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017-3-28.
 */

public class User2 implements Parcelable {
    private  int id;
    private String name;

    public User2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected User2(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<User2> CREATOR = new Creator<User2>() {
        @Override
        public User2 createFromParcel(Parcel in) {
            return new User2(in.readInt(),in.readString());
        }

        @Override
        public User2[] newArray(int size) {
            return new User2[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(id);
        parcel.writeString(name);
    }
}
