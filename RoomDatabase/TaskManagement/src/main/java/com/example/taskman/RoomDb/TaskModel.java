package com.example.taskman.RoomDb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class TaskModel
{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "task_name")
    private String task_name;

    @ColumnInfo(name = "task_description")
   private String task_description;

    @ColumnInfo(name = "task_date")
   private String task_date;

    @ColumnInfo(name = "task_time")
    private String task_time;

    @ColumnInfo(name = "task_priority")
    private String task_priority;

    // Created Construster
    public TaskModel(int id,String task_name,String task_description,String task_date,String task_time,String task_priority){
        this.id=id;
        this.task_name=task_name;
        this.task_description=task_description;
        this.task_date=task_date;
        this.task_time=task_time;
        this.task_priority=task_priority;

    }
    // Gatter And Satter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public String getTask_date() {
        return task_date;
    }

    public void setTask_date(String task_date) {
        this.task_date = task_date;
    }

    public String getTask_time() {
        return task_time;
    }

    public void setTask_time(String task_time) {
        this.task_time = task_time;
    }

    public String getTask_priority() {
        return task_priority;
    }

    public void setTask_priority(String task_priority) {
        this.task_priority = task_priority;
    }
}
