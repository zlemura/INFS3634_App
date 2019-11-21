package com.example.android.googlemapsapp.MentalHealthModuleFragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.googlemapsapp.NutritionModuleFragments.PlateBuilder;
import com.example.android.googlemapsapp.R;

public class MentalHealthModuleQuizOverviewFragment extends Fragment {

    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_mental_health_module_quiz_overview, container, false);

        Button nextBtn = view.findViewById(R.id.mentalHealthQuizOverviewNextBtn);

        //Takes user to MentalHealthQuizActivity.class, this is the activity for the quiz module.

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), MentalHealthQuizActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
