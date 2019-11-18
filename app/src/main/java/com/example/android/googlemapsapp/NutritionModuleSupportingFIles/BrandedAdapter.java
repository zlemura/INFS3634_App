package com.example.android.googlemapsapp.NutritionModuleSupportingFIles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.googlemapsapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BrandedAdapter extends RecyclerView.Adapter<BrandedAdapter.ViewHolder> {

    private ArrayList<Branded> plateItemList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;

    public BrandedAdapter(Context context, ArrayList<Branded> plateItemList){
        this.layoutInflater = LayoutInflater.from(context);
        this.plateItemList=plateItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public BrandedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewGroup) {
        View view = layoutInflater.inflate(R.layout.foodchunk, parent, false);
        return new BrandedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.plateItemName.setText(plateItemList.get(i).getFood_name());
        viewHolder.plateItemCalories.setText(String.valueOf(plateItemList.get(i).getNf_calories()));

    }

    @Override
    public int getItemCount() {
        return plateItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView plateItemName;
        TextView plateItemCalories;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            plateItemName = itemView.findViewById(R.id.foodNameTV);
            plateItemCalories = itemView.findViewById(R.id.foodItemCaloriesTV);
        }
    }
}




