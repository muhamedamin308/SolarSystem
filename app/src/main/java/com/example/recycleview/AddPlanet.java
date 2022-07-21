package com.example.recycleview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddPlanet extends AppCompatActivity {
    //Attributes
    private EditText planetName;
    private EditText planetDesc1;
    private EditText planetDesc2;
    private ImageView imageView;
    private ImageView changePic;
    private Uri uri;
    private ImageView mic , micDesc1 , micDesc2;
    //Vie ـModel
    private AddPlanetViewModel mViewModel;
    //Extras
    private int mID;
    private int imageR;
    private static final int Rec_result = 1 ;
    private static final int Rec_result1 = 2 ;
    private static final int Rec_result2 = 3 ;
    private  int selectPhoto = 4 ;
    private static Bitmap bitmap;
    private boolean editMode;
    public static final String Extra_id = "package com.example.extraId";
    public static final String Extra_Pname = "package com.example.extraName";
    public static final String Extra_Pdesc1 = "package com.example.extraDesc1";
    public static final String Extra_Pdesc2 = "package com.example.extraDesc2";
    public static final String Extra_Pimage = "package com.example.extraImage";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_planet);

        planetName = findViewById(R.id.planetName);
        planetDesc1 = findViewById(R.id.planetDesc1);
        planetDesc2 = findViewById(R.id.planetDesc2);
        imageView = findViewById(R.id.IMAGE);
        mic = findViewById(R.id.mic);
        micDesc1 = findViewById(R.id.micDesc);
        micDesc2 = findViewById(R.id.micDesc2);
        changePic = findViewById(R.id.change);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        Intent i = getIntent();
        if (i.hasExtra(Extra_id)){
            //Update The Item
            setTitle("Update The Planet");
            editMode = true;
            mID = i.getIntExtra(Extra_id , -1);
            planetName.setText(i.getStringExtra(Extra_Pname));
            planetDesc1.setText(i.getStringExtra(Extra_Pdesc1));
            planetDesc2.setText(i.getStringExtra(Extra_Pdesc2));
            int image = i.getExtras().getInt(Extra_Pimage);
            imageView.setImageResource(image);
            mic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL , RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT , "Speck The Planet Name !!");
                    startActivityForResult(intent , Rec_result);
                }
            });
            micDesc1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL , RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT , "Speck The Planet Desc1 !!");
                    startActivityForResult(intent , Rec_result1);
                }
            });
            micDesc2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL , RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT , "Speck The Planet Desc2 !!");
                    startActivityForResult(intent , Rec_result2);
                }
            });
        }else{
            //Add New Planet
            setTitle("Add New Planet");
            editMode = false;
            mic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL , RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT , "Speck The Planet Name !!");
                    startActivityForResult(intent , Rec_result);//didn't get it at all
                }
            });
            micDesc1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL , RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT , "Speck The Planet Desc1 !!");
                    startActivityForResult(intent , Rec_result1);//didn't get it at all
                }
            });
            micDesc2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL , RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT , "Speck The Planet Desc2 !!");
                    startActivityForResult(intent , Rec_result2);//didn't get it at all
                }
            });
            changePic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent,selectPhoto);
                }
            });
        }
        mViewModel = ViewModelProviders.of(this).get(AddPlanetViewModel.class);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu1 , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.saveItem:
                savePlanet();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {//didn't get it at all
        if(requestCode == Rec_result && resultCode == RESULT_OK){
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            planetName.setText(matches.get(0).toString());//didn't get it at all
        }
        else if(requestCode == Rec_result1 && resultCode == RESULT_OK){
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            planetDesc1.setText(matches.get(0).toString());//didn't get it at all
        }
        else if(requestCode == Rec_result2 && resultCode == RESULT_OK){
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            planetDesc2.setText(matches.get(0).toString());//didn't get it at all
        }else if (requestCode == selectPhoto && resultCode == RESULT_OK && data != null && data.getData() != null){
            uri = data.getData();
            try{
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void savePlanet(){

        String Planetname = planetName.getText().toString();
        String Planetdesc1 = planetDesc1.getText().toString();
        String Planetdesc2 = planetDesc2.getText().toString();

        if (Planetname.isEmpty() || Planetdesc1.isEmpty() || Planetdesc2.isEmpty()){
            Toast.makeText(AddPlanet.this , "Please Fill All Fields!!" , Toast.LENGTH_LONG).show();
            return ;
        }
        if (editMode){
            Intent intent = getIntent();
            int Image = intent.getExtras().getInt(Extra_Pimage);
            imageView.setImageResource(Image);
            GalaxyClass galaxyClass = new GalaxyClass(Image , Planetname , Planetdesc1 , Planetdesc2);
            galaxyClass.setNumber(mID);
            mViewModel.updateAV(galaxyClass);
        }else{
            mViewModel.insertAV(new GalaxyClass(R.drawable.ask , Planetname , Planetdesc1 , Planetdesc2));
        }
        finish();
    }
}