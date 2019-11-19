package com.example.android.googlemapsapp.MentalHealthModuleFragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles.MentalHealthQuestion;
import com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles.MentalHealthQuestionAdapter;
import com.example.android.googlemapsapp.R;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MentalHealthQuizActivity extends AppCompatActivity {

    private ArrayList<MentalHealthQuestion> mentalHealthQuestions = new ArrayList<>();
    private HashMap<Integer, String> mentalHealthUserAnswersList = new HashMap<>();

    RecyclerView recyclerView;
    MentalHealthQuestionAdapter mentalHealthQuestionAdapter;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health_quiz);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("BCrUQVkk80pCdeImSXoKXL5ZCtyyEZwbN7mAb11f")
                .clientKey("rWFPEbTs7UzkaVsIXnQ4qmmr9oWqwXfiiJehtIZu")
                .server("https://parseapi.back4app.com")
                .build()
        );

        System.out.println("BEFORE PARSE");

        ParseQuery<ParseObject> query = ParseQuery.getQuery("question");



    }

}






