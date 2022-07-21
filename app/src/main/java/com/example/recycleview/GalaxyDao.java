package com.example.recycleview;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GalaxyDao {
    @Insert
    void insert(GalaxyClass galaxyClass);

    @Update
    void update(GalaxyClass galaxyClass);

    @Delete
    void delete(GalaxyClass galaxyClass);

    @Query("DELETE from GalaxyClass")
    void deleteAll ();

    @Query("SELECT * from GalaxyClass")
    LiveData<List<GalaxyClass>> getAllPlanets();
}
