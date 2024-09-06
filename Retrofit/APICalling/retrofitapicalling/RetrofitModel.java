package com.example.retrofitapicalling;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class RetrofitModel implements Parcelable
{
    private String name;
    private String realname;
    private String team;
    private String firstappearance;
    private String createdby;
    private String publisher;
    private String imageurl;
    private String bio;


    // Created Constructor


    public RetrofitModel(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }
    // implementing parcelable interface
    protected RetrofitModel(Parcel in){
        name=in.readString();
        realname=in.readString();
        team=in.readString();
        firstappearance=in.readString();
        createdby=in.readString();
        publisher=in.readString();
        imageurl=in.readString();
        bio=in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(realname);
        parcel.writeString(team);
        parcel.writeString(firstappearance);
        parcel.writeString(createdby);
        parcel.writeString(publisher);
        parcel.writeString(imageurl);
        parcel.writeString(bio);
    }
    public static final Creator<RetrofitModel> CREATOR=new Creator<RetrofitModel>() {
        @Override
        public RetrofitModel createFromParcel(Parcel parcel) {
            return new RetrofitModel(parcel);
        }

        @Override
        public RetrofitModel[] newArray(int i) {
            return new RetrofitModel[i];
        }
    };
    // Getter And Setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public void setFirstappearance(String firstappearance) {
        this.firstappearance = firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
