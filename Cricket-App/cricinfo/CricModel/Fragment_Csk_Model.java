package com.example.cricinfo.CricModel;

public class Fragment_Csk_Model
{
    private int csk_player_image;
    private String csk_player_name;
    private String csk_player_role;

    public Fragment_Csk_Model(int csk_player_image,String csk_player_name,String csk_player_role){
        this.csk_player_image=csk_player_image;
        this.csk_player_name=csk_player_name;
        this.csk_player_role=csk_player_role;

    }

    public int getCsk_player_image() {
        return csk_player_image;
    }

    public void setCsk_player_image(int csk_player_image) {
        this.csk_player_image = csk_player_image;
    }

    public String getCsk_player_name() {
        return csk_player_name;
    }

    public void setCsk_player_name(String csk_player_name) {
        this.csk_player_name = csk_player_name;
    }

    public String getCsk_player_role() {
        return csk_player_role;
    }

    public void setCsk_player_role(String csk_player_role) {
        this.csk_player_role = csk_player_role;
    }
}
