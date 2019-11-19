
package com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question {

        private String questionOptions;

        private String questionText;

        private String questionCorrectAnswer;

        private String questionNumber;

        public String getQuestionOptions ()
        {
            return questionOptions;
        }

        public void setQuestionOptions (String questionOptions)
        {
            this.questionOptions = questionOptions;
        }

        public String getQuestionText ()
        {
            return questionText;
        }

        public void setQuestionText (String questionText)
        {
            this.questionText = questionText;
        }

        public String getQuestionCorrectAnswer ()
        {
            return questionCorrectAnswer;
        }

        public void setQuestionCorrectAnswer (String questionCorrectAnswer)
        {
            this.questionCorrectAnswer = questionCorrectAnswer;
        }

        public String getQuestionNumber ()
        {
            return questionNumber;
        }

        public void setQuestionNumber (String questionNumber)
        {
            this.questionNumber = questionNumber;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [questionOptions = "+questionOptions+", questionText = "+questionText+", questionCorrectAnswer = "+questionCorrectAnswer+", questionNumber = "+questionNumber+"]";
        }
    }