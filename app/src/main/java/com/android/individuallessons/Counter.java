package com.android.individuallessons;

import android.os.Parcel;
import android.os.Parcelable;

public class Counter implements Parcelable {

    public static final Creator<Counter> CREATOR = new Creator<Counter> () {
        @Override
        public Counter createFromParcel(Parcel in) {
            return new Counter ( in );
        }

        @Override
        public Counter[] newArray(int size) {
            return new Counter[size];
        }
    };
    private final String name;
    private int counter = 0;

    public Counter(String name, int counter) {
        this.name = name;
        this.counter = counter;
    }

    protected Counter(Parcel in) {
        name = in.readString ();
        counter = in.readInt ();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString ( name );
        dest.writeInt ( counter );
    }

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }
}
