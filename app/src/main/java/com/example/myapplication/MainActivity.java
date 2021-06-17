package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1,button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.st_login);
        button2=findViewById(R.id.o_login);


    }

    public void Stu_login(View view) {
        Intent intent = new Intent(this,Studentlogin.class);
        startActivity(intent);
       // Toast.makeText(this, "Mainactivity", Toast.LENGTH_SHORT).show();
    }

    public void Own_login(View view) {
        Intent intent = new Intent(this,Ownerlogin.class);
        startActivity(intent);
    }
}