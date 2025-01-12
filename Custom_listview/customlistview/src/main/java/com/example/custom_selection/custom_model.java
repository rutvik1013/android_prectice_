package com.example.custom_selection;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class custom_model  implements Parcelable {
    private int image;
    private String name;
    private String phone_number;
    private boolean isSelected;


    // Constructor
    public custom_model(int image,String name,String phone_number){
        this.image=image;
        this.name=name;
        this.phone_number=phone_number;
        this.isSelected=false;
    }
    protected custom_model(Parcel in){
        image=in.readInt();
        name=in.readString();
        phone_number=in.readString();

    }

    public static final Creator<custom_model> CREATOR = new Creator<custom_model>() {
        @Override
        public custom_model createFromParcel(Parcel in) {
            return new custom_model(in);
        }

        @Override
        public custom_model[] newArray(int size) {
            return new custom_model[size];
        }
    };

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(name);
        parcel.writeString(phone_number);
    }
}
