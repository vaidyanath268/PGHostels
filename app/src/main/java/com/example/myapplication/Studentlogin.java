package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Studentlogin extends AppCompatActivity {
    EditText email,pass;
    SharedPreferences sp;
    TextView textView;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlogin);
        auth = FirebaseAuth.getInstance();
        email=findViewById(R.id.mailid);
        pass=findViewById(R.id.pass);


       /* if (auth.getCurrentUser() != null) {
            startActivity(new Intent(Studentlogin.this, MainActivity.class));
            finish();
        }*/
    }
    public void Login(View view) {
        String emaill=email.getText().toString();
        String mypass=pass.getText().toString();
        /*String nn=RegisterPage..getString("Emaill","");
        String pp=RegisterPage..getString("Passwoard","");
        if (nn.equals(emaill) && pp.equals(mypass)){
//            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Login failed ", Toast.LENGTH_SHORT).show();
        }*/


        auth.signInWithEmailAndPassword(emaill, mypass).addOnCompleteListener(Studentlogin.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Studentlogin.this, "Login Sucess", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(Studentlogin.this, "Invalid User", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Intent intent = new Intent(this,StudentHome.class);
        startActivity(intent);
        CheckBox showpass;
        showpass=findViewById(R.id.showpass);
        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    showpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    showpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
 

    }
    public void signup(View view) {
        Intent intent=new Intent(this,StuRegistration.class);
        startActivity(intent);

    }


    public void fpass(View view) {
    }
}
