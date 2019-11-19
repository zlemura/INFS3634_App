package com.example.android.googlemapsapp.MentalHealthModuleFragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.googlemapsapp.MentalHealthModulePlaceholder;
import com.example.android.googlemapsapp.R;

public class MentalHealthQuizFailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health_quiz_failed);

        Button returnButton = findViewById(R.id.retryMHBtn);

        returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MentalHealthModulePlaceholder.class);
                startActivity(intent);
            }
        });
    }
}
