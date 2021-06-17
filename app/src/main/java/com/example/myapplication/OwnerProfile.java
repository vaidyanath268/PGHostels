package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class OwnerProfile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_profile);




        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_2);
        bottomNavigationView.setSelectedItemId(R.id.profile_2);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.settings_2:
                        startActivity(new Intent(getApplicationContext(),OwnerSettings.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home_2:
                        startActivity(new Intent(getApplicationContext(),OwnerHome.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile_2:
                        return true;
                }
                return false;
            }
        });
    }


}