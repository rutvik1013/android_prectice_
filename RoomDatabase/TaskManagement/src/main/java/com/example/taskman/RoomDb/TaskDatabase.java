package com.example.taskman.RoomDb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {TaskModel.class},version = 1)
public abstract class TaskDatabase extends RoomDatabase
{
    public abstract TaskDao taskDao();

    public static TaskDatabase instance;
    public static synchronized TaskDatabase getInstance(Context context){
        if (instance==null){
            instance=Room.databaseBuilder(context.getApplicationContext(),
                    TaskDatabase.class,"task_table")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
