package com.example.android.googlemapsapp.NutritionModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.googlemapsapp.R;

public class NutritionContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_content);

        WebView contentWebView = findViewById(R.id.nutritionContentPage1WV);
        Button nextBtn = findViewById(R.id.nutritionContentPage1NextBtn);

        contentWebView.setScrollY(840);
        contentWebView.loadUrl("https://www.healthdirect.gov.au/kilojoules");
        contentWebView.setBackgroundColor(Color.BLACK);

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.example.android.googlemapsapp.NutritionModule.NutritionContentActivity2.class);
                startActivity(intent);
            }
        });
    }
}
