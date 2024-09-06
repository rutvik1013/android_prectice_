package com.example.taskman.RoomDb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {

    // For Insert the task
    @Insert
    void insertTask(TaskModel taskModel);

    // For Update the task
    @Update
    void updateTask(TaskModel taskModel);

    // For Delete the task
    @Delete
    void deleteTask(TaskModel taskModel);

    // Delete all tasks from the database
    @Query("DELETE FROM task_table")
    void deleteAllTasks();

    // Get all tasks sorted by date and time
    @Query("SELECT * FROM task_table")
    LiveData<List<TaskModel>> getAllTasks();

    @Query("SELECT * FROM task_table ORDER BY task_date ASC")
    LiveData<List<TaskModel>> getTaskByDateAndTime();
}