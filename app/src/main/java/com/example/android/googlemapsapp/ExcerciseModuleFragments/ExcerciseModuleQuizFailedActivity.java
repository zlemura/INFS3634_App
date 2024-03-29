package com.example.android.googlemapsapp.ExcerciseModuleFragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.googlemapsapp.ExcerciseModulePlaceholder;
import com.example.android.googlemapsapp.R;
import com.google.android.gms.maps.SupportMapFragment;

public class ExcerciseModuleQuizFailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_module_quiz_failed);

        Intent intent = getIntent();
        int steps = intent.getIntExtra("stepsDistance",0);

        //Prints steps from UNSW pin to user pin in console
        System.out.println("STEPS IS: "+ steps);

        Button retryBtn = findViewById(R.id.retryFailedExcerciseBtn);
        TextView stepsAmountTV = findViewById(R.id.excerieModuleYourPinStepsLabel);

        //Set value of steps from UNSW based on users pin drop
        stepsAmountTV.setText(String.valueOf(steps));

        retryBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExcerciseModulePlaceholder.class);
                startActivity(intent);
            }
        });


    }
}
