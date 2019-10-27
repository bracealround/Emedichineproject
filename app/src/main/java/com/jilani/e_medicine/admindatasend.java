package com.jilani.e_medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class admindatasend extends AppCompatActivity implements View.OnClickListener {
EditText name,availability,description;
    FirebaseDatabase base ;
    DatabaseReference Ref,hala ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindatasend);
        name=findViewById(R.id.name);
        availability=findViewById(R.id.availability);
        description=findViewById(R.id.description);
        base = FirebaseDatabase.getInstance();
        Ref = base.getReference("emedicin");
        hala=Ref.child("medicinconner");


    }

    @Override
    public void onClick(View v) {
        String nam,Avaiabilit,Descriptio;
        nam=name.getText().toString();
        Avaiabilit=availability.getText().toString();
        Descriptio=description.getText().toString();
        dataforpermechy a=new dataforpermechy(nam,Avaiabilit,Descriptio);
        hala.setValue(a);


    }
}
