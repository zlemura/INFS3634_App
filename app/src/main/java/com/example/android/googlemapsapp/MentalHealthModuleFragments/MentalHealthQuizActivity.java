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

        readObject();
        System.out.println("After parse object");

    }

    public void readObject() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Question");

        // The query will search for a ParseObject, given its objectId.
        // When the query finishes running, it will invoke the GetCallback
        // with either the object, or the exception thrown
        query.getInBackground("<PARSE_OBJECT_ID>", new GetCallback<ParseObject>() {
            public void done(ParseObject result, ParseException e) {
                if (e == null) {
                    System.out.println("IN RESULT LOOP");
                    System.out.println(result);
                } else {
                    // something went wrong
                }
            }
        });
    }
}






