package com.example.android.googlemapsapp.ExcerciseModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.example.android.googlemapsapp.R;

public class ExcerciseModuleContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_module_content);

        WebView contentWebView = findViewById(R.id.excerciseContentPage1WV);
        Button nextBtn = findViewById(R.id.excerciseContentPage1NextBtn);

        contentWebView.setScrollY(550);
        contentWebView.loadUrl("https://www.healthdirect.gov.au/exercise-and-mental-health");

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ExcerciseModuleContent2Activity.class);
                startActivity(intent);
            }
        });
    }
}
