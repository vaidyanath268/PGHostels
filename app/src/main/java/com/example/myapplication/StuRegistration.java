package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class StuRegistration extends AppCompatActivity {
    EditText usr, passww, conf, mail, phno;
    FirebaseUser user;
    FirebaseAuth auth;
    DatabaseReference reference;

    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_registration);
        usr = findViewById(R.id.s_user);
        passww = findViewById(R.id.s_pass);
        conf = findViewById(R.id.cs_pass);
        mail = findViewById(R.id.s_email);
        //  phno = findViewById(R.id.phone);
        auth = FirebaseAuth.getInstance();

    }

    public void submit(View view) {
        final String usernam = usr.getText().toString();
        final String mypass = passww.getText().toString();
        final String confpaas = conf.getText().toString();
        final String emaill = mail.getText().toString();
        //final String phnnum = phno.getText().toString();

        if (usernam.isEmpty()) {
            usr.setError("Please Enter UserName");
        } else if (mypass.isEmpty()) {
            passww.setError("Please Enter Password");
        } else if (emaill.isEmpty()) {
            mail.setError("Please Enter Your Mail");
        } else if (confpaas.isEmpty() && !passww.equals(confpaas)) {
            conf.setError("Password is Not Matached");
        /*} else if (phnnum.isEmpty()) {
            phno.setError("Please enter Phone Number");*/
        } else {
            auth.createUserWithEmailAndPassword(emaill, mypass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(StuRegistration.this, "Register Sucessfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(StuRegistration.this, Studentlogin.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(StuRegistration.this, "Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void sigin(View view) {
        Intent i = new Intent(this, Studentlogin.class);
        startActivity(i);
    }
}

