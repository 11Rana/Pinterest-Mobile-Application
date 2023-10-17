package com.example.pinterest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

        EditText t1,t2,t3,t4,t5;
        UserDatabase obj;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);

            //ActionBar
            ActionBar actionBar;
            actionBar = getSupportActionBar();
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
            assert actionBar != null;
            actionBar.setBackgroundDrawable(colorDrawable);

            //Sign up
            obj=new UserDatabase(this);
            t1=(EditText)findViewById(R.id.username);
            t2=(EditText)findViewById(R.id.email);
            t3=(EditText)findViewById(R.id.phonenum);
            t4=(EditText)findViewById(R.id.pass1);
            findViewById(R.id.button2).setOnClickListener((v -> {
                t4=(EditText)findViewById(R.id.pass1);
                t5=(EditText)findViewById(R.id.pass4);
                if(t4.getText().toString().equals(t5.getText().toString())) {
                    String o=obj.instertData(t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),t4.getText().toString());
                    Toast.makeText(SignupActivity.this,o,Toast.LENGTH_SHORT).show();
                    Intent ii = new Intent(SignupActivity.this, SigninActivity.class);
                    startActivity(ii);
                }
                else {
                    Toast.makeText(SignupActivity.this,"Password didn't Match Try Again",Toast.LENGTH_SHORT).show();
                }

            }));
        }
    }