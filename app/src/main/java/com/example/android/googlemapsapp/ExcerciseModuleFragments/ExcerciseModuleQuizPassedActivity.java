package com.example.android.googlemapsapp.ExcerciseModuleFragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.googlemapsapp.MainActivity;
import com.example.android.googlemapsapp.R;

public class ExcerciseModuleQuizPassedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_module_quiz_passed);

        Intent intent = getIntent();
        int steps = intent.getIntExtra("stepsDistance",0);

        System.out.println("STEPSIS: "+ steps);

        Button returnButton = findViewById(R.id.returnToMainMenuExcerciseButton);
        TextView stepsAmountTV = findViewById(R.id.excerieModuleYourPinStepsPassedLabel);

        stepsAmountTV.setText(String.valueOf(steps));

        returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                MainActivity.setExcerciseModuleComplete(true);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
