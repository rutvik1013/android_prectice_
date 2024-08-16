package com.example.roomdbexam.Activity.Roomdbclass;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao
{
    // For Insert the data
    @Insert
    void insertdata(UserModel userModel);

    // For Update the data
    @Update
    void updatedata(UserModel userModel);

    // For Delete the data
    @Delete
    void deletedata(UserModel userModel);

    // read all the courses from our database.
    // in this we are ordering our courses in ascending order
    // with our course name.

    @Query("SELECT * FROM user")
    LiveData<List<UserModel>>getAllData();

    // on below line we are making query to
    // delete all data from our database.

    @Query("DELETE FROM user")
    void deleteAllData();
}
