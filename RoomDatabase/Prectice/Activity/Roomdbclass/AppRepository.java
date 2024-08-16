package com.example.roomdbexam.Activity.Roomdbclass;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AppRepository {
    private Dao dao;

    public AppRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        dao = database.dao();
    }

    public void insert(UserModel model) {
        new InsertDataAsyncTask(dao).execute(model);
    }

    public void update(UserModel model) {
        new UpdateDataAsyncTask(dao).execute(model);
    }

    public void delete(UserModel model) {
        new DeleteDataAsyncTask(dao).execute(model);
    }

    public LiveData<List<UserModel>> getAllData() {
        return dao.getAllData();
    }
    private static class InsertDataAsyncTask extends AsyncTask<UserModel,Void,Void>{
        private Dao dao;

        private InsertDataAsyncTask(Dao dao){
            this.dao=dao;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            dao.insertdata(userModels[0]);
            return null;
        }
    }
    private static class UpdateDataAsyncTask extends AsyncTask<UserModel,Void,Void>{
        private Dao dao;

        private UpdateDataAsyncTask(Dao dao){
            this.dao=dao;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            dao.updatedata(userModels[0]);
            return null;
        }
    }
    private static class DeleteDataAsyncTask extends AsyncTask<UserModel,Void,Void>{
        private Dao dao;

        private DeleteDataAsyncTask(Dao dao){
            this.dao=dao;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            dao.deletedata(userModels[0]);
            return null;
        }
    }
}
