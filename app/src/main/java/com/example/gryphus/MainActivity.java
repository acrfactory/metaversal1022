package com.example.gryphus;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //removed default action bar, use @toolbar as default action bar


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //sets `toolbar` as actionbar
    }


}
