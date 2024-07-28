package com.example.sqlitedbtask;

public class detailsModel
{
    private int id;
    private String date;
    private String name;
    private String phone_number;
    private String email;
    private String adress;

    public detailsModel(){
        this.id=id;
        this.date=date;
        this.name=name;
        this.phone_number=phone_number;
        this.email=email;
        this.adress=adress;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
