package com.example.android.googlemapsapp.MentalHealthModuleFragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.googlemapsapp.MainActivity;
import com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles.MentalHealthQuestion;
import com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles.MentalHealthQuestionsAndAnswersAdapter;
import com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles.Question;
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

        //Get list of user answers and questionList to compare
        Intent intent = getIntent();
        HashMap<Integer, String> questionAndAnswerList = (HashMap<Integer, String>) intent.getSerializableExtra("questionAnswerHashmap");
        ArrayList<Question> questionList = MentalHealthQuizActivity.questionList;

        //Populate recyclerview with both question text, user and correct answers
        recyclerView = findViewById(R.id.mentalHealthQuestionsPassedRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mentalHealthQuestionsAndAnswersAdapter = new MentalHealthQuestionsAndAnswersAdapter(getApplicationContext(),questionList,questionAndAnswerList);
        recyclerView.setAdapter(mentalHealthQuestionsAndAnswersAdapter);

        //Button to take the user back to module page
        Button returnButton = findViewById(R.id.mentalHealthReturnToMainMenuBtn);

        returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //Sets the mental health module boolean (in MainActivity.class) to complete,
                //for purpose of special offers
                MainActivity.setMentalHealthModuleComplete(true);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
