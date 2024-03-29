package com.example.ipl;

public class Dc_Model
{
    private int dc_image;
    private String dc_player_name;

    public Dc_Model(int dc_image,String dc_player_name){
        this.dc_image=dc_image;
        this.dc_player_name=dc_player_name;
    }
    public int getDc_image(){
        return dc_image;
    }
    public void setDc_image(int dc_image){
        this.dc_image=dc_image;
    }
    public String getDc_player_name(){
        return dc_player_name;
    }
    public void setDc_player_name(String dc_player_name){
        this.dc_player_name=dc_player_name;
    }
}
