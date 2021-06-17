package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class StudentHome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new recFragment()).commit();



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
         bottomNavigationView.setSelectedItemId(R.id.home);

         bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                 switch (item.getItemId()){
                     case R.id.settings:
                         startActivity(new Intent(getApplicationContext(),Settings.class));
                         overridePendingTransition(0,0);
                         return true;
                     case R.id.home:
                         return true;
                     case R.id.profile:
                         startActivity(new Intent(getApplicationContext(),Profile.class));
                         overridePendingTransition(0,0);
                         return true;
                 }
                 return false;
             }
         });
    }


}