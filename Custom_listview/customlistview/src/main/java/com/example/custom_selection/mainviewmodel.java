package com.example.custom_selection;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class mainviewmodel extends ViewModel
{
    // initialize variables
    MutableLiveData<String>mutableLiveData=new MutableLiveData<>();

    public void setText(String s){
        // Set Value
        mutableLiveData.setValue(s);


    }
    // create get text method

    public MutableLiveData<String> getText() {
        return mutableLiveData;
    }
}
