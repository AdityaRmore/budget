package com.example.budget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class calender_activity_1 extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    Button jan , feb,march ,april ,may,june,jully,aug,sep,oct,nov,dec;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_1);

        jan=findViewById(R.id.jan_button);
        feb=findViewById(R.id.feb_button);
        march=findViewById(R.id.march_button);
        april=findViewById(R.id.april_button);
        may=findViewById(R.id.may_button);
        june=findViewById(R.id.june_button);
        jully=findViewById(R.id.jully_button);
        aug=findViewById(R.id.aug_button);
        sep=findViewById(R.id.sep_button);
        oct=findViewById(R.id.oct_button);
        nov=findViewById(R.id.nov_button);
        dec=findViewById(R.id.dec_button);



        bottomNavigationView=findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setSelectedItemId(R.id.all);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.calender:
                        return true;
                    case R.id.home:startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.all:startActivity(new Intent(getApplicationContext(),All.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        jan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),row1.class));

            }
        });

        feb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),month_2_feb.class));

            }
        });

        march.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),month_3_march.class));

            }
        });

        april.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),month_4_april.class));

            }
        });

        may.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),month_5_may.class));

            }
        });

        june.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),month_6_june.class));

            }
        });

        jully.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),month_7_jully.class));

            }
        });

        aug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),month_8_aug.class));

            }
        });

        sep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),month_9_sep.class));

            }
        });

        oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),month_10_oct.class));

            }
        });

        nov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),month_11_nov.class));

            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),month_12_dec.class));

            }
        });



    }
}