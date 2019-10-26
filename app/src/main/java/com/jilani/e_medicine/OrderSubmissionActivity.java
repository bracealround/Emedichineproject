package com.jilani.e_medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderSubmissionActivity extends AppCompatActivity {

    private Button orderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_submission);
        orderButton = (Button) findViewById(R.id.order_btn);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderSubmissionActivity.this,OrderPlacementActivity.class);
                startActivity(intent);
            }
        });
    }
}
