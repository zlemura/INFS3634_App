package com.example.android.googlemapsapp.MentalHealthModuleFragments;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity
public class MentalHealthQuestion implements Serializable {

    @PrimaryKey
    private int questionNumber;
    private String questionText;

    private List<String> optionList;

    private String correctAnswer;

    public MentalHealthQuestion(int questionNumber, String questionText,List<String> optionList, String correctAnswer){
        this.questionNumber=questionNumber;
        this.questionText = questionText;
        this.optionList=optionList;
        this.correctAnswer=correctAnswer;
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

    public List<String> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<String> optionList) {
        this.optionList = optionList;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
