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
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class SeaActivity extends AppCompatActivity {

    int[] image11 = {R.drawable.sea,R.drawable.sea1,R.drawable.sea2,R.drawable.sea3,R.drawable.sea4,
            R.drawable.sea5,R.drawable.sea6,R.drawable.sea7,R.drawable.sea8,R.drawable.sea9,
            R.drawable.sea10,R.drawable.sea11,R.drawable.sea12,R.drawable.sea13,R.drawable.sea14,
            R.drawable.sea15,R.drawable.sea16,R.drawable.sea17,R.drawable.sea18,R.drawable.sea19,
            R.drawable.sea20,R.drawable.sea21,R.drawable.sea22,R.drawable.sea23,R.drawable.sea24,
            R.drawable.sea25,R.drawable.sea26,R.drawable.sea27,R.drawable.sea28,R.drawable.sea29};

    GridView gridView;
    ArrayList<ImageModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sea);

        //ActionBar
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);

        //Grid View
        gridView = (GridView) findViewById(R.id.gridview);
        arrayList = new ArrayList<>();
        for (int i = 0; i < image11.length; i++) {
            ImageModel imagemodel = new ImageModel();
            imagemodel.setimgIds(image11[i]);
            arrayList.add(imagemodel);
        }
        ActorAdapter adpter= new ActorAdapter(getApplicationContext(), arrayList);
        gridView.setAdapter(adpter);


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
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
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



