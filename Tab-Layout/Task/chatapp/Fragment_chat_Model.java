package com.example.chatapp;

public class Fragment_chat_Model
{
    private int chat_fragment_image;
    private String chat_fragment_name;
    private String chat_fragment_phone_number;
    private String chat_fragment_adress;

    public Fragment_chat_Model(int chat_fragment_image,String chat_fragment_name,String chat_fragment_phone_number,String chat_fragment_adress){
        this.chat_fragment_image=chat_fragment_image;
        this.chat_fragment_name=chat_fragment_name;
        this.chat_fragment_phone_number=chat_fragment_phone_number;
        this.chat_fragment_adress=chat_fragment_adress;

    }
    // Getter Setter method

    public int getChat_fragment_image() {
        return chat_fragment_image;
    }

    public void setChat_fragment_image(int chat_fragment_image) {
        this.chat_fragment_image = chat_fragment_image;
    }

    public String getChat_fragment_name() {
        return chat_fragment_name;
    }

    public void setChat_fragment_name(String chat_fragment_name) {
        this.chat_fragment_name = chat_fragment_name;
    }
    public String getChat_fragment_phone_number(){
        return chat_fragment_phone_number;
    }

    public void setChat_fragment_phone_number(String chat_fragment_phone_number) {
        this.chat_fragment_phone_number = chat_fragment_phone_number;
    }

    public String getChat_fragment_adress() {
        return chat_fragment_adress;
    }

    public void setChat_fragment_adress(String chat_fragment_adress) {
        this.chat_fragment_adress = chat_fragment_adress;
    }
}
