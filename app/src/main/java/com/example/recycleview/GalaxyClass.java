package com.example.recycleview;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class GalaxyClass {
    public String text1;
    public String text2;
    public String description;
    public int imageResource;
    @PrimaryKey(autoGenerate = true)
    int number;

    public GalaxyClass (int imageResource ,String text1 ,String text2 ,String desctiption){
        this.imageResource = imageResource;
        this.text1 = text1;
        this.text2 = text2;
        this.description=desctiption;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
    public String getText1 (){
        return text1;
    }

    public String getText2() {
        return text2;
    }
    public int getNumeber(){
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public GalaxyClass (){}
}
