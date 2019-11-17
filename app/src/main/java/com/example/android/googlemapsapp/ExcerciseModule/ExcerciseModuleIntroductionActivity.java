package com.example.android.googlemapsapp.ExcerciseModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.googlemapsapp.R;

public class ExcerciseModuleIntroductionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_module_introduction);

        Button nextBtn = findViewById(R.id.excerciseIntrdouctionNextButton);

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExcerciseModuleContentActivity.class);
                startActivity(intent);
            }
        });
    }
}
