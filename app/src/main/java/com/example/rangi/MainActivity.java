package com.example.rangi;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }


    public void startFavourites(View view) {
        Intent intent = new Intent(this, favouriteColours.class);
        startActivity(intent);
    }

    public void startSelection(View view) {
        Intent intent = new Intent(this, colourSelection.class);
        startActivity(intent);
    }
    public void startRangiInfo(View view) {
        Intent intent = new Intent(this, Rangi_Infomation.class);
        startActivity(intent);
    }

}