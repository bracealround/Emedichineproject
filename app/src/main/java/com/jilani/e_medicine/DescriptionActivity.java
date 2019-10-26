package com.jilani.e_medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DescriptionActivity extends AppCompatActivity {
    private Button orderNowButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        orderNowButton = (Button) findViewById(R.id.orderNow_btn);
        orderNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DescriptionActivity.this,OrderSubmissionActivity.class);
                startActivity(intent);
            }
        });
    }
}
