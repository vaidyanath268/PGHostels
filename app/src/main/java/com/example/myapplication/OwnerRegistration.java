package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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


public class OwnerRegistration extends AppCompatActivity {
    private EditText username, passward, cnfpassward, mail, phno,address,hostel_name,price,city_o;
    private  FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_registration);
        Button button=findViewById(R.id.submit_owner);
        username = findViewById(R.id.o_uname);
        passward = findViewById(R.id.pass_owner);
        cnfpassward = findViewById(R.id.oc_pass);
        mail = findViewById(R.id.mail_o);
        phno = findViewById(R.id.phn_no);
        price =findViewById(R.id.price);
        address =findViewById(R.id.o_address);
        hostel_name=findViewById(R.id.hostelname);
        city_o=findViewById(R.id.city);
        auth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,Object> map = new HashMap<>();
                map.put("Username",username.getText().toString());
                map.put("Email",mail.getText().toString());
                map.put("Passward",passward.getText().toString());
                map.put("Confirm_Passward",cnfpassward.getText().toString());
                map.put("Aadhaar_Hostel_Address",address.getText().toString());
                map.put("Hostel_Name",hostel_name.getText().toString());
                map.put("Price",price.getText().toString());
                map.put("Mobile_no",phno.getText().toString());
                map.put("City",city_o.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("OwnerDetails").push()
                        .setValue(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.i("owner","onComplete: ");
                                Toast.makeText(OwnerRegistration.this, "Successfully Register", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull  Exception e) {
                        Log.i("owner","onFailure: "+e.toString());
                        Toast.makeText(OwnerRegistration.this, " Register UnSuccessfull", Toast.LENGTH_SHORT).show();

                    }
                }).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.i("owner","onSuccess:");

                    }
                });
            }
        });



    }

    public void success(View view) {
        final String usernam = username.getText().toString();
        final String mypass = passward.getText().toString();
         final String confpaas = cnfpassward.getText().toString();
        final String emaill = mail.getText().toString();
        final String phnnum = phno.getText().toString();
       final String a_address = address.getText().toString();
       final String h_name = hostel_name.getText().toString();
       final String pprice=price.getText().toString();
        final String ccity=city_o.getText().toString();


        if (usernam.isEmpty()) {
            username.setError("Please Enter UserName");
        } else if (mypass.isEmpty()) {
            passward.setError("Please Enter Password");
        } else if (emaill.isEmpty()) {
            mail.setError("Please Enter Your Mail");
        } else if (confpaas.isEmpty() && !passward.equals(confpaas)) {
            cnfpassward.setError("Password is Not Matached");
        } else if (phnnum.isEmpty()) {
            phno.setError("Please enter Phone Number");
        } else if (h_name.isEmpty()) {
            hostel_name.setError("Please Enter Hostel Name");
        } else if (pprice.isEmpty()) {
            price.setError("Please Enter Price");
        }else if (ccity.isEmpty()) {
                city_o.setError("Please Enter City");
        } else if (a_address.isEmpty()) {
            address.setError("Please Enter Aadhaar Address");
        } else {
            auth.createUserWithEmailAndPassword(emaill, mypass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(OwnerRegistration.this, "Register Sucessfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(OwnerRegistration.this, Ownerlogin.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(OwnerRegistration.this, "Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void sigin(View view) {
        Intent i = new Intent(this, Ownerlogin.class);
        startActivity(i);

    }
}
