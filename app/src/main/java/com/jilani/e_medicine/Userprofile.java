package com.jilani.e_medicine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class Userprofile extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef, kala;
    FirebaseAuth auth;
    String m;
    userdata user;
    EditText username, mobile, adress;
    TextView email;
    Query q;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_userprofile);
        username = findViewById(R.id.username);
        mobile = findViewById(R.id.mobile);
        adress = findViewById(R.id.address);
        email = findViewById(R.id.email);

        auth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();

        myRef = database.getReference("emedicine2-c2fa5 /emedicin /email ");
        String s = auth.getCurrentUser().getUid();
        show(""+s);


        kala = myRef.child(s);
        show(""+kala);
        kala.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    user = dataSnapshot.getValue(userdata.class);
                    show("" + user.getAddress());
                }catch (Exception e)
                {
                    show(""+e);
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
    }

