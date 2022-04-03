package com.example.gryphus;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

public class ProductFragment extends Fragment {

    private ArrayList<Product> productList;
    private RecyclerView recyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_productrecycler, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = getView().findViewById(R.id.recycler);
        productList = new ArrayList<>();
        setProductInfo();
        setAdapter();

    }

    private void setAdapter() {
        productAdapter adapter = new productAdapter(productList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setProductInfo() {
        productList.add(new Product("Test Product 1", getContext().getDrawable(R.drawable.ic_settings)));
        productList.add(new Product("Test Product 2", getContext().getDrawable(R.drawable.ic_settings)));
        productList.add(new Product("Test Product 3", getContext().getDrawable(R.drawable.ic_settings)));
        productList.add(new Product("Test Product 4", getContext().getDrawable(R.drawable.ic_settings)));
        productList.add(new Product("Test Product 5", getContext().getDrawable(R.drawable.ic_settings)));
        productList.add(new Product("Test Product 6", getContext().getDrawable(R.drawable.ic_aboutus)));
        productList.add(new Product("Test Product 7", getContext().getDrawable(R.drawable.ic_home)));
        productList.add(new Product("Test Product 8", getContext().getDrawable(R.drawable.ic_search)));
        productList.add(new Product("Test Product 9", getContext().getDrawable(R.drawable.ic_login)));
        productList.add(new Product("Test Product 10",getContext().getDrawable(R.drawable.ic_settings) ));
        productList.add(new Product("Test Product 11",getContext().getDrawable(R.drawable.ic_settings) ));
        productList.add(new Product("Test Product 12",getContext().getDrawable(R.drawable.ic_settings) ));
        productList.add(new Product("Test Product 13",getContext().getDrawable(R.drawable.ic_settings) ));
        productList.add(new Product("Test Product 14",getContext().getDrawable(R.drawable.ic_settings) ));
        productList.add(new Product("Test Product 15",getContext().getDrawable(R.drawable.ic_settings) ));
        productList.add(new Product("Test Product 16",getContext().getDrawable(R.drawable.ic_settings) ));
    }
}