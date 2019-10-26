package com.jilani.e_medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountcreatedActivity extends AppCompatActivity {
    private Button logInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountcreated);
        logInButton = (Button) findViewById(R.id.LogIn_btn);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountcreatedActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
