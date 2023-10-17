package com.example.pinterest;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewDataActivity extends AppCompatActivity {
    TextView t1, t2, t3,t4;
    String s1, s2, s3,s4;
    UserDatabase obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        //ActionBar
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);

        //View information
        t1=(TextView)findViewById(R.id.uname);
        t2=(TextView)findViewById(R.id.emil);
        t3=(TextView)findViewById(R.id.phn);
        t4=(TextView)findViewById(R.id.pssw);
        obj=new UserDatabase(this);
        ArrayList<User> arrayList=obj.getData();
        for (int i=0;i<arrayList.size();i++){
            s1=arrayList.get(i).getUsername();
            s2=arrayList.get(i).getEmail();
            s3=arrayList.get(i).getPhnum();
            s4=arrayList.get(i).getPassword();
        }
        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);
    }

    //toolbar
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.help){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://help.pinterest.com/en"));
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Opening in browser", Toast.LENGTH_SHORT).show();

        }
        else if (id == R.id.terms){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://policy.pinterest.com/en/privacy-policy"));
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Opening in browser", Toast.LENGTH_SHORT).show();

        }

        return true;

    }
}