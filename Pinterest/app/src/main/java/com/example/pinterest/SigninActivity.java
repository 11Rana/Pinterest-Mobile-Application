package com.example.pinterest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SigninActivity extends AppCompatActivity {

    UserDatabase obj;
    EditText t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        //ActionBar
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);

        //Sign in
        t1=(EditText)findViewById(R.id.email2);
        t2=(EditText)findViewById(R.id.pass2);
        obj=new UserDatabase(this);
        findViewById(R.id.button).setOnClickListener((v -> {
            ArrayList<User> arrayList=obj.getData();
            boolean check=false;
            int index;
            for (int i=0;i<arrayList.size();i++){
                if (arrayList.get(i).getEmail().equals(t1.getText().toString())&&arrayList.get(i).getPassword().equals(t2.getText().toString())){
                    check=true;
                    index=i;
                    break;
                }
            }
            if (check) {
                Toast.makeText(SigninActivity.this,"Choose your Category",Toast.LENGTH_SHORT).show();
                Intent i3=new Intent(SigninActivity.this,HomeActivity.class);
                startActivity(i3);
            }
            else {
                Toast.makeText(SigninActivity.this,"Wrong Data Try Again",Toast.LENGTH_SHORT).show();
            }
        }));
    }
}