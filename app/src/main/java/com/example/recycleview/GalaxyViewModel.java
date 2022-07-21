package com.example.recycleview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class GalaxyViewModel extends AndroidViewModel {
    private PlanetRepository mPlanetRepository;
    private LiveData<List<GalaxyClass>> mAllData;
    public GalaxyViewModel(@NonNull Application application) {
        super(application);
        mPlanetRepository = new PlanetRepository(application);
        mAllData = mPlanetRepository.getAlldata();
    }

    public void insertV (GalaxyClass galaxyClass){
        mPlanetRepository.insertR(galaxyClass);
    }
    public void updateV (GalaxyClass galaxyClass){
        mPlanetRepository.updateR(galaxyClass);
    }
    public void deleteV (GalaxyClass galaxyClass){
        mPlanetRepository.deleteR(galaxyClass);
    }
    public void deleteAllPlanets (){
        mPlanetRepository.deleteAllPlanets();
    }
    public LiveData<List<GalaxyClass>> getmAllData(){
        return mAllData;
    }
}
