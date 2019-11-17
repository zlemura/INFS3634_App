package com.example.android.googlemapsapp.NutritionModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.example.android.googlemapsapp.R;

public class NutritionContentActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_content2);

        WebView contentWebView = findViewById(R.id.nutritionContentPage2WV);
        Button nextBtn = findViewById(R.id.nutritionContentPage1NextBtn);

        contentWebView.loadUrl("https://www.eatforhealth.gov.au/guidelines/about-australian-dietary-guidelines");
        contentWebView.setScrollY(350);

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.example.android.googlemapsapp.
                        NutritionModule.NutritionModuleQuizOverviewActivity.class);
                startActivity(intent);
            }
        });
    }
}
