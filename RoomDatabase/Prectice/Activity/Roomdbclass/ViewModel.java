package com.example.roomdbexam.Activity.Roomdbclass;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel
{
    private AppRepository repository;
    private LiveData<List<UserModel>>alldata;


    public ViewModel(@NonNull Application application) {
        super(application);
        repository=new AppRepository(application);
        alldata=repository.getAllData();

    }
    public void insert(UserModel userModel){
        repository.insert(userModel);
    }
    public void update(UserModel userModel){
        repository.update(userModel);
    }
    public void delete(UserModel model){
        repository.delete(model);
    }
    public LiveData<List<UserModel>> getAllData_(){
        return alldata;
    }
}
