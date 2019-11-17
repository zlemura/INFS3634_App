package com.example.android.googlemapsapp.MentalHealthModule;

import android.os.AsyncTask;

import java.util.List;

public class GetAllMentalHealthQuestionsAsyncTask extends AsyncTask<String,Integer, List<MentalHealthQuestion>> {

    private AsyncTaskDelegate delegate;
    private AppDatabase database;

    public void setDelegate(AsyncTaskDelegate delegate) {
        this.delegate = delegate;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    @Override
    protected List<MentalHealthQuestion> doInBackground(String... strings) {
        return database.mentalHealthQuestionDao().getAll();
    }

    @Override
    protected void onPostExecute(List<MentalHealthQuestion> mentalHealthQuestionList) {
        super.onPostExecute(mentalHealthQuestionList);
    }
}
