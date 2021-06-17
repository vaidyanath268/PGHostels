package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChangeProfile extends AppCompatActivity {
    private CircleImageView profileImageView;
    private Button closeButton,saveButton;
    private TextView profileChangeBtn;

    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    private Uri imageUri;
    private String myUri = "" ;
    private StorageTask uploadTask;
    private StorageReference storageReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);
    }

    public void close(View view) {
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }
}