package com.example.android.googlemapsapp.ExcerciseModuleFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.android.googlemapsapp.R;

public class ExcerciseModuleContent2Fragment extends Fragment {

    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_excercise_module_content2, container, false);

        WebView contentWebView = view.findViewById(R.id.excerciseContentPage2WV);

        contentWebView.setScrollY(550);
        contentWebView.loadUrl("https://www.betterhealth.vic.gov.au/blog/blogcollectionpage/Conversation-10000steps");

        return view;
    }
}
