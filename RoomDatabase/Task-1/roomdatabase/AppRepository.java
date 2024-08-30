package com.example.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AppRepository
{
    private Dao dao;


    public AppRepository(Application application){
        AppDatabase database=AppDatabase.getInstance(application);
        dao= database.dao();

    }

    // For insert operation
    public void insert(UserModel userModel){
        new InsertDetailsAsyncTask(dao).execute(userModel);

    }

    // For Update Operation
    public void update(UserModel userModel){
        new UpdateDetailsAsyncTask(dao).execute(userModel);
    }

    // For Delete Operation
    public void delete(UserModel model){
        new DeleteDetailsAsyncTask(dao).execute(model);

    }
    public LiveData<List<UserModel>>getallDetails(){
        return dao.getAllDetails();
    }
    public static class InsertDetailsAsyncTask extends AsyncTask<UserModel,Void,Void>{
        private Dao dao;

        private InsertDetailsAsyncTask(Dao dao){
            this.dao=dao;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            dao.insertdetails(userModels[0]);
            return null;
        }
    }
    public static class UpdateDetailsAsyncTask extends AsyncTask<UserModel,Void,Void>{
        private Dao dao;

        private UpdateDetailsAsyncTask(Dao dao){
            this.dao=dao;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            dao.updatedetails(userModels[0]);
            return null;
        }
    }
    public static class DeleteDetailsAsyncTask extends AsyncTask<UserModel,Void,Void>{
        private Dao dao;

        private DeleteDetailsAsyncTask(Dao dao){
            this.dao=dao;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            dao.deletedetails(userModels[0]);
            return null;
        }
    }
}
