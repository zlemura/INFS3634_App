package com.example.android.googlemapsapp.MentalHealthModule;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ProgressBar;

import com.example.android.googlemapsapp.AsyncTaskDelegate;
import android.os.AsyncTask;


import java.util.Arrays;
import java.util.List;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

public class InsertMentalHealthQuestionsAsynctask extends AsyncTask<MentalHealthQuestion, Integer, String> {

        private AppDatabase database;
        private AsyncTaskDelegate delegate;

        public void setDelegate(AsyncTaskDelegate delegate) {
            this.delegate = delegate;
        }

        public void setDatabase(AppDatabase database) {
            this.database = database;
        }

        @Override
        protected String doInBackground(MentalHealthQuestion... mentalHealthQuestions) {
            List<MentalHealthQuestion> tempBookList = Arrays.asList(mentalHealthQuestions);
            database.mentalHealthQuestionDao().insertAll(tempBookList);
            return "Insert complete";
        }

        @Override
        protected void onPostExecute(String s) {
            if (delegate != null) {
                //return success or fail to activity
                delegate.handleTaskResult(s);
            }
        }

    }

