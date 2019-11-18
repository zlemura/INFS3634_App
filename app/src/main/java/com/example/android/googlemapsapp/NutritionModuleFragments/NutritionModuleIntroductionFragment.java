package com.example.android.googlemapsapp.NutritionModuleFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.googlemapsapp.R;

public class NutritionModuleIntroductionFragment extends Fragment {

    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_nutrition_module_introduction, container, false);

        System.out.println("MODULE INFLATED");

        return view;
    }

}
