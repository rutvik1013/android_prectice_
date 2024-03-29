package com.example.spinner_cutom;

public class Model
{
    private int image;
    private String name;
    private String banifits;

    public Model(String name,int image,String banifits){
        this.name=name;
        this.image=image;
        this.banifits=banifits;

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getBanifits(){
        return banifits;
    }
    public void setBanifits(String banifits){
        this.banifits=banifits;
    }
    public int getImage(){
        return image;
    }
    public void setImage(int image){
        this.image=image;
    }
}
