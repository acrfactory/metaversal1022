package com.example.gryphus;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //removed default action bar, use @toolbar as default action bar

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout); // allows listeners to be set for open/close events.

//        Button ok = findViewById(R.id.bottom_bar);
//        ok.setOnClickListener();



        BottomNavigationView bottomNav = findViewById(R.id.bottom_bar);
        NavigationBarView.OnItemSelectedListener bottomNavListener = new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new HomeFragment()).commit();
                        break;
                    case R.id.bottom_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new SearchFragment()).commit();
                        break;
                    case R.id.bottom_watchlist:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new WatchlistFragment()).commit();
                        break;
                }
                return true;
            }

        };

        bottomNav.setOnItemSelectedListener(bottomNavListener);





        // handles clicks on navigation drawer !!!CHANGE "this"

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ProductFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_login);
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_aboutus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutUsFragment()).commit();
                break;
            case R.id.nav_login:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LoginFragment()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private String getContentOfEditText(int id){
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String str = editText.getText().toString();
        return str;
    }


    // conditional on `onBackPressed` method to not exit activity if drawer is open. Instead, it will close the drawer
    // used .START as menu is on left side of container
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}