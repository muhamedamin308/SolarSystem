package com.example.recycleview;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PlanetRepository {
    private GalaxyDao mgalaxyDao;
    private LiveData<List<GalaxyClass>> getAllSpace;

    public PlanetRepository (Application application){
        GalaxyRoomdb db = GalaxyRoomdb.getInstance(application);
        mgalaxyDao = db.galaxyDao();
        getAllSpace = mgalaxyDao.getAllPlanets();
    }

    //Operations


    //Insert
        public void insertR (GalaxyClass galaxyClass){
            new InsertAsyncTask(mgalaxyDao).execute(galaxyClass);
        }
    //Update
        public void updateR (GalaxyClass galaxyClass){
            new UpdateAsyncTask(mgalaxyDao).execute(galaxyClass);
        }
    //Delete
        public void deleteR (GalaxyClass galaxyClass){
            new DeleteAsyncTask(mgalaxyDao).execute(galaxyClass);
        }
    //Delete All
        public void deleteAllPlanets (){
            new DeleteAllAsyncTask(mgalaxyDao).execute();
        }
    //Get All Data
        public LiveData<List<GalaxyClass>> getAlldata(){
            return getAllSpace;
        }



    private static class InsertAsyncTask extends AsyncTask<GalaxyClass , Void , Void>{
        private GalaxyDao mGalaxyDao;

        public InsertAsyncTask(GalaxyDao galaxyDao){
            mGalaxyDao = galaxyDao;
        }
        @Override
        protected Void doInBackground(GalaxyClass... galaxyClasses) {
            mGalaxyDao.insert(galaxyClasses[0]);

            return null;
        }
    }


    private static class UpdateAsyncTask extends AsyncTask<GalaxyClass , Void , Void>{
        private GalaxyDao mGalaxyDao;

        public UpdateAsyncTask(GalaxyDao galaxyDao){
            mGalaxyDao = galaxyDao;
        }
        @Override
        protected Void doInBackground(GalaxyClass... galaxyClasses) {
            mGalaxyDao.update(galaxyClasses[0]);
            return null;
        }
    }


    private static class DeleteAsyncTask extends AsyncTask<GalaxyClass , Void , Void>{
        private GalaxyDao mGalaxyDao;

        public DeleteAsyncTask(GalaxyDao galaxyDao){
            mGalaxyDao = galaxyDao;
        }
        @Override
        protected Void doInBackground(GalaxyClass... galaxyClasses) {
            mGalaxyDao.delete(galaxyClasses[0]);
            return null;
        }
    }
    private static class DeleteAllAsyncTask extends AsyncTask<Void , Void , Void>{
        private GalaxyDao mGalaxyDao;

        public DeleteAllAsyncTask(GalaxyDao galaxyDao){
            mGalaxyDao = galaxyDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mGalaxyDao.deleteAll();
            return null;
        }
    }

}
