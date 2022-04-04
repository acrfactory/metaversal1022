package com.example.gryphus;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class productAdapter extends RecyclerView.Adapter<productAdapter.myViewHolder> {


    private ArrayList<Product> productList;

    public productAdapter(ArrayList<Product> productList) {
        this.productList = productList;
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

    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView nameText;
        private ImageView image;
        private ImageView favButton;
        private Drawable likeFill;
        private Drawable likeEmpty;
        private int likeState = 0;


        public myViewHolder(final View v) {
            super(v);
            nameText = v.findViewById(R.id.info);
            image = v.findViewById(R.id.imageView);
            favButton = v.findViewById(R.id.favButton);
            likeFill = favButton.getContext().getDrawable(R.drawable.ic_baseline_favorite_24);
            likeEmpty = favButton.getContext().getDrawable(R.drawable.ic_baseline_favorite_border_24);
            favButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (likeState == 0) {
                        favButton.setImageDrawable(likeFill);
                        Toast.makeText(favButton.getContext(), "Added to Watchlist", Toast.LENGTH_SHORT).show();
                        likeState++;
                    } else if (likeState == 1) {
                        Toast.makeText(favButton.getContext(), "Removed from Watchlist", Toast.LENGTH_SHORT).show();
                        favButton.setImageDrawable(likeEmpty);
                        likeState = 0;
                    }
                }
            });
        }
    }
}