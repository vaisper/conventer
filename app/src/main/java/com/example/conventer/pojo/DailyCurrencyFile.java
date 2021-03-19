package com.example.conventer.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

public class DailyCurrencyFile implements Parcelable {
    private String PrevURL;
    private HashMap<String, DailyCurrency> Valute;

    public DailyCurrencyFile(String previousURL, HashMap<String, DailyCurrency> valute) {
        PrevURL = previousURL;
        Valute = valute;
    }

    protected DailyCurrencyFile(Parcel in) {
        PrevURL = in.readString();
    }

    public static final Creator<DailyCurrencyFile> CREATOR = new Creator<DailyCurrencyFile>() {
        @Override
        public DailyCurrencyFile createFromParcel(Parcel in) {
            return new DailyCurrencyFile(in);
        }

        @Override
        public DailyCurrencyFile[] newArray(int size) {
            return new DailyCurrencyFile[size];
        }
    };


    public String getPrevURL() {
        return PrevURL;
    }


    public Map<String, DailyCurrency> getValute() {
        return Valute;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(PrevURL);
    }
}
