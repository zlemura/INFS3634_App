package com.example.android.googlemapsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.android.googlemapsapp.MentalHealthModule.MentalHealthQuizActivity;
import com.example.android.googlemapsapp.MentalHealthModule.SimpleActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(getApplicationContext(), MentalHealthQuizActivity.class);
        startActivity(intent);
    }
}
