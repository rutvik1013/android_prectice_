package com.example.chatapp;

public class Fragment_Call_Model
{
    private int call_image;
    private String call_name;
    private String call_date;

    public Fragment_Call_Model(int call_image,String call_name,String call_date){
        this.call_image=call_image;
        this.call_name=call_name;
        this.call_date=call_date;

    }

    public int getCall_image() {
        return call_image;
    }

    public void setCall_image(int call_image) {
        this.call_image = call_image;
    }

    public String getCall_name() {
        return call_name;
    }

    public void setCall_name(String call_name) {
        this.call_name = call_name;
    }

    public String getCall_date() {
        return call_date;
    }

    public void setCall_date(String call_date) {
        this.call_date = call_date;
    }
}
