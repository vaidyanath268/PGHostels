package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class OwnerSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_settings);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_2);
        bottomNavigationView.setSelectedItemId(R.id.settings);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.settings_2:
                        return true;
                    case R.id.home_2:
                        startActivity(new Intent(getApplicationContext(),OwnerHome.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile_2:
                        startActivity(new Intent(getApplicationContext(),OwnerProfile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}