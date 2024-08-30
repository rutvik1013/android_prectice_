package com.example.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao
{
    // For Insert the User
    @Insert
    void insertdetails(UserModel userModel);

    // For Update The data
    @Update
    void updatedetails(UserModel userModel);

    // For Delete The Data
    @Delete
    void deletedetails(UserModel userModel);

    // getall user from usemodel class
    @Query("SELECT * FROM user")
    LiveData<List<UserModel>> getAllDetails();

    // on below line we are making query to
    // delete all data from our database.

    @Query("DELETE FROM user")
    void deleteAllDetails();







}
