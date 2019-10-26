package com.jilani.e_medicine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Userprofile extends AppCompatActivity implements View.OnClickListener {

    FirebaseDatabase database;
    DatabaseReference myRef, kala;
    FirebaseAuth auth;
    String m;
    userdata user;
    EditText username, mobile, adress;
    TextView email;
    Query q;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_userprofile);
        username = findViewById(R.id.username);
        mobile = findViewById(R.id.mobile);
        adress = findViewById(R.id.address);
        email = findViewById(R.id.email);
button=findViewById(R.id.change);
button.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();


        myRef = database.getReference("emedicin/email");
        String s = auth.getCurrentUser().getUid();



        kala = myRef.child(s);
        show(""+kala);
        kala.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {

                    user = dataSnapshot.getValue(userdata.class);
                    show("user "+user.address);
                    email.setText(user.email);
                    username.setText(user.namel);
                    mobile.setText(user.mobilenumber);
                    adress.setText(user.address);

                }catch (Exception e)
                {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
        void show (String s)
        {
            AlertDialog.Builder a = new AlertDialog.Builder(this);
            a.setMessage(s);
            a.show();
        }

    @Override
    public void onClick(View v) {
        String user=username.getText().toString();
        String mob=mobile.getText().toString();
        String add=adress.getText().toString();



        if (v.getId()==R.id.change)
        {
            try {
                kala.child("namel").setValue(user);
                kala.child("address").setValue(add);
                kala.child("mobilenumber").setValue(mob);
            }catch(Exception e)
            {
                show(""+e);
            }



        }

    }
}

