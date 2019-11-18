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
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ExcerciseModulePlaceholder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_module_placeholder);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_module_placeholder_excercise,
                new ExcerciseModuleIntroductionFragment()).commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavView_module_placeholder_excercise);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch(menuItem.getItemId()){
                        case R.id.navigation_module_introduction:
                            selectedFragment= new ExcerciseModuleIntroductionFragment();
                            break;
                        case R.id.navigation_module_content_page_1:
                            selectedFragment=new ExcerciseModuleContent1Fragment();
                            break;
                        case R.id.navigation_module_content_page_2:
                            selectedFragment=new ExcerciseModuleContent2Fragment();
                            break;
                        case R.id.navigation_module_quiz:
                            selectedFragment=new ExcerciseModuleQuizOverviewFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_module_placeholder_excercise,
                            selectedFragment).commit();

                    return true;
                }
            };
    }
