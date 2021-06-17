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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Ownerlogin extends AppCompatActivity {
    EditText email,pass;
    SharedPreferences sp;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ownerlogin);
        auth = FirebaseAuth.getInstance();
        email=findViewById(R.id.mail_id);
        pass=findViewById(R.id.o_pass);

       /* if (auth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            finish();
        }*/
    }
    public void Logg(View view) {
        String emaill=email.getText().toString();
        String mypass=pass.getText().toString();
        Intent intent = new Intent(this,OwnerHome.class);
        startActivity(intent);
        /*String nn=RegisterPage..getString("Emaill","");
        String pp=RegisterPage..getString("Passwoard","");
        if (nn.equals(emaill) && pp.equals(mypass)){
//            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Login failed ", Toast.LENGTH_SHORT).show();
        }*/


        auth.signInWithEmailAndPassword(emaill, mypass).addOnCompleteListener(Ownerlogin.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Ownerlogin.this, "Login Sucess", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(Ownerlogin.this, "Invalid User", Toast.LENGTH_SHORT).show();
                }
            }
        });
        CheckBox showpassward;
        showpassward=findViewById(R.id.showpassward);
        showpassward.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    showpassward.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    showpassward.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }

    public void reg(View view) {
        Intent intent=new Intent(this,OwnerRegistration.class);
        startActivity(intent);
    }
}
