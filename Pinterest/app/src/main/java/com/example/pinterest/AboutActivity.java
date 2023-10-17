package com.example.pinterest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AboutActivity extends AppCompatActivity {

    ListView list;

    String[] maintitle = {"Rana Hamdy", "Samar Samir", "Muhammed Ashraf", "Sama Hesham", "Sohila Elsayed", "Ahmed Hatem"};

    Integer[] imgid = {R.drawable.rana, R.drawable.samar, R.drawable.muhammed, R.drawable.sama, R.drawable.sohila,R.drawable.ahmed};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //List view
        AboutAdapter adapter = new AboutAdapter(this, maintitle, imgid);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        //ActionBar
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);


        //navigation bar
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.nav_setting);
        //noinspection deprecation
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_about:
                        Toast.makeText(getApplicationContext(), "Already at About Us", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_setting:
                        startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }

        });


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