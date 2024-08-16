package com.example.roomdbexam.Activity.Roomdbclass;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    private int id;


    private String name;
    private String age;
    private String email;
    private String password;

    // Created Construster
    public UserModel(int id,String name,String age,String email,String password){
        this.id=id;
        this.name=name;
        this.age=age;
        this.email=email;
        this.password=password;
    }

    // Getter And Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

