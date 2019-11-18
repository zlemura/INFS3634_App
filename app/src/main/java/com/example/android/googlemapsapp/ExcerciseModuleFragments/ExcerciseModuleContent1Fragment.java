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
import android.webkit.WebView;
import android.widget.Button;

import com.example.android.googlemapsapp.R;


public class ExcerciseModuleContent1Fragment extends Fragment {

    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_excercise_module_content1, container, false);

        WebView contentWebView = view.findViewById(R.id.excerciseContentPage1WV);

        contentWebView.setScrollY(550);
        contentWebView.loadUrl("https://www.healthdirect.gov.au/exercise-and-mental-health");

        return view;
    }

}
