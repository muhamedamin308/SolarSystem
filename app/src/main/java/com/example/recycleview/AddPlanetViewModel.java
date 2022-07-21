package com.example.recycleview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AddPlanetViewModel extends AndroidViewModel {
    private PlanetRepository mPlanetRepository;

    public AddPlanetViewModel(@NonNull Application application) {
        super(application);
        mPlanetRepository = new PlanetRepository(application);

    }

    public void insertAV (GalaxyClass galaxyClass){
        mPlanetRepository.insertR(galaxyClass);
    }
    public void updateAV (GalaxyClass galaxyClass){
        mPlanetRepository.updateR(galaxyClass);
    }

}
