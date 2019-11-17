package com.example.android.googlemapsapp.ExcerciseModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.example.android.googlemapsapp.R;

public class ExcerciseModuleContent2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_module_content2);

        WebView contentWebView = findViewById(R.id.excerciseContentPage2WV);
        Button nextBtn = findViewById(R.id.excerciseContentPage2NextBtn);

        contentWebView.setScrollY(550);
        contentWebView.loadUrl("https://www.betterhealth.vic.gov.au/blog/blogcollectionpage/Conversation-10000steps");

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ExcerciseModuleQuizOverviewActivity.class);
                startActivity(intent);

            }
        });
    }
}
