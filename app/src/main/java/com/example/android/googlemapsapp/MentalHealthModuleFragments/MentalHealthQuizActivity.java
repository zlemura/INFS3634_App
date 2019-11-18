package com.example.android.googlemapsapp.MentalHealthModuleFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.googlemapsapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MentalHealthQuizActivity extends AppCompatActivity {

    private  ArrayList<MentalHealthQuestion> mentalHealthQuestions = new ArrayList<>();
    private  HashMap<Integer,String> mentalHealthUserAnswersList = new HashMap<>();

    RecyclerView recyclerView;
    MentalHealthQuestionAdapter mentalHealthQuestionAdapter;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health_quiz);

        setMentalHealthQuestions();

        recyclerView = findViewById(R.id.mentalHealthQuizQuestionsRV);
        mentalHealthQuestionAdapter = new MentalHealthQuestionAdapter(getApplicationContext(), mentalHealthQuestions);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(mentalHealthQuestionAdapter);
        recyclerView.scrollToPosition(mentalHealthQuestions.size() - 1);
        recyclerView.scrollToPosition(0);
        int itemViewType = 0;
        recyclerView.getRecycledViewPool().setMaxRecycledViews(itemViewType, 0);

        Button submitButton = findViewById(R.id.mentalHealthQuizSubmitButton);

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                HashMap<MentalHealthQuestion,Boolean> tempList = mentalHealthQuestionAdapter.getListForIfItemChecked();
                boolean allQuestionsAnswered = true;

                RecyclerView.ViewHolder holder = recyclerView.findViewHolderForAdapterPosition(0);

                for(int i=0;i<mentalHealthQuestions.size();i++){

                    if(tempList.get(mentalHealthQuestions.get(i)) == null){
                        Toast.makeText(getApplicationContext(),"Please ensure you answer all questions before submitting",Toast.LENGTH_SHORT).show();
                        allQuestionsAnswered = false;
                        break;

                    }else{
                        System.out.println("Element at "+ i + " is answered with element " +
                                mentalHealthQuestionAdapter.getListForItemsWithAnswers().get(mentalHealthQuestions.get(i)));
                    }

                }

                if(allQuestionsAnswered == true){
                    //If all questions are answered, this is a function to check how many the user got right
                    mentalHealthUserAnswersList = mentalHealthQuestionAdapter.getListForItemsWithAnswers();
                    int questionsGraded = 0;
                    int questionsAnsweredCorrectly = 0;

                    for(int i=0;i<mentalHealthQuestions.size();i++){

                        if(mentalHealthUserAnswersList.get(mentalHealthQuestions.get(i).getQuestionNumber()).equals(mentalHealthQuestions.get(i).getCorrectAnswer())){
                            questionsGraded++;
                            questionsAnsweredCorrectly++;
                        }else{
                            questionsGraded++;
                        }

                        System.out.println("Questions Graded = " + questionsGraded + ". Questions Answered Correctly = " + questionsAnsweredCorrectly);

                    }

                    //If the user scored over 80%, they will have passed the module, else, they will be returned to the start and forced to sit the test again
                    if(questionsAnsweredCorrectly/questionsGraded >= 0.8){
                        System.out.println("Module passed");

                        for(int i=0;i<mentalHealthQuestions.size();i++){
                            System.out.println(mentalHealthUserAnswersList.get(mentalHealthQuestions.get(i)));
                        }

                        Intent intent = new Intent(getApplicationContext(), MentalHealthQuizPassedActivity.class);
                        intent.putExtra("questionAnswerHashmap",mentalHealthUserAnswersList);
                        intent.putExtra("questionList",mentalHealthQuestions);
                        startActivityForResult(intent, 50000);
                        //startActivityForResult(intent,50000);


                    }else{
                        System.out.println("Module failed");
                        Intent intent = new Intent(getApplicationContext(), MentalHealthQuizFailedActivity.class);
                        startActivity(intent);
                    }

                }

            }
        });

    }

    public void setMentalHealthQuestions(){

        //Add question 1
        List<String> q1Options = new ArrayList<>();
        q1Options.add("A");
        q1Options.add("B");
        q1Options.add("C");

        mentalHealthQuestions.add(new MentalHealthQuestion(1, "Question 1", q1Options, "A"));

        //Add question 2
        List<String> q2Options = new ArrayList<>();
        q2Options.add("A");
        q2Options.add("B");
        q2Options.add("C");

        mentalHealthQuestions.add(new MentalHealthQuestion(2, "Question 2", q2Options, "B"));

        //Add question 3
        List<String> q3Options = new ArrayList<>();
        q3Options.add("A");
        q3Options.add("B");
        q3Options.add("C");

        mentalHealthQuestions.add(new MentalHealthQuestion(3, "Question 3", q3Options, "C"));
    }


}
