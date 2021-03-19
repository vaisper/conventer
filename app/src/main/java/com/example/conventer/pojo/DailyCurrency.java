package com.example.conventer.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class DailyCurrency implements Parcelable {
    private final String CharCode;
    private final String ID;
    private final int Nominal;
    private final double Previous;
    private final double Value;
    private final String Name;
    private final String NumCode;


    protected DailyCurrency(Parcel in) {
        ID = in.readString();
        NumCode = in.readString();
        CharCode = in.readString();
        Nominal = in.readInt();
        Name = in.readString();
        Value = in.readDouble();
        Previous = in.readDouble();
    }

    public DailyCurrency(String ID, String numCode, String charCode, int nominal, String name, double value, double previous) {
        this.ID = ID;
        NumCode = numCode;
        CharCode = charCode;
        Nominal = nominal;
        Name = name;
        Value = value;
        Previous = previous;
    }


    public static final Creator<DailyCurrency> CREATOR = new Creator<DailyCurrency>() {
        @Override
        public DailyCurrency createFromParcel(Parcel in) {
            return new DailyCurrency(in);
        }

        @Override
        public DailyCurrency[] newArray(int size) {
            return new DailyCurrency[size];
        }
    };

    public String getID() {
        return ID;
    }

    public String getNumCode() {
        return NumCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public int getNominal() {
        return Nominal;
    }

    public String getName() {
        return Name;
    }

    public double getValue() {
        return Value;
    }

    public double getPrevious() {
        return Previous;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(ID);
        parcel.writeString(CharCode);
        parcel.writeDouble(Value);
        parcel.writeInt(Nominal);
        parcel.writeString(NumCode);
        parcel.writeString(Name);
        parcel.writeDouble(Previous);
    }


    @Override
    public int describeContents() {
        return 0;
    }
}
