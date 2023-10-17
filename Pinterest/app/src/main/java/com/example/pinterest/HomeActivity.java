package com.example.pinterest;

import static com.example.pinterest.R.id.actors;
import static com.example.pinterest.R.id.anemi;
import static com.example.pinterest.R.id.animals;
import static com.example.pinterest.R.id.books;
import static com.example.pinterest.R.id.decore;
import static com.example.pinterest.R.id.disney;
import static com.example.pinterest.R.id.flower;
import static com.example.pinterest.R.id.food;
import static com.example.pinterest.R.id.mix;
import static com.example.pinterest.R.id.sea;
import static com.example.pinterest.R.id.space;
import static com.example.pinterest.R.id.wallpaper;

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
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //ActionBar
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);


        //Buttons
        Button mixbtn = (Button) findViewById(mix);
        mixbtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, MixtureActivity.class);
            startActivity(intent);
        });

        Button animalbtn = (Button) findViewById(animals);
        animalbtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, AnimalActivity.class);
            startActivity(intent);
        });

        Button actorbtn = (Button) findViewById(actors);
        actorbtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, ActorsActivity.class);
            startActivity(intent);
        });

        Button decorebtn = (Button) findViewById(decore);
        decorebtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, DecoreActivity.class);
            startActivity(intent);
        });

        Button anemibtn = (Button) findViewById(anemi);
        anemibtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, AnemiActivity.class);
            startActivity(intent);
        });

        Button spacebtn = (Button) findViewById(space);
        spacebtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, SpaceActivity.class);
            startActivity(intent);
        });

        Button bookbtn = (Button) findViewById(books);
        bookbtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, BookActivity.class);
            startActivity(intent);
        });

        Button foodbtn = (Button) findViewById(food);
        foodbtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, FoodActivity.class);
            startActivity(intent);
        });

        Button wallpaperbtn = (Button) findViewById(wallpaper);
        wallpaperbtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, WallPaperActivity.class);
            startActivity(intent);
        });

        Button flowerbtn = (Button) findViewById(flower);
        flowerbtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, FlowerActivity.class);
            startActivity(intent);
        });

        Button disneybtn = (Button) findViewById(disney);
        disneybtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, DisneyActivity.class);
            startActivity(intent);
        });

        Button seabtn = (Button) findViewById(sea);
        seabtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, SeaActivity.class);
            startActivity(intent);
        });



        //navigation bar
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.nav_home);
        //noinspection deprecation
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Toast.makeText(getApplicationContext(), "Already at Home", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_about:
                        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_setting:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }


                return false;
            }
        });

    }

    //Toolbar
    @Override
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