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

        //We don't show the user what questions they answered correctly and incorrectly
        //so they must go back to the articles and re-read them, rather than simply
        //giving them the answers :)

        returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MentalHealthModulePlaceholder.class);
                startActivity(intent);
            }
        });
    }
}
