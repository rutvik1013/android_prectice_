package com.example.ipl;

public class rcb_model
{
    private int rcb_image;
    private String rcb_player_name;

    public rcb_model(int rcb_image,String rcb_player_name){
        this.rcb_image=rcb_image;
        this.rcb_player_name=rcb_player_name;


    }
    public int getRcb_image(){
        return rcb_image;
    }
    public void setRcb_image(int rcb_image){
        this.rcb_image=rcb_image;
    }
    public String getRcb_player_name(){
        return rcb_player_name;
    }
    public void setRcb_player_name(){
        this.rcb_player_name=rcb_player_name;
    }
}
