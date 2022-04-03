package com.example.gryphus;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class productAdapter extends RecyclerView.Adapter<productAdapter.myViewHolder> {


    private ArrayList<Product> productList;
    public productAdapter(ArrayList<Product> productList) {
        this.productList = productList;
    }


    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView nameText;
        private ImageView image;
        private ImageView favButton;


        public myViewHolder(final View v){
            super(v);
            nameText = v.findViewById(R.id.info);
            image = v.findViewById(R.id.imageView);
            favButton = v.findViewById(R.id.favButton);
            favButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    favButton.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                    Log.d("test", "onClick: like for product" + nameText);
                }
            });
        }
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_product, parent, false);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(parent.getContext(), "click successful", Toast.LENGTH_SHORT).show();
            }
        });

        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        String productName = productList.get(position).getName();
        holder.nameText.setText(productName);
        Drawable icon = productList.get(position).getIcon();
        holder.image.setImageDrawable(icon);


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
