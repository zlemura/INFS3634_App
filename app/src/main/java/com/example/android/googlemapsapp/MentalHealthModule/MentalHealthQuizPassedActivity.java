package com.example.android.googlemapsapp.MentalHealthModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android.googlemapsapp.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MentalHealthQuizPassedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MentalHealthQuestionsAndAnswersAdapter mentalHealthQuestionsAndAnswersAdapter;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health_quiz_passed);

        Intent intent = getIntent();


        //HashMap<MentalHealthQuestion,String> questionAndAnswerList = (HashMap<MentalHealthQuestion,String>)intent.getSerializableExtra("questionAnswerHashmap");
        //ArrayList<MentalHealthQuestion> questionList = (ArrayList<MentalHealthQuestion>) intent.getSerializableExtra("questionList");

        HashMap<Integer,String> questionAndAnswerList = (HashMap<Integer,String>)intent.getSerializableExtra("questionAnswerHashmap");
        ArrayList<MentalHealthQuestion> questionList = (ArrayList<MentalHealthQuestion>) intent.getSerializableExtra("questionList");



        recyclerView = findViewById(R.id.mentalHealthQuestionsPassedRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mentalHealthQuestionsAndAnswersAdapter = new MentalHealthQuestionsAndAnswersAdapter(getApplicationContext(),questionList,questionAndAnswerList);
        recyclerView.setAdapter(mentalHealthQuestionsAndAnswersAdapter);

        System.out.println("AFTER ALL SETS");

    }
}
