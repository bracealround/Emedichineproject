package com.jilani.e_medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderConfirmation extends AppCompatActivity {
    private Button gotoSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);
        gotoSearch = (Button) findViewById(R.id.go_to_search);
        gotoSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderConfirmation.this,SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}

