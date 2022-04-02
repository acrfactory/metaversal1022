package com.example.gryphus;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Objects;

public class ProductFragment extends Fragment {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false);
    }
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        sharedPreferences = Objects.requireNonNull(getActivity()).getApplicationContext()
//                .getSharedPreferences("accountDB", Context.MODE_PRIVATE);
//
//        sharedPreferencesEditor = sharedPreferences.edit();
//
//
//        Button move1 = getView().findViewById(R.id.list1);
//        move1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ImageView prd1 = getView().findViewById(R.id.product1);
//                ImageView prd2 = getView().findViewById(R.id.product2);
//                ImageView prd3 = getView().findViewById(R.id.product3);
//                ImageView prd4 = getView().findViewById(R.id.product4);
//                prd1.setImageResource();
//                prd2.setImageResource();
//                prd3.setImageResource();
//                prd4.setImageResource();
//            }
//        });
//
//        Button move2 = getView().findViewById(R.id.list2);
//        move1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ImageView prd1 = getView().findViewById(R.id.product1);
//                ImageView prd2 = getView().findViewById(R.id.product2);
//                ImageView prd3 = getView().findViewById(R.id.product3);
//                ImageView prd4 = getView().findViewById(R.id.product4);
//                prd1.setImageResource();
//                prd2.setImageResource();
//                prd3.setImageResource();
//                prd4.setImageResource();
//            }
//        });
//
//        Button move3 = getView().findViewById(R.id.list3);
//        move1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ImageView prd1 = getView().findViewById(R.id.product1);
//                ImageView prd2 = getView().findViewById(R.id.product2);
//                ImageView prd3 = getView().findViewById(R.id.product3);
//                ImageView prd4 = getView().findViewById(R.id.product4);
//                prd1.setImageResource();
//                prd2.setImageResource();
//                prd3.setImageResource();
//                prd4.setImageResource();
//            }
//        });
//    }
}