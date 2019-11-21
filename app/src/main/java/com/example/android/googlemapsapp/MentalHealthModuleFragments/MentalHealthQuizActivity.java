package com.example.android.googlemapsapp.MentalHealthModuleFragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles.MentalHealthQuestion;
import com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles.MentalHealthQuestionAdapter;
import com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles.Question;
import com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles.QuestionSet;
import com.example.android.googlemapsapp.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MentalHealthQuizActivity extends AppCompatActivity {

    public static ArrayList<Question> questionList = new ArrayList<>();

    private HashMap<Integer,String> mentalHealthUserAnswersList = new HashMap<>();

    RecyclerView recyclerView;
    MentalHealthQuestionAdapter mentalHealthQuestionAdapter;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health_quiz);

        questionList.clear();

        //CORRECT ANSWERS: C,C,A,B,B :) - DEBUGGING PURPOSES

        //API call to hosted JSON file to get question list and aprse it into an array
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        String searchUrl = "https://api.myjson.com/bins/zp6gm";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, searchUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("The response is:" + response.toString());
                        Gson gson = new Gson();
                        String apiText = response.toString();
                        QuestionSet questionSet = gson.fromJson(response,QuestionSet.class);

                        //Loop to convert the questionSet array to an array list
                        for(int i=0;i<questionSet.getQuestions().length;i++){
                            questionList.add(questionSet.getQuestions()[i]);
                            System.out.println("CORERCT ANSWER FOR " + i + "is " + questionSet.getQuestions()[i].getQuestionNumber());
                        }

                        //After question list has been convereted to an array, do the following method:
                        processAfterReturn();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("QUESTION PULL ERROR", error.toString());
                Log.d("PARSE FINISHED", "WITH ERROR");
                //com.android.volley.NoConnectionError: java.net.UnknownHostException: Unable to resolve host "api.nytimes.com": No address associated with hostname
            }
        }
        );

        requestQueue.add(stringRequest);

        Button submitButton = findViewById(R.id.mentalHealthQuizSubmitButton);

        //Submit button to calculate if the user has passed or failed
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //This is a HashMpa that stores the question number and if it has been answered (from the mentalHealthQuestionAdapter)
                HashMap<Question,Boolean> tempList = mentalHealthQuestionAdapter.getListForIfItemChecked();
                boolean allQuestionsAnswered = true;

                RecyclerView.ViewHolder holder = recyclerView.findViewHolderForAdapterPosition(0);

                //Loops through all elements in the recyclerview, determines if the question has been answered before submitting -
                //IF ANSWERED: print in the console the answer
                //IF NOT ANSWERED: breaks the loop and shows the user a toast asking them to answer all question before submitting
                for(Integer i=0;i<questionList.size();i++){

                    if(tempList.get(questionList.get(i)) == null){
                        Toast.makeText(getApplicationContext(),"Please ensure you answer all questions before submitting",Toast.LENGTH_SHORT).show();
                        allQuestionsAnswered = false;
                        break;

                    }else{
                        System.out.println("Element at "+ i + " is answered with element " +
                                mentalHealthQuestionAdapter.getListForItemsWithAnswers().get(questionList.get(i)));
                    }

                }


                //If all questions were found to be answered, grade the results
                if(allQuestionsAnswered == true){
                    //If all questions are answered, this is a function to check how many the user got right
                    mentalHealthUserAnswersList = mentalHealthQuestionAdapter.getListForItemsWithAnswers();

                    double questionsGraded = 0;
                    double questionsAnsweredCorrectly = 0;

                    //Compare the answer given by the user using a hashmap (mentalHealthUserAnswersList) and array list that holds
                    //the questions with correct answers from API call. This loop compares if the answer given by the user (in the Hashmap)
                    //for a particular question is equal to the answer for the question (from the array list).
                    for(int i=0;i<questionList.size();i++){

                        if(mentalHealthUserAnswersList.get(Integer.valueOf(questionList.get(i).getQuestionNumber())).equals(questionList.get(i).getQuestionCorrectAnswer())){
                            System.out.println("Correct answer is - " + questionList.get(i).getQuestionCorrectAnswer());
                            System.out.println("The user answered " + mentalHealthUserAnswersList.get(Integer.valueOf(questionList.get(i).getQuestionNumber())));

                            //If the answer provided by user and question answer are equal, increment both questions graded and questions answered correctly
                            questionsGraded++;
                            questionsAnsweredCorrectly++;

                        }else{
                            //If the answer provided by user and question answer are equal, increment only questions graded
                            questionsGraded++;
                            System.out.println("Correct answer is - " + questionList.get(i).getQuestionCorrectAnswer());
                            System.out.println("The user answered " + mentalHealthUserAnswersList.get(Integer.valueOf(questionList.get(i).getQuestionNumber())));

                        }

                        System.out.println("Questions Graded = " + questionsGraded + ". Questions Answered Correctly = " + questionsAnsweredCorrectly);

                    }

                    //If the user scored over 80%, they will have passed the module, else, they will be returned to the start and forced to sit the test again

                    System.out.println("USER SCORE IS: "+ questionsAnsweredCorrectly/questionsGraded);

                    //If user score greater than or equal to 0.8, take user to module passed screen

                    if(questionsAnsweredCorrectly/questionsGraded >= 0.8){

                        System.out.println("The user achieved :" + questionsAnsweredCorrectly/questionsGraded);
                        System.out.println("Module passed");

                        for(int i=0;i<questionList.size();i++){
                            System.out.println(mentalHealthUserAnswersList.get(questionList.get(i)));
                        }

                        Intent intent = new Intent(getApplicationContext(),MentalHealthQuizPassedActivity.class);

                        //Pass the list of users answers to the pass activity to populate recyclerview
                        intent.putExtra("questionAnswerHashmap",mentalHealthUserAnswersList);
                        //intent.putExtra("questionList",questionList);
                        startActivity(intent);


                    }//If user score less than 0.8, take user to module passed failed
                    else{
                        System.out.println("The user achieved :" + questionsAnsweredCorrectly/questionsGraded);
                        System.out.println("Module failed");
                        Intent intent = new Intent(getApplicationContext(),MentalHealthQuizFailedActivity.class);
                        //Dont pass the list of users answers to failure activity so they cant just see what they
                        //answered incorrectly and re-try the quiz straight-away
                        startActivity(intent);
                    }

                }

            }
        });

    }

    public void processAfterReturn(){

        //Populate the recyclerview after the arraylist for questions has been populated

        recyclerView = findViewById(R.id.mentalHealthQuizRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mentalHealthQuestionAdapter = new MentalHealthQuestionAdapter(getApplicationContext(), questionList);
        recyclerView.setAdapter(mentalHealthQuestionAdapter);

    }

}






