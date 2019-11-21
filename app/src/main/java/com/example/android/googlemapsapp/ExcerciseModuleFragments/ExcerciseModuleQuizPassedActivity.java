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

        //Prints steps from UNSW pin to user pin in console
        System.out.println("STEPS IS: "+ steps);

        Button returnButton = findViewById(R.id.returnToMainMenuExcerciseButton);
        TextView stepsAmountTV = findViewById(R.id.excerieModuleYourPinStepsPassedLabel);

        //Set value of steps from UNSW based on users pin drop
        stepsAmountTV.setText(String.valueOf(steps));

        //Button to take the user back to module page
        returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //Sets the excercise module boolean (in MainActivity.class) to complete,
                //for purpose of special offers
                MainActivity.setExcerciseModuleComplete(true);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
