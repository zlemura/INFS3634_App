package com.example.android.googlemapsapp.NutritionModuleFragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.googlemapsapp.NutritionModuleSupportingFIles.Branded;
import com.example.android.googlemapsapp.NutritionModuleSupportingFIles.BrandedAdapter;
import com.example.android.googlemapsapp.NutritionModulePlaceholder;
import com.example.android.googlemapsapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

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
        //Get both calorieGoal amount and plateitem arraylist from PlateBuilder.class
        int calorieGoal = intent.getIntExtra("calorieGoal",0);
        ArrayList<Branded> plateItems = PlateBuilder.plateItems;
        int plateCalories = 0;

        for (int i=0;i<plateItems.size();i++){
            plateCalories+= Integer.valueOf(plateItems.get(i).getNf_calories());
        }

        TextView calorieGoalTV = findViewById(R.id.calorieGoalLabel);

        //Set the calorie goal textview to the calorie goal
        calorieGoalTV.setText(String.valueOf(calorieGoal));

        TextView yourCaloriesTV = findViewById(R.id.yourCalorieFailedLabel);

        //Set the users calorie total to their plates total
        yourCaloriesTV.setText(String.valueOf(plateCalories));

        //Load all plate items into recyclerview, showing food name and calories per item

        if(PlateBuilder.plateItems.size() >0){
            recyclerView = findViewById(R.id.plateFailedRV);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            brandedAdapter = new BrandedAdapter(getApplicationContext(), plateItems);
            recyclerView.setAdapter(brandedAdapter);
        }

        retryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NutritionModulePlaceholder.class);
                startActivity(intent);
            }
        });

    }
}
