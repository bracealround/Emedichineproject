package com.jilani.e_medicine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private TextView signUpTxt;
    private TextView forgetPassword;
    private Button  logIn;
    private Button  adminLogIn;
    private EditText emailid,passwordid;
    FirebaseAuth FirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseAuth=FirebaseAuth.getInstance();
        emailid=findViewById(R.id.email_login);
        passwordid=findViewById(R.id.password_login);
        signUpTxt = (TextView) findViewById(R.id.signup_text);
        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser=FirebaseAuth.getCurrentUser();
                if(mFirebaseUser!=null)
                {

                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Please Log in",Toast.LENGTH_LONG).show();
                }
            }
        };
        logIn = (Button) findViewById(R.id.user_login_btn);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailid.getText().toString();
                String pwd=passwordid.getText().toString();
                if(email.isEmpty())
                {
                    emailid.setError("Please enter an email id!");
                    emailid.requestFocus();
                }
                else if(pwd.isEmpty())
                {
                    passwordid.setError("Please enter an password!");
                    passwordid.requestFocus();
                }

                else
                {
                    FirebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Intent intentsrc = new Intent(LoginActivity.this, SearchActivity.class);
                                startActivity(intentsrc);
                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this,"Email or password not accurate.",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
                //Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                //startActivity(intent);

            }
        });
        signUpTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
        adminLogIn = (Button) findViewById(R.id.admin_login_btn);
        adminLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,AddmedicineActivity.class);
                startActivity(intent);
            }
        });
        forgetPassword = (TextView) findViewById(R.id.forgot_password_text);
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,PasswordActivity.class);
                startActivity(intent);
            }
        });

    }

    //@Override
    //protected void onStart() {
      // super.onStart();
      //  mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    //}
}
