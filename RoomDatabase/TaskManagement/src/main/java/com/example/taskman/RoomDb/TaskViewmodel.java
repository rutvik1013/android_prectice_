package com.example.taskman.RoomDb;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.taskman.RoomDb.TaskModel;
import com.example.taskman.RoomDb.TaskRepository;

import java.util.List;

public class TaskViewmodel extends AndroidViewModel {

    private TaskRepository repository;
    private LiveData<List<TaskModel>> alltask;
    private LiveData<List<TaskModel>>date_time;
    public TaskViewmodel(@NonNull Application application) {
        super(application);
        repository=new TaskRepository(application);
        alltask=repository.getalltask_();
        date_time=repository.getTask_By_Date_and_time();


    }
    // inserting the task
    public void InsertTask(TaskModel taskModel){
        repository.insert_task(taskModel);
    }
    // updating the task
    public void UpdateTask(TaskModel taskModel){
        repository.update_task(taskModel);
    }
    // deleting the task
    public void DeleteTask(TaskModel taskModel){
        repository.delete_task(taskModel);
    }
    // get all task by date and time
    public LiveData<List<TaskModel>> get_Task_By_Date_and_Time() {
        return date_time;
    }

    public LiveData<List<TaskModel>>getAllTask_v(){
        return alltask;
    }
    // sorted by highPriority

}