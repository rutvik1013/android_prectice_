package com.example.customlist_car;

public class Car_list_model
{
    private int car_image;
    private String car_name;
    private String car_price;

    public Car_list_model(int car_image,String car_name,String car_price){
        this.car_image=car_image;
        this.car_name=car_name;
        this.car_price=car_price;

    }

    public int getCar_image() {
        return car_image;
    }

    public void setCar_image(int car_image) {
        this.car_image = car_image;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_price() {
        return car_price;
    }

    public void setCar_price(String car_price) {
        this.car_price = car_price;
    }
}
