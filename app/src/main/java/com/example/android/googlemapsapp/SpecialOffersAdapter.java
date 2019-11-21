package com.example.android.googlemapsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.googlemapsapp.MentalHealthModuleSupportingFiles.MentalHealthQuestionsAndAnswersAdapter;
import com.example.android.googlemapsapp.NutritionModuleSupportingFIles.BrandedAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class SpecialOffersAdapter extends RecyclerView.Adapter<SpecialOffersAdapter.ViewHolder> {

    private ArrayList<SpecialOffers> specialOffersList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;

    public SpecialOffersAdapter(Context context, ArrayList<SpecialOffers> specialOffersList){
        this.layoutInflater = LayoutInflater.from(context);
        this.specialOffersList=specialOffersList;
        this.context=context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.specialofferchunk, parent, false);
        return new SpecialOffersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.itemPosition = i;

        viewHolder.specialOfferPlaceTV.setText(specialOffersList.get(i).getSpecialOfferPlace().toString());

        int id = context.getResources().getIdentifier(specialOffersList.get(i).getSpecialOfferModule(), "drawable", context.getPackageName());

        viewHolder.specialOfferImageView.setImageResource(id);

    }

    @Override
    public int getItemCount() {
        return specialOffersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        int itemPosition;
        TextView specialOfferPlaceTV;
        ImageView specialOfferImageView;
        ConstraintLayout specialOfferCL;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            specialOfferCL = itemView.findViewById(R.id.specialOfferCL);
            specialOfferPlaceTV = itemView.findViewById(R.id.specialOfferPlaceTV);
            specialOfferImageView = itemView.findViewById(R.id.specialOfferImageView);

            specialOfferCL.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    SpecialOffers tempOffer =specialOffersList.get(itemPosition);

                    Intent intent = new Intent(context,SpecialOfferDetailActivity.class);
                    intent.putExtra("offerModule",tempOffer.getSpecialOfferModule());
                    context.startActivity(intent);

                }
            });

        }
    }
}
