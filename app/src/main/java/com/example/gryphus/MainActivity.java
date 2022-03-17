package com.example.gryphus;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //removed default action bar, use @toolbar as default action bar


//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar); //sets `toolbar` as actionbar


    }

    private  String getContentOfEditText(int id){
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String str = editText.getText().toString();
        return str;
    }//get String value from view


        public void login (View view) {
            LayoutInflater logInflater = getLayoutInflater();
            View view1 = logInflater.inflate(R.layout.login,null);
            setContentView(view1);
        }



}
