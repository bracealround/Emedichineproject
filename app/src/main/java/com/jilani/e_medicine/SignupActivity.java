package com.jilani.e_medicine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity  implements View.OnClickListener {
    private Button signUpButton;
    private TextView signInButton;
    private EditText emailid,passwordid,nameid,addressid,mobileid,confirm;
    private  FirebaseAuth mAuth;
    userdata user;
   private FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth=FirebaseAuth.getInstance();
        emailid=findViewById(R.id.email_reg);
        nameid=findViewById(R.id.name_reg);
        addressid=findViewById(R.id.address_reg);
        passwordid=findViewById(R.id.password_reg);
        mobileid=findViewById(R.id.mobile_reg);
        signUpButton = (Button) findViewById(R.id.reg_btn);
        signInButton = (TextView) findViewById(R.id.signin_text);
        signUpButton.setOnClickListener(this);

        try {
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("emedicin");


        }catch (Exception e){

            show(""+e);
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.reg_btn)
        {
         final   String email = emailid.getText().toString().trim();
           final String pwd = passwordid.getText().toString().trim();
           final String name = nameid.getText().toString();
          final  String address = addressid.getText().toString();
          final  String mobile = mobileid.getText().toString();
           final String uid;





            if (email.isEmpty()) {
                emailid.setError("Please enter an email id!");
                emailid.requestFocus();
            } else if (pwd.isEmpty()) {
                passwordid.setError("Please enter a password at least 6 character long");
                passwordid.requestFocus();
            } else if (name.isEmpty()) {
                nameid.setError("Please provide a name!");
                nameid.requestFocus();
            } else if (address.isEmpty()) {
                addressid.setError("Please provide an address!");
                addressid.requestFocus();
            } else if (mobile.isEmpty()) {
                mobileid.setError("Please provide a mobile number!");
                mobileid.requestFocus();
            } else {
                show(""+email+""+pwd);
                mAuth.createUserWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    String e;
                                    Toast.makeText(SignupActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                                try {
                                    e = mAuth.getCurrentUser().getUid().trim();
                                    show(""+e);
                                    user = new userdata(e,email,name,address,mobile,pwd);

                                    myRef.child("email").child(e).setValue(user);


                                }
                                catch (Exception g)
                                {
                                    show(""+g);

                                }
                                   Intent i=new Intent (getApplicationContext(),LoginActivity.class);
                                   startActivity(i);
                                    //Sign in success, update UI with the signed-in user's information


                                } else {
                                    // If sign in fails, display a message to the user.
                                    show("Registration faild!");
                                    Toast.makeText(getApplicationContext(),"Try Again",Toast.LENGTH_LONG);

                                }

                                // ...
                            }
                        });
            }
        }

    }
    void show(String re)
    {
        AlertDialog.Builder a=new AlertDialog.Builder(this);
        a.setMessage(re);
        a.show();
    }
}
