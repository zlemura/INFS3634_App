package com.example.android.googlemapsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SpecialOfferDetailActivity extends AppCompatActivity {

    SpecialOffers offerForActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_offer_detail);

        ArrayList<SpecialOffers> unlockedSpecialOfferList = SpecialOffersFragment.getUnlockedSpecialOfferList();

        Intent intent = getIntent();
        String module = intent.getStringExtra("offerModule");

        System.out.println("THE MODULE TEXT IS:" + module);

        for(int i=0;i<unlockedSpecialOfferList.size();i++){
            if(unlockedSpecialOfferList.get(i).getSpecialOfferModule().equals(module)){
                offerForActivity = unlockedSpecialOfferList.get(i);
            }
        }

        System.out.println("THE UNLOCKED MODULE IS" + offerForActivity.getSpecialOfferModule());

        TextView specialOfferPlaceTV = findViewById(R.id.specialOfferPlaceNameTV);
        TextView specialOfferDescriptionTV = findViewById(R.id.specialOfferDescriptionTV);
        ImageView specialOfferImageView = findViewById(R.id.specialOfferIV);
        ImageView specialOfferQRCode = findViewById(R.id.specialOfferQRCode);

        specialOfferPlaceTV.setText(offerForActivity.getSpecialOfferPlace());
        specialOfferDescriptionTV.setText(offerForActivity.getSpecialOfferText());

        int id = getResources().getIdentifier(offerForActivity.getSpecialOfferModule(), "drawable", getPackageName());

        specialOfferImageView.setImageResource(id);

        specialOfferQRCode.setImageResource(R.drawable.qrcode);



    }

}
