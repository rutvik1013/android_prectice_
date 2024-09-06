package com.example.taskman.RoomDb;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskRepository
{
    public TaskDao taskDao;

    public TaskRepository(Application application){
        TaskDatabase database=TaskDatabase.getInstance(application);
        taskDao= database.taskDao();
    }
    // For Insert Operation
    public void insert_task(TaskModel taskModel){
        new InsertDetailsAsyncTask(taskDao).execute(taskModel);
    }
    // For Update Operation
    public void update_task(TaskModel taskModel){
        new UpdateDetailsAsyncTask(taskDao).execute(taskModel);
    }
    // For Delete Operation
    public void delete_task(TaskModel taskModel){
        new DeleteDetailsAsyncTask(taskDao).execute(taskModel);
    }
    // fetching Livedata from taskdao class
    public LiveData<List<TaskModel>>getalltask_(){
        return taskDao.getAllTasks();
    }
    // get task sorted by date and time
    public LiveData<List<TaskModel>> getTask_By_Date_and_time(){
        return taskDao.getTaskByDateAndTime();
    }
    // Get sorted the task by high Priority



    // Now creating async task to insert the task
    public static class InsertDetailsAsyncTask extends AsyncTask<TaskModel,Void,Void>{
        private TaskDao taskDao;

        private InsertDetailsAsyncTask(TaskDao taskDao){
            this.taskDao=taskDao;
        }

        @Override
        protected Void doInBackground(TaskModel... taskModels) {
            taskDao.insertTask(taskModels[0]);
            return null;
        }
    }
    // Now creating async task to update the task
    private static class UpdateDetailsAsyncTask extends AsyncTask<TaskModel,Void,Void>{
        private TaskDao taskDao;

        private UpdateDetailsAsyncTask(TaskDao taskDao){
            this.taskDao=taskDao;
        }

        @Override
        protected Void doInBackground(TaskModel... taskModels) {
            taskDao.updateTask(taskModels[0]);
            return null;
        }
    }
    // Now creating async task to delete the task
    private static class DeleteDetailsAsyncTask extends AsyncTask<TaskModel,Void,Void>{
        private TaskDao taskDao;

        private DeleteDetailsAsyncTask(TaskDao taskDao){
            this.taskDao=taskDao;
        }

        @Override
        protected Void doInBackground(TaskModel... taskModels) {
            taskDao.deleteTask(taskModels[0]);
            return null;
        }
    }

}