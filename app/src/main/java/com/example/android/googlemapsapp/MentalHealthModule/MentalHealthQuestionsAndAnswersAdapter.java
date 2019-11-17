package com.example.android.googlemapsapp.MentalHealthModule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.android.googlemapsapp.R;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MentalHealthQuestionsAndAnswersAdapter extends RecyclerView.Adapter<MentalHealthQuestionsAndAnswersAdapter.ViewHolder> {

    private ArrayList<MentalHealthQuestion> mentalHealthQuestions = new ArrayList<>();
    private HashMap<Integer,String> mentalHealthQuestionAndAnswerList = new HashMap<>();
    private LayoutInflater layoutInflater;
    private Context context;

    MentalHealthQuestionsAndAnswersAdapter(Context context, ArrayList<MentalHealthQuestion> mentalHealthQuestions,
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

        System.out.println("IM IN THE ON BIND NOW");

        viewHolder.itemPosition = i;

        viewHolder.mentalHealthQuestionUserAnswerText.setText(mentalHealthQuestionAndAnswerList.get(mentalHealthQuestions.get(i).getQuestionNumber()).toString());
        viewHolder.mentalHealthQuestionCorrectAnswerText.setText(mentalHealthQuestions.get(i).getCorrectAnswer().toString());

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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mentalHealthQuestionText = itemView.findViewById(R.id.mentalHealthQuestionText);
            mentalHealthQuestionUserAnswerText = itemView.findViewById(R.id.usersAnswerTV);
            mentalHealthQuestionCorrectAnswerText = itemView.findViewById(R.id.correctAnswerTV);

        }
    }
}
