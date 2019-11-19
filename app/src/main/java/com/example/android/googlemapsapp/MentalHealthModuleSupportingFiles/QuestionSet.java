
package com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionSet
{
    private Question[] questions;

    public Question[] getQuestions ()
    {
        return questions;
    }

    public void setQuestions (Question[] questions)
    {
        this.questions = questions;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [questions = "+questions+"]";
    }
}
