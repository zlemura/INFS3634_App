package com.example.android.googlemapsapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles.MentalHealthQuestionsAndAnswersAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SpecialOffersFragment extends Fragment {

    RecyclerView recyclerView;
    SpecialOffersAdapter specialOffersAdapter;
    View view;

    //Temporary special offer arraylist to store all unlocked special offers
    private static ArrayList<SpecialOffers> unlockedSpecialOfferList = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_special_offers, container, false);

        TextView noOffersTV = view.findViewById(R.id.noOffersTV);

        //Method to determine what offers have been unlocked using the variables from the MainActivity.class
        //and adding new special offer objects to the 'unlockedSpecialOfferList' array list
        checkUnlockedSpecialOffers();

        //If no special offers have been unlocked by the user a textview informing them they have not
        //unlocked any offers is show. This if-statemetn will hide this if the 'unlockedSpecialOfferList' size
        //is greater than 0, meaning at least one offer has been unlocked. This also populates the special
        //offer recyclerview with elements from the 'unlockedSpecialOfferList' array-list.
        if(unlockedSpecialOfferList.size() >0){

            noOffersTV.setVisibility(View.INVISIBLE);

            recyclerView = view.findViewById(R.id.specialOfferRV);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            specialOffersAdapter = new SpecialOffersAdapter(view.getContext(),unlockedSpecialOfferList);
            recyclerView.setAdapter(specialOffersAdapter);

        }else{

        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        //Notifies the recyclerview adapter that data may have changed (in the 'unlockedSpecialOfferList' array list
        //and that the adapter should check for changes; to be added to the recyclerview.

        if(unlockedSpecialOfferList.size() >0){
            unlockedSpecialOfferList.clear();
            checkUnlockedSpecialOffers();
            specialOffersAdapter.notifyDataSetChanged();
        }
    }

    public void checkUnlockedSpecialOffers(){

        //Method to determine what offers have been unlocked using the variables from the MainActivity.class
        //and adding new special offer objects to the 'unlockedSpecialOfferList' array list

        if(MainActivity.isExcerciseModuleComplete() == true){
            SpecialOffers excerciseOffer = new SpecialOffers("UNSW Gym",
                    "You have unlocked 15% off your monthly payments at the UNSW gym. " +
                            "To claim simply ask the gym receptionist to scan the QR code below when signing-up!",
                    "excercise","UNSW Gym Discount");
            unlockedSpecialOfferList.add(excerciseOffer);
        }

        if(MainActivity.isNutritionModuleComplete() == true){
            SpecialOffers nutritionOffer = new SpecialOffers("Boost Juice",
                    "You have unlocked 50% off an original Boost Juice product. To claim simply ask the server at Boost Juice to scan the below QR code!",
                    "nutrition","Boost Juice Discount");

            unlockedSpecialOfferList.add(nutritionOffer);
        }

        if(MainActivity.isMentalHealthModuleComplete() == true){
            SpecialOffers mentalHealthOffer = new SpecialOffers("Puppy Therapy",
                    "You have unlocked an exclusive invite to Puppy Therapy - an " +
                            "initiatve sponsored by ARC to promote stressing less! You can find times " +
                            "for the event by scanning the below QR code!","mentalhealth","Puppy Therapy Session");

            unlockedSpecialOfferList.add(mentalHealthOffer);
        }

    }

    public static ArrayList<SpecialOffers> getUnlockedSpecialOfferList() {
        return unlockedSpecialOfferList;
    }
}
