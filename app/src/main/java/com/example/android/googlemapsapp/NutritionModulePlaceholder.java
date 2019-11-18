package com.example.android.googlemapsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.android.googlemapsapp.ExcerciseModuleFragments.ExcerciseModuleContent1Fragment;
import com.example.android.googlemapsapp.ExcerciseModuleFragments.ExcerciseModuleContent2Fragment;
import com.example.android.googlemapsapp.ExcerciseModuleFragments.ExcerciseModuleIntroductionFragment;
import com.example.android.googlemapsapp.ExcerciseModuleFragments.ExcerciseModuleQuizOverviewFragment;
import com.example.android.googlemapsapp.NutritionModuleFragments.NutritionModuleContent1Fragment;
import com.example.android.googlemapsapp.NutritionModuleFragments.NutritionModuleContent2Fragment;
import com.example.android.googlemapsapp.NutritionModuleFragments.NutritionModuleIntroductionFragment;
import com.example.android.googlemapsapp.NutritionModuleFragments.NutritionModuleQuizOverviewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NutritionModulePlaceholder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_module_placeholder);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_module_placeholder_nutrition,
                new NutritionModuleIntroductionFragment()).commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavView_module_placeholder_nutrition);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch(menuItem.getItemId()){
                        case R.id.navigation_module_introduction:
                            selectedFragment= new NutritionModuleIntroductionFragment();
                            break;
                        case R.id.navigation_module_content_page_1:
                            selectedFragment=new NutritionModuleContent1Fragment();
                            break;
                        case R.id.navigation_module_content_page_2:
                            selectedFragment=new NutritionModuleContent2Fragment();
                            break;
                        case R.id.navigation_module_quiz:
                            selectedFragment=new NutritionModuleQuizOverviewFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_module_placeholder_nutrition,
                            selectedFragment).commit();

                    return true;
                }
            };
    }

