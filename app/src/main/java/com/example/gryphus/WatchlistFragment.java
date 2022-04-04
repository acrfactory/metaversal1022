package com.example.gryphus;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WatchlistFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_watchlist, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences pref = getContext().getSharedPreferences("favDB", Context.MODE_PRIVATE);
        SharedPreferences userPref = getContext().getSharedPreferences("accountDB", Context.MODE_PRIVATE);
        String username = userPref.getString("username","");


        Set<String> userFavSet = pref.getStringSet(username,new HashSet<>());
        ArrayList<Product> favProducts = new ArrayList<>();

        for (Product entry:
             ProductFragment.productList) {
            if (userFavSet.contains(String.valueOf(entry.getItemID()))) {
                favProducts.add(entry);
            }
        }



        //////////////here



    }
}
