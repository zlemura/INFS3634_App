package com.example.android.googlemapsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.googlemapsapp.MentalHealthModuleFragments.MentalHealthContent1Fragment;
import com.example.android.googlemapsapp.MentalHealthModuleFragments.MentalHealthContent2Fragment;
import com.example.android.googlemapsapp.MentalHealthModuleFragments.MentalHealthIntroductionFragment;
import com.example.android.googlemapsapp.MentalHealthModuleFragments.MentalHealthModuleQuizOverviewFragment;
import com.example.android.googlemapsapp.NutritionModuleFragments.NutritionModuleContent1Fragment;
import com.example.android.googlemapsapp.NutritionModuleFragments.NutritionModuleContent2Fragment;
import com.example.android.googlemapsapp.NutritionModuleFragments.NutritionModuleIntroductionFragment;
import com.example.android.googlemapsapp.NutritionModuleFragments.NutritionModuleQuizOverviewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MentalHealthModulePlaceholder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health_module_placeholder);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_module_placeholder_mental_health,
                new MentalHealthIntroductionFragment()).commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavView_module_placeholder_mental_health);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.module_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch(menuItem.getItemId()){
                        case R.id.navigation_module_introduction:
                            selectedFragment= new MentalHealthIntroductionFragment();
                            break;
                        case R.id.navigation_module_content_page_1:
                            selectedFragment=new MentalHealthContent1Fragment();
                            break;
                        case R.id.navigation_module_content_page_2:
                            selectedFragment=new MentalHealthContent2Fragment();
                            break;
                        case R.id.navigation_module_quiz:
                            selectedFragment=new MentalHealthModuleQuizOverviewFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_module_placeholder_mental_health,
                            selectedFragment).commit();

                    return true;
                }
            };
    }

