package com.example.customlist_car;

public class Car_brand_Model
{
  private int car_brand_image;
  private String car_brand_name;

  public Car_brand_Model(int car_brand_image,String car_brand_name){
      this.car_brand_image=car_brand_image;
      this.car_brand_name=car_brand_name;

  }

    public int getCar_brand_image() {
        return car_brand_image;
    }

    public void setCar_brand_image(int car_brand_image) {
        this.car_brand_image = car_brand_image;
    }

    public String getCar_brand_name() {
        return car_brand_name;
    }

    public void setCar_brand_name(String car_brand_name) {
        this.car_brand_name = car_brand_name;
    }
}
