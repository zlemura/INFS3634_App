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

    private ArrayList<MentalHealthQuestion> mentalHealthQuestions = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;
    private HashMap<MentalHealthQuestion,Boolean> listForIfItemChecked = new HashMap<>();
    private HashMap<Integer,String> listForItemsWithAnswers = new HashMap<>();

    public MentalHealthQuestionAdapter(Context context, ArrayList<MentalHealthQuestion> mentalHealthQuestions) {
        this.layoutInflater = LayoutInflater.from(context);
        this.mentalHealthQuestions = mentalHealthQuestions;
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

        /*viewHolder.mentalHealthQuestionOption1.setText(mentalHealthQuestions.get(i).getOptionList().get(0));
        viewHolder.mentalHealthQuestionOption2.setText(mentalHealthQuestions.get(i).getOptionList().get(1));
        viewHolder.mentalHealthQuestionOption3.setText(mentalHealthQuestions.get(i).getOptionList().get(2));*/

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
                    listForIfItemChecked.put(mentalHealthQuestions.get(itemPosition),true);

                    int checkedButtonId = group.getCheckedRadioButtonId();

                    if(mentalHealthQuestionOption1.getId() == checkedButtonId){
                        System.out.println("THESELECTEDIS" + mentalHealthQuestionOption1.getText());
                        listForItemsWithAnswers.put(mentalHealthQuestions.get(itemPosition).getQuestionNumber(),mentalHealthQuestionOption1.getText().toString());
                    }else if(mentalHealthQuestionOption2.getId() == checkedButtonId){
                        System.out.println("THESELECTEDIS" + mentalHealthQuestionOption2.getText());
                        listForItemsWithAnswers.put(mentalHealthQuestions.get(itemPosition).getQuestionNumber(),mentalHealthQuestionOption2.getText().toString());
                    }else if(mentalHealthQuestionOption3.getId() == checkedButtonId){
                        System.out.println("THESELECTEDIS" + mentalHealthQuestionOption3.getText());
                        listForItemsWithAnswers.put(mentalHealthQuestions.get(itemPosition).getQuestionNumber(),mentalHealthQuestionOption3.getText().toString());
                    }

                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return mentalHealthQuestions.size();
    }

    public HashMap<MentalHealthQuestion, Boolean> getListForIfItemChecked() {
        return listForIfItemChecked;
    }

    public void setListForIfItemChecked(HashMap<MentalHealthQuestion, Boolean> listForIfItemChecked) {
        this.listForIfItemChecked = listForIfItemChecked;
    }

    public HashMap<Integer, String> getListForItemsWithAnswers() {
        return listForItemsWithAnswers;
    }
}
