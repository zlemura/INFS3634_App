package com.example.android.googlemapsapp.NutritionModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.googlemapsapp.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class PlateBuilder extends AppCompatActivity {

    public static ArrayList<Branded> plateItems = new ArrayList<>();

    int calorieGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plate_builder);

        ImageView plateImageView = findViewById(R.id.plateBuilderPlateImage);
        plateImageView.setImageResource(R.drawable.plate_image);

        Button submitPlateBtn = findViewById(R.id.submitPlateBtn);

        SearchView searchView = findViewById(R.id.foodSearchView);

        plateItems.clear();

        calorieGoal= ThreadLocalRandom.current().nextInt(100, 1200);

        TextView calorieGoalTV = findViewById(R.id.calorieGoalLabel);
        calorieGoalTV.setText(String.valueOf(calorieGoal));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String searchText) {

                String url = "https://trackapi.nutritionix.com/v2/search/instant?query=" + searchText;

                RequestQueue requestQueue = Volley.newRequestQueue(PlateBuilder.this);

                StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                System.out.println("RESPONSEY IS:" + response.toString());

                                Gson gson = new Gson();
                                FoodItem temp = gson.fromJson(response,FoodItem.class);

                                Branded tempBranded = temp.getBranded()[0];

                                TextView searchedFoodNameTV = findViewById(R.id.searchViewFoodNameTV);

                                searchedFoodNameTV.setText(tempBranded.getFood_name());

                                System.out.println("CALORIES FOR THIS IS: " + tempBranded.getNf_calories());

                                processAfterResponse(tempBranded);

                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                System.out.println("NO BUNEO: " + error);
                            }
                        }
                ) {

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String>  header = new HashMap<String, String>();
                        header.put("x-app-id", "3e96008d");
                        header.put("x-app-key", "54be943e345bfdcadb7c848e4f651e12");
                        header.put("x-remote-user-id","0");

                        return header;
                    }

                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("query",searchText);

                        return params;
                    }
                };

                requestQueue.add(postRequest);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        submitPlateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                int plateTotalCalories = 0;

                if(plateItems.size()<1){
                    Toast.makeText(getApplicationContext(),"Please add at least one food item to your plate to submit",Toast.LENGTH_SHORT).show();
                }else{

                    for(int i=0;i<plateItems.size();i++){
                        plateTotalCalories+= Integer.valueOf(plateItems.get(i).getNf_calories());
                    }

                    if(calorieGoal - plateTotalCalories < 100 && calorieGoal - plateTotalCalories >-100){
                        Intent intent = new Intent(getApplicationContext(), NutritionModuleQuizPassedActivity.class);
                        intent.putExtra("calorieGoal",calorieGoal);
                        startActivity(intent);

                    }else{
                        Intent intent = new Intent(getApplicationContext(), NutritionModuleQuizFailedActivity.class);
                        intent.putExtra("calorieGoal",calorieGoal);
                        startActivity(intent);
                    }

                }

            }
        });


    }

    public void processAfterResponse(final Branded tempBranded){

        TextView itemNameTV = findViewById(R.id.searchViewFoodNameTV);
        Button addToPlateBtn = findViewById(R.id.addItemToPlateBtn);

        addToPlateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(plateItems.size() == 0){
                    TextView plateBuilderText1 = findViewById(R.id.plateTextView1);
                    plateBuilderText1.setText(tempBranded.getFood_name());
                    plateItems.add(tempBranded);

                }else if(plateItems.size() == 1){
                    TextView plateBuilderText2 = findViewById(R.id.plateTextView2);
                    plateBuilderText2.setText(tempBranded.getFood_name());
                    plateItems.add(tempBranded);

                }else if(plateItems.size() == 2) {
                    TextView plateBuilderText3 = findViewById(R.id.plateTextView3);
                    plateBuilderText3.setText(tempBranded.getFood_name());
                    plateItems.add(tempBranded);

                }else if(plateItems.size() == 3){
                    TextView plateBuilderText4 = findViewById(R.id.plateTextView4);
                    plateBuilderText4.setText(tempBranded.getFood_name());
                    plateItems.add(tempBranded);

                }else if (plateItems.size() == 4){
                    TextView plateBuilderText5 = findViewById(R.id.plateTextView5);
                    plateBuilderText5.setText(tempBranded.getFood_name());
                    plateItems.add(tempBranded);

                }else if (plateItems.size() == 5){
                    TextView plateBuilderText6 = findViewById(R.id.plateTextView6);
                    plateBuilderText6.setText(tempBranded.getFood_name());
                    plateItems.add(tempBranded);

                }else{
                    Toast.makeText(getApplicationContext(),"You can only add six food items to your plate!",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


    }

