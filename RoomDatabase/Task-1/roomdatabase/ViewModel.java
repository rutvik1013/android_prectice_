package com.example.roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private AppRepository repository;
    Dao dao;
    private LiveData<List<UserModel>> allUsers;
    private MutableLiveData<String> selectedItemCount = new MutableLiveData<>();

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new AppRepository(application);
        allUsers = repository.getallDetails();
    }

    public LiveData<List<UserModel>> getAllUsers() {
        return allUsers;
    }

    public void insert(UserModel user) {
        repository.insert(user);
    }

    public void update(UserModel user) {
        repository.update(user);
    }

    public void delete(UserModel user) {
        repository.delete(user);
    }


    public LiveData<String> getSelectedItemCount() {
        return selectedItemCount;
    }

    public void setText(String text) {
        selectedItemCount.setValue(text);
    }
    // create get text method
    public MutableLiveData<String>getText(){
        return selectedItemCount;
    }
}
