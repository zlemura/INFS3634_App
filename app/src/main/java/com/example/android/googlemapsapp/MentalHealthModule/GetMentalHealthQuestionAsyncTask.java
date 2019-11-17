package com.example.android.googlemapsapp.MentalHealthModule;

import android.os.AsyncTask;

public class GetMentalHealthQuestionAsyncTask extends AsyncTask<Integer,Integer,MentalHealthQuestion> {

    private AsyncTaskDelegate delegate;
    private AppDatabase database;

    public void setDelegate(AsyncTaskDelegate delegate) {
        this.delegate = delegate;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    @Override
    protected void onPostExecute(MentalHealthQuestion mentalHealthQuestion) {
        super.onPostExecute(mentalHealthQuestion);
    }

    @Override
    protected MentalHealthQuestion doInBackground(Integer ...integer) {
        return database.mentalHealthQuestionDao().getQuestionByNumber(integer[0].intValue());
    }
}


