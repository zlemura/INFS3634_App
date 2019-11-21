package com.example.android.googlemapsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.googlemapsapp.MentalHealthModuleFragments.MentalHealthQuizActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.Parse;

public class MainActivity extends AppCompatActivity {

    //Variables that are used to determine if modules are complete, for the purpose of showing special
    //offers in the special offers fragment
    private static boolean excerciseModuleComplete = false;
    private static boolean nutritionModuleComplete = false;
    private static boolean mentalHealthModuleComplete = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This is a placeholder activity for two fragments - 'Modules' and 'Special Offers'

        //Initialise the bottom navigation view that can be used to swap between 'Modules' and 'Special Offers' screens
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


    //Getters and setters used in modules to get/set the status of modules complete, used for once a user passes a module quiz
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


    //Adds 'i' button to top action bar and makes it clickable
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Intent intent = new Intent(getApplicationContext(),WelcomeActivity.class);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }

}

