package com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.googlemapsapp.R;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MentalHealthQuestionsAndAnswersAdapter extends RecyclerView.Adapter<MentalHealthQuestionsAndAnswersAdapter.ViewHolder> {

    private ArrayList<Question> mentalHealthQuestions = new ArrayList<>();
    private HashMap<Integer,String> mentalHealthQuestionAndAnswerList = new HashMap<>();
    private LayoutInflater layoutInflater;
    private Context context;

    public MentalHealthQuestionsAndAnswersAdapter(Context context, ArrayList<Question> mentalHealthQuestions,
                                           HashMap<Integer,String> mentalHealthQuestionAndAnswerList){
        this.layoutInflater = LayoutInflater.from(context);
        this.mentalHealthQuestions = mentalHealthQuestions;
        this.mentalHealthQuestionAndAnswerList = mentalHealthQuestionAndAnswerList;
        this.context = context;
    }


    @NonNull
    @Override
    public MentalHealthQuestionsAndAnswersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.questionanswerchunk, parent, false);
        return new MentalHealthQuestionsAndAnswersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MentalHealthQuestionsAndAnswersAdapter.ViewHolder viewHolder, int i) {

        viewHolder.itemPosition = i;

        //Set question text textview value (for chunk)
        viewHolder.mentalHealthQuestionText.setText(mentalHealthQuestions.get(i).getQuestionText().toString());

        //Set users answer textview value (for chunk)
        viewHolder.mentalHealthQuestionUserAnswerText.setText(mentalHealthQuestionAndAnswerList.get(Integer.valueOf(mentalHealthQuestions.get(i).getQuestionNumber())).toString());
        //Set correct answer textview value (for chunk)
        viewHolder.mentalHealthQuestionCorrectAnswerText.setText(mentalHealthQuestions.get(i).getQuestionCorrectAnswer().toString());

        //If the users answer and correct answer text match, set constraintlayout (chunk) colour to green,
        //otherwise set the colour to red
        if(viewHolder.mentalHealthQuestionUserAnswerText.getText().equals(viewHolder.mentalHealthQuestionCorrectAnswerText.getText())){
            viewHolder.constraintLayoutQ.setBackgroundColor(Color.GREEN);
        }else{
            viewHolder.constraintLayoutQ.setBackgroundColor(Color.RED);
        }


    }

    @Override
    public int getItemCount() {
        return mentalHealthQuestions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int itemPosition;
        TextView mentalHealthQuestionText;
        TextView mentalHealthQuestionUserAnswerText;
        TextView mentalHealthQuestionCorrectAnswerText;
        ConstraintLayout constraintLayoutQ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            constraintLayoutQ = itemView.findViewById(R.id.questionAnswerCL);
            mentalHealthQuestionText = itemView.findViewById(R.id.questionTV);
            mentalHealthQuestionUserAnswerText = itemView.findViewById(R.id.usersAnswerTV);
            mentalHealthQuestionCorrectAnswerText = itemView.findViewById(R.id.correctAnswerTV);

        }
    }
}
