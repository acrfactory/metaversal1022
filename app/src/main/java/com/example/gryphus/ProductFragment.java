package com.example.gryphus;

import android.content.Context;
import android.content.SharedPreferences;
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
import java.util.Objects;
import java.util.Random;

public class ProductFragment extends Fragment {

    private ArrayList<Product> productList;
    private RecyclerView recyclerView;
    private Random rand = new Random();

    SharedPreferences sharedPrice;
    SharedPreferences.Editor sharedPriceEditor;


    SharedPreferences sharedLocation;
    SharedPreferences.Editor sharedLocationEditor;

    SharedPreferences sharedManufac;
    SharedPreferences.Editor sharedManufacEditor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_productrecycler, container, false);

    }

    @Nullable
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        sharedPrice = Objects.requireNonNull(getActivity()).getApplicationContext()
                .getSharedPreferences("productPrice",Context.MODE_PRIVATE);

        sharedPriceEditor = sharedPrice.edit();
        
        sharedLocation = Objects.requireNonNull(getActivity()).getApplicationContext()
                .getSharedPreferences("productLocation",Context.MODE_PRIVATE);

        sharedLocationEditor = sharedLocation.edit();
        
        sharedManufac = Objects.requireNonNull(getActivity()).getApplicationContext()
                .getSharedPreferences("productManufacturer",Context.MODE_PRIVATE);

        sharedManufacEditor = sharedManufac.edit();
        
        
        recyclerView = getView().findViewById(R.id.recycler);
        productList = new ArrayList<>();
        if (productList.size() == 0){
            setProductInfo();
            setProductID();
            setProductLoc();
            setProductManu();
            setProductPrice();
    } else {

        }

        for (Product products:
             productList) {
            sharedPriceEditor.putInt(products.getName(),products.getPrice());
        }
        
        
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

    private void setProductID() {
        for (Product products:
             productList) {
            int id = 0;
            for (int i = 0; i < 6; i++) {
                id += rand.nextInt(8)+1;
                id *= 10;
            }
            products.setItemID(id);
        }
    }
    
    private void setProductLoc() {
        for (int i = 0; i < 8; i++) {
            sharedLocationEditor.putString(productList.get(i).getName(),"Ontario");
        }
        for (int i = 8; i < 16; i++) {
            sharedLocationEditor.putString(productList.get(i).getName(),"BC");
        }
    }

    private void setProductManu() {
        for (int i = 0; i <4; i++) {
            sharedManufacEditor.putString(productList.get(i).getName(),"CompanyA");
        }
        for (int i = 4; i < 8; i++) {
            sharedManufacEditor.putString(productList.get(i).getName(),"CompanyB");
        }
        for (int i = 8; i < 12; i++) {
            sharedManufacEditor.putString(productList.get(i).getName(),"CompanyC");
        }
        for (int i = 12; i < 16; i++) {
            sharedManufacEditor.putString(productList.get(i).getName(),"CompanyD");
        }


    }

    private void setProductPrice() {
        for (int i = 0; i < 8 ; i++) {
            sharedPriceEditor.putInt(productList.get(i).getName(), 500);
        }
        for (int i = 8; i < 16 ; i++) {
            sharedPriceEditor.putInt(productList.get(i).getName(), 2000);
        }
    }
}