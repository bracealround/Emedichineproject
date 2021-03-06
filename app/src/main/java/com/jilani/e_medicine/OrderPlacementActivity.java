package com.jilani.e_medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderPlacementActivity extends AppCompatActivity {
    private Button orderplacementButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placement);
        orderplacementButton = (Button) findViewById(R.id.order_placement);
        orderplacementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderPlacementActivity.this,OrderConfirmation.class);
                startActivity(intent);
            }
        });
    }
}
