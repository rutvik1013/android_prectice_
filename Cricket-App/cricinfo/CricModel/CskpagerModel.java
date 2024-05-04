package com.example.cricinfo.CricModel;

public class CskpagerModel
{
    private int c_image;
    private String c_name;
    private String c_country;
    private String born;
    private String birth_place;
    private String nickname;
    private String role;
    private String batting_style;
    private String bowling_style;

    public CskpagerModel(int c_image,String c_name,String c_country,String born,String birth_place,String nickname,String role,String batting_style,String bowling_style){
        this.c_image=c_image;
        this.c_name=c_name;
        this.c_country=c_country;
        this.born=born;
        this.birth_place=birth_place;
        this.nickname=nickname;
        this.role=role;
        this.batting_style=batting_style;
        this.bowling_style=bowling_style;
    }

    public int getC_image() {
        return c_image;
    }

    public void setC_image(int c_image) {
        this.c_image = c_image;
    }
    public String getC_name(){
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_country() {
        return c_country;
    }

    public void setC_country(String c_country) {
        this.c_country = c_country;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBatting_style() {
        return batting_style;
    }

    public void setBatting_style(String batting_style) {
        this.batting_style = batting_style;
    }

    public String getBowling_style() {
        return bowling_style;
    }

    public void setBowling_style(String bowling_style) {
        this.bowling_style = bowling_style;
    }
}
