package com.example.customlistview;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class carmodel implements Parcelable {
    private int image;
    private String car_name;
    private String car_price;
    private boolean isSelected;

    // Constructor
    public carmodel(int image,String car_name,String car_price){
        this.image=image;
        this.car_name=car_name;
        this.car_price=car_price;
        this.isSelected=false;
    }
    protected carmodel(Parcel in){
        image=in.readInt();
        car_name=in.readString();
        car_price=in.readString();
        isSelected=in.readByte()!=0;

    }
    public static final Creator<carmodel>CREATOR=new Creator<carmodel>() {
        @Override
        public carmodel createFromParcel(Parcel parcel) {
            return new carmodel(parcel);
        }

        @Override
        public carmodel[] newArray(int i) {
            return new carmodel[i];
        }
    };



    public int getImage() {
        return image;
    }

    public String getCar_name() {
        return car_name;
    }

    public String getCar_price() {
        return car_price;
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
        parcel.writeString(car_name);
        parcel.writeString(car_price);
        parcel.writeByte((byte) (isSelected?1:0));
    }
}
