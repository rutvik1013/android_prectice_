package com.example.recycleviewex;

public class Model
{
  private int image;
  private String name;
  private String price;

  public Model(int image,String name,String price){
    this.image=image;
    this.name=name;
    this.price=price;

  }
  public Model(String name,String price){
    this.name=name;
    this.price=price;
  }

  public int getImage() {
    return image;
  }

  public void setImage(int image) {
    this.image = image;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}
