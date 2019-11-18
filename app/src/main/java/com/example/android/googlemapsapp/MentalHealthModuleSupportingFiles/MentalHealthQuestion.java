package com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MentalHealthQuestion implements Serializable {

    private int questionNumber;
    private String questionText;
    private String[] questionOptions;
    private String questionCorrectAnswer;

    public MentalHealthQuestion(int questionNumber, String questionText, String[] questionOptions, String questionCorrectAnswer) {
        this.questionNumber = questionNumber;
        this.questionText = questionText;
        this.questionOptions = questionOptions;
        this.questionCorrectAnswer = questionCorrectAnswer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String[] getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(String[] questionOptions) {
        this.questionOptions = questionOptions;
    }

    public String getQuestionCorrectAnswer() {
        return questionCorrectAnswer;
    }

    public void setQuestionCorrectAnswer(String questionCorrectAnswer) {
        this.questionCorrectAnswer = questionCorrectAnswer;
    }
}
