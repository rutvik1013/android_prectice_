package com.example.recyclerview_crud;

public class Model
{
    private int image;
    private String name;
    private String age;
    private String adress;

    public Model(int image,String name,String age,String adress){
        this.image=image;
        this.name=name;
        this.age=age;
        this.adress=adress;

    }

    public Model(String name,String age,String adress){
        this.name=name;
        this.age=age;
        this.adress=adress;
    }


    // Getter Setter

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
