package com.example.android.googlemapsapp.ExcerciseModuleFragments;

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

import com.example.android.googlemapsapp.R;

public class ExcerciseModuleIntroductionFragment extends Fragment {

    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_excercise_module_introduction, container, false);

        System.out.println("MODULE INFLATED");

        return view;
    }
}
