package com.example.android.googlemapsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DataScraping extends AppCompatActivity {

    String informationUrl = "https://www.heartfoundation.org.au/active-living/get-active";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_scraping);

        TextView dataScraping = findViewById(R.id.dataScrapingTV);
        WebView dataScrapingWV = findViewById(R.id.dataScrapingWV);

        dataScrapingWV.setScrollY(20);

        dataScrapingWV.loadUrl("https://www.heartfoundation.org.au/active-living/get-active");


        //Can be used to scrape data, hard to format though
        /*
        MyTask task = new MyTask();
        Document webPageAsDocument = new Document("");

        try {
            webPageAsDocument = task.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Elements elementsWithInfo = webPageAsDocument.getElementsByClass("m_wysiwyg").get(0).getAllElements();

        StringBuilder textToDisplay = new StringBuilder();

        System.out.println("START OF LOOP");
        System.out.println(elementsWithInfo.size());
        for(int i=0;i<elementsWithInfo.size();i++){
            if(elementsWithInfo.get(i).tagName().equals("h2")){ //Loop for headers

                textToDisplay.append(elementsWithInfo.get(i).text());

            }else if(elementsWithInfo.get(i).tagName().equals("a")){ //Loop for paragraphs

            }else if(elementsWithInfo.get(i).tagName().equals("ul")){ //Loop for dot-points

            }
        }

        System.out.println("END OF LOOP");
         */




    }

    private class MyTask extends AsyncTask<Void, Void, Document> {

        private AsyncTaskDelegate delegate;

        public void setDelegate(AsyncTaskDelegate delegate) {
            this.delegate = delegate;
        }

        @Override
        protected Document doInBackground(Void... params) {
            String title ="";
            Document document = new Document("");
            String webpageData = "";
            try {
                document = Jsoup.connect(informationUrl).get();
                //Elements temp = document.getElementsByClass("m_wysiwyg");
                //webpageData = temp.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //activityInformation = webpageData;
            return document;
        }

        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);
        }
    }

}
