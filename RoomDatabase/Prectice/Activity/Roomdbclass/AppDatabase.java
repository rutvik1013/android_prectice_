package com.example.roomdbexam.Activity.Roomdbclass;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {UserModel.class},version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    private static AppDatabase instance;
    public abstract Dao dao();

    public static synchronized AppDatabase getInstance(Context context)
    {
        if (instance==null){
            instance=Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,"app_database")
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return instance;
    }
}