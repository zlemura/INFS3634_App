package com.example.android.googlemapsapp.NutritionModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.googlemapsapp.R;

public class NutritionModuleQuizFailedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BrandedAdapter brandedAdapter;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_module_quiz_failed);

        Button retryButton = findViewById(R.id.retryBtn);

        Intent intent = getIntent();
        int calorieGoal = intent.getIntExtra("calorieGoal",0);

        TextView calorieGoalTV = findViewById(R.id.calorieGoalLabel);

        calorieGoalTV.setText(String.valueOf(calorieGoal));

        if(PlateBuilder.plateItems.size() >0){
            recyclerView = findViewById(R.id.plateFailedRV);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            brandedAdapter = new BrandedAdapter(getApplicationContext(), PlateBuilder.plateItems);
            recyclerView.setAdapter(brandedAdapter);
        }

        retryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PlateBuilder.class);
                startActivity(intent);
            }
        });

    }
}
