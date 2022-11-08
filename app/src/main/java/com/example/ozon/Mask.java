package com.example.ozon;

import android.os.Parcel;
import android.os.Parcelable;

public class Mask implements Parcelable {
    private int id;
    private String name;
    private double price;
    private String weight;
    private String nameProiz;
    private String countryProiz;


    
    public Mask(int ID, String Name, Double Price, String Weight, String NameProiz,
                String CountryProiz) {
        this.id = ID;
        name = Name;
        price = Price;
        weight = Weight;
        nameProiz = NameProiz;
        countryProiz = CountryProiz;

    }

    protected Mask(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readDouble();
        weight = in.readString();
        nameProiz = in.readString();
        countryProiz = in.readString();

    }

    public static final Creator<Mask> CREATOR = new Creator<Mask>() {
        @Override
        public Mask createFromParcel(Parcel in) {
            return new Mask(in);
        }

        @Override
        public Mask[] newArray(int size) {
            return new Mask[size];
        }
    };


    public void setID(int ID) {
        this.id = ID;
    }

    public void setName(String Name) {
        name = Name;
    }

    public void setPrice(Double Price) {
        this.price = Price;
    }

    public void setWeight(String Weight) {
        weight = Weight;
    }

    public void setNameProiz(String NameProiz) { nameProiz = NameProiz;}

    public void setCountryProiz(String CountryProiz) { countryProiz = CountryProiz;}



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeDouble(price);
        parcel.writeString(weight);
        parcel.writeString(nameProiz);
        parcel.writeString(countryProiz);

    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getWeight() {
        return weight;
    }

    public String getNameProiz() {
        return nameProiz;
    }

    public String getCountryProiz() { return countryProiz; }


    public int getID() {
        return id;
    }

}