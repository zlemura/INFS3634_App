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
import android.webkit.WebView;
import android.widget.Button;

import com.example.android.googlemapsapp.R;

public class NutritionModuleContent2Fragment extends Fragment {

    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_nutrition_module_content2, container, false);

        WebView contentWebView = view.findViewById(R.id.nutritionContentPage2WV);

        contentWebView.loadUrl("https://www.eatforhealth.gov.au/guidelines/about-australian-dietary-guidelines");
        contentWebView.setScrollY(350);


        return view;
    }

}
