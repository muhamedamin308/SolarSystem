package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MercuryData extends AppCompatActivity {
    TextView t1 , t2 ;
    ImageView image;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercury_data);
        image = (ImageView) findViewById(R.id.imageviewid);
        t1 = (TextView) findViewById(R.id.textviewid1);
        t2 = (TextView) findViewById(R.id.textviewid2);
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("title");
        String Description = intent.getExtras().getString("Description");
        String desc2=intent.getExtras().getString("desc");
        int number = intent.getExtras().getInt("number");
        int Image = intent.getExtras().getInt("image");
        image.setImageResource(R.drawable.mars);
                image.setImageResource(Image);
                t1.setText(Title);
                t2.setText(Description +desc2 );

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}