package com.example.gryphus;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class SearchFragment extends Fragment {
    private ArrayList<Filter> filterList;
    private String[] filter = {"Price", " - High", " - Low", "Location", " - Ontario", " - BC", "Manufacturer",
            " - CompanyA", " - CompanyB", " - CompanyC", " - CompanyD"};
    ListView list;


    SharedPreferences sharedFilter;
    SharedPreferences.Editor sharedFilterEditor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container,false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        sharedFilter = Objects.requireNonNull(getActivity()).getApplicationContext()
                .getSharedPreferences("Filter",Context.MODE_PRIVATE);
        sharedFilterEditor = sharedFilter.edit();


        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, filter);
        list = getView().findViewById(R.id.list);
                list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (!filter[i].equals("Price") && !filter[i].equals("Location") && !filter[i].equals("Manufacturer")) {

                    sharedFilterEditor.putString("");
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,
                                    new ProductFragment()).addToBackStack(null).commit();
                }
            }
        });


    }




}
