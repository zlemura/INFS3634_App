package com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles;

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

public class MentalHealthQuestionAdapter extends RecyclerView.Adapter<MentalHealthQuestionAdapter.ViewHolder> {

    private ArrayList<Question> mentalHealthQuestions = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;
    private HashMap<Question,Boolean> listForIfItemChecked = new HashMap<>();
    private HashMap<Integer,String> listForItemsWithAnswers = new HashMap<>();

    public MentalHealthQuestionAdapter(Context context, ArrayList<Question> mentalHealthQuestions) {
        this.layoutInflater = LayoutInflater.from(context);
        this.mentalHealthQuestions=mentalHealthQuestions;
        this.context = context;
    }

    @NonNull
    @Override
    public MentalHealthQuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.questionchunk, parent, false);
        return new MentalHealthQuestionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MentalHealthQuestionAdapter.ViewHolder viewHolder, int i) {

        viewHolder.itemPosition = i;
        viewHolder.mentalHealthQuestionText.setText(mentalHealthQuestions.get(i).getQuestionText());

        //Split the possible options and assign them to radio buttons
        String[] options = mentalHealthQuestions.get(i).getQuestionOptions().split(",");

        viewHolder.mentalHealthQuestionOption1.setText(options[0]);
        viewHolder.mentalHealthQuestionOption2.setText(options[1]);
        viewHolder.mentalHealthQuestionOption3.setText(options[2]);

        System.out.println("All elements added for " + i);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         int itemPosition;
         TextView mentalHealthQuestionText;
         RadioGroup mentalHealthOptionsGroup;
         RadioButton mentalHealthQuestionOption1;
         RadioButton mentalHealthQuestionOption2;
         RadioButton mentalHealthQuestionOption3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mentalHealthQuestionText = itemView.findViewById(R.id.mentalHealthQuestionText);
            mentalHealthQuestionOption1 = itemView.findViewById(R.id.radioButton1);
            mentalHealthQuestionOption2 = itemView.findViewById(R.id.radioButton2);
            mentalHealthQuestionOption3 = itemView.findViewById(R.id.radioButton3);
            mentalHealthOptionsGroup= itemView.findViewById(R.id.radioBtnGroup);

            mentalHealthOptionsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    //Add question to listForItemChecked hashmap, indicating the question has been answered
                    listForIfItemChecked.put(mentalHealthQuestions.get(itemPosition),true);
                    System.out.println("KeySET:" + listForIfItemChecked.keySet());

                    int checkedButtonId = group.getCheckedRadioButtonId();

                    if(mentalHealthQuestionOption1.getId() == checkedButtonId){
                        //If first button pressed, add question number and answer value to listForItemsWithAnswers hashmap.
                        //This will be used in MentalHealthQuizActivity.class to determine if user has passed or failed
                        System.out.println("THESELECTEDIS" + mentalHealthQuestionOption1.getText());
                        listForItemsWithAnswers.put(Integer.valueOf(mentalHealthQuestions.get(itemPosition).getQuestionNumber()),mentalHealthQuestionOption1.getText().toString());

                    }else if(mentalHealthQuestionOption2.getId() == checkedButtonId){
                        //If second button pressed, add question number and answer value to listForItemsWithAnswers hashmap.
                        //This will be used in MentalHealthQuizActivity.class to determine if user has passed or failed
                        System.out.println("THESELECTEDIS" + mentalHealthQuestionOption2.getText());
                        listForItemsWithAnswers.put(Integer.valueOf(mentalHealthQuestions.get(itemPosition).getQuestionNumber()),mentalHealthQuestionOption2.getText().toString());

                    }else if(mentalHealthQuestionOption3.getId() == checkedButtonId){
                        //If third button pressed, add question number and answer value to listForItemsWithAnswers hashmap.
                        //This will be used in MentalHealthQuizActivity.class to determine if user has passed or failed
                        System.out.println("THESELECTEDIS" + mentalHealthQuestionOption3.getText());
                        listForItemsWithAnswers.put(Integer.valueOf(mentalHealthQuestions.get(itemPosition).getQuestionNumber()),mentalHealthQuestionOption3.getText().toString());

                    }

                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return mentalHealthQuestions.size();
    }

    public ArrayList<Question> getMentalHealthQuestions() {
        return mentalHealthQuestions;
    }

    public HashMap<Question, Boolean> getListForIfItemChecked() {
        return listForIfItemChecked;
    }

    public HashMap<Integer, String> getListForItemsWithAnswers() {
        return listForItemsWithAnswers;
    }
}
