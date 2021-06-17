package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class Profile extends AppCompatActivity {
    Button chgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        chgbtn=findViewById(R.id.change_pic);
        chgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChangeProfile();

            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(),Settings.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),StudentHome.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        return true;
                }
                return false;
            }
        });
    }

    private void openChangeProfile() {
        Intent intent = new Intent(this,ChangeProfile.class);
        startActivity(intent);
    }

}