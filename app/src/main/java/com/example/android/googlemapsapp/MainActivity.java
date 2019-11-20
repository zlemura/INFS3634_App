package com.example.android.googlemapsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.android.googlemapsapp.MentalHealthModuleFragments.MentalHealthQuizActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.Parse;

public class MainActivity extends AppCompatActivity {

    private static boolean excerciseModuleComplete = false;
    private static boolean nutritionModuleComplete = false;
    private static boolean mentalHealthModuleComplete = false;

    //Text for zero complete

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Intent intent = new Intent(getApplicationContext(), MentalHealthQuizActivity.class);
        startActivity(intent);*/

        //nutritionModuleComplete = true;
        //mentalHealthModuleComplete = true;
        //excerciseModuleComplete = true;

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new ModuleFragment()).commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch(menuItem.getItemId()){
                        case R.id.navigation_modules:
                            selectedFragment= new ModuleFragment();
                            break;
                        case R.id.navigation_special_offers:
                            selectedFragment=new SpecialOffersFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    public static boolean isExcerciseModuleComplete() {
        return excerciseModuleComplete;
    }

    public static void setExcerciseModuleComplete(boolean excerciseModuleComplete) {
        MainActivity.excerciseModuleComplete = excerciseModuleComplete;
    }

    public static boolean isNutritionModuleComplete() {
        return nutritionModuleComplete;
    }

    public static void setNutritionModuleComplete(boolean nutritionModuleComplete) {
        MainActivity.nutritionModuleComplete = nutritionModuleComplete;
    }

    public static boolean isMentalHealthModuleComplete() {
        return mentalHealthModuleComplete;
    }

    public static void setMentalHealthModuleComplete(boolean mentalHealthModuleComplete) {
        MainActivity.mentalHealthModuleComplete = mentalHealthModuleComplete;
    }

}

