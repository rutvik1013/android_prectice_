package com.example.ipl;

public class Mi_Model
{
    private int mi_image;
    private String mi_player_name;

    public Mi_Model(int mi_image,String mi_player_name){
        this.mi_image=mi_image;
        this.mi_player_name=mi_player_name;

    }
    public int getMi_image(){
        return mi_image;
    }
    public void setMi_image(int mi_image){
        this.mi_image=mi_image;

    }
    public String getMi_player_name(){
        return mi_player_name;
    }
    public void setMi_player_name(String mi_player_name){
        this.mi_player_name=mi_player_name;
    }
}
