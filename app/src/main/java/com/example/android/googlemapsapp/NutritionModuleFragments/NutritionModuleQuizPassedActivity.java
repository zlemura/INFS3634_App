package com.example.android.googlemapsapp.NutritionModuleFragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.googlemapsapp.MainActivity;
import com.example.android.googlemapsapp.NutritionModuleSupportingFIles.BrandedAdapter;
import com.example.android.googlemapsapp.R;

public class NutritionModuleQuizPassedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BrandedAdapter brandedAdapter;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_module_quiz_passed);

        Button menuButton = findViewById(R.id.returnBtn);

        Intent intent = getIntent();
        int calorieGoal = intent.getIntExtra("calorieGoal",0);

        TextView calorieGoalTV = findViewById(R.id.calorieGoalPassedLabel);

        calorieGoalTV.setText(String.valueOf(calorieGoal));

        if(PlateBuilder.plateItems.size() >0){
            recyclerView = findViewById(R.id.platePassedRV);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            brandedAdapter = new BrandedAdapter(getApplicationContext(), PlateBuilder.plateItems);
            recyclerView.setAdapter(brandedAdapter);
        }

        menuButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                MainActivity.setNutritionModuleComplete(true);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
