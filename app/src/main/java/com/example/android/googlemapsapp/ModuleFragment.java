package com.example.android.googlemapsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.lang.reflect.Type;

public class ModuleFragment extends Fragment {

    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_module, container, false);

        Button excerciseModuleButton = view.findViewById(R.id.excerciseModuleButton);

        excerciseModuleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(),ExcerciseModulePlaceholder.class);
                startActivity(intent);
            }
        });

        Button nutritionModuleButton = view.findViewById(R.id.nutritionModuleButton);

        nutritionModuleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), NutritionModulePlaceholder.class);
                startActivity(intent);
            }
        });

        Button mentalHealthModuleButton = view.findViewById(R.id.mentalHealthModuleButton);

        mentalHealthModuleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(),MentalHealthModulePlaceholder.class);
                startActivity(intent);
            }
        });

        return view;
    }

}


