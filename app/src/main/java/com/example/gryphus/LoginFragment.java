package com.example.gryphus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button accountCreation = getView().findViewById(R.id.createAccount);
        accountCreation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SignUpFragment()).commit();
            }
        });

        Button logIn =  getView().findViewById(R.id.confirm);
        EditText userInput = getView().findViewById(R.id.inputUsername);
        EditText password = getView().findViewById(R.id.inputPassword);
        logIn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick (View view) {
            AccountModel accountModel = new AccountModel();

            accountModel.getContentOfEditText();
            if (accountModel.valid) {
                Toast.makeText(getActivity().getApplicationContext() , "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
            } else {
                    Toast.makeText(getActivity().getApplicationContext() , "LOGIN FAILED", Toast.LENGTH_SHORT).show()
                }

            }
        });



    }


}
