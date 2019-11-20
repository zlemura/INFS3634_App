package com.example.android.googlemapsapp.MentalHealthModuleFragments;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.android.googlemapsapp.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class MentalHealthContent2Fragment extends Fragment {

    View view;

    String url = "https://www.qld.gov.au/health/mental-health/lifestyle";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_mental_health_content2, container, false);

        new MyAsynTask().execute();

        return view;
    }

    private class MyAsynTask extends AsyncTask<Void, Void, Document> {
        @Override
        protected Document doInBackground(Void... voids) {

            Document document = null;
            try {
                document= Jsoup.connect(url).get();
                document.getElementById("qg-site-header").remove();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return document;
        }

        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);

            WebView contentWebView = view.findViewById(R.id.mentalHealthContentPage2WV);

            contentWebView.loadDataWithBaseURL(url,document.toString(),"text/html","utf-8","");
            contentWebView.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );

            contentWebView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    view.loadUrl(url);
                    return super.shouldOverrideUrlLoading(view, request);
                }
            });
        }
    }
}
