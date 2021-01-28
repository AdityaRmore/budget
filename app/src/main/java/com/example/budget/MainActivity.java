package com.example.budget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {

    private EditText  date , fuel , amount , cng  , meter  ;
    private Button button , date_picker;
    private BottomNavigationView bottomNavigationView;
    private TextView date_pick;
    Button jan , feb,march ,april ,may,june,jully,aug,sep,oct,nov,dec;
    int amount123=0;
    TextView textview_foramount , textview_foramount2  , result_sum;

    DatabaseReference dataRef,jan_dataRef,feb_dataRef,march_dataRef,april_dataRef,may_dataRef,june_dataRef,jully_dataRef,aug_dataRef, sep_dataRef,oct_dataRef,nov_dataRef, dec_dataRef ;
    DatabaseReference amount_dataref , result_dataref;
    Integer a  , b , c ,d , ja;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date=findViewById(R.id.date_of);
        //date_pick=findViewById(R.id.date_of);
        date_picker=findViewById(R.id.date_picker);
        fuel=findViewById(R.id.fuel);
        amount=findViewById(R.id.amount_of_fuel);
        cng=findViewById(R.id.cng_petrol);
        meter=findViewById(R.id.meter_reading);
        button=findViewById(R.id.button1);
        //result=findViewById(R.id.editTextNumber2);
        textview_foramount=findViewById(R.id.textview_foramount);
        textview_foramount2=findViewById(R.id.textview_foramount2);
        //textview_foramount3=findViewById(R.id.textview_foramount3);
        result_sum=findViewById(R.id.result_sum);



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
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.calender:startActivity(new Intent(getApplicationContext(),calender_activity_1.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.all:startActivity(new Intent(getApplicationContext(),All.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;

                }
                return false;
            }
        });


        final Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);




        date_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datepicker = new DatePickerFragement();
                datepicker.show(getSupportFragmentManager(), "Date picker");
                //date.setText("Hello ");
            }
        });

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //a=Integer.parseInt(amount.getText().toString());
                //b=Integer.parseInt(meter.getText().toString());
                //c=a/b;

                //result.setText(Float.toString(c));
                //Toast.makeText(MainActivity.this,"Updated",Toast.LENGTH_LONG).show();
                uploadImage();
                //     if (amount!=null && divide!= null){
                //
                //                    uploadImage();
                //                }else {
                //                    Toast.makeText(MainActivity.this,"Enter amount", Toast.LENGTH_LONG).show();
                //
                //                }

            }
        });*/
        jan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jan_upload();
            }
        });
        feb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feb_upload();

            }
        });
        march.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                march_upload();
            }
        });
        april.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                april_upload();
            }
        });
        may.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                may_upload();
            }
        });
        june.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                june_upload();
            }
        });
        jully.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jully_upload();
            }
        });
        aug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aug_upload();
            }
        });
        sep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep_upload();
            }
        });
        oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oct_upload();
            }
        });
        nov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nov_upload();
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dec_upload();
            }
        });


        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();


        //    DatabaseReference dataRef,jan_dataRef,feb_dataRef,march_dataRef,april_dataRef,may_dataRef,june_dataRef,
        dataRef= FirebaseDatabase.getInstance().getReference().child("All").child(favuser);jan_dataRef= FirebaseDatabase.getInstance().getReference().child("Jan").child(favuser);
        feb_dataRef= FirebaseDatabase.getInstance().getReference().child("Feb").child(favuser);
        march_dataRef= FirebaseDatabase.getInstance().getReference().child("March").child(favuser);
        april_dataRef= FirebaseDatabase.getInstance().getReference().child("April").child(favuser);//also called  CAR
        may_dataRef= FirebaseDatabase.getInstance().getReference().child("May").child(favuser);//also called  CAR
        june_dataRef= FirebaseDatabase.getInstance().getReference().child("June").child(favuser);//also called  CAR
        jully_dataRef= FirebaseDatabase.getInstance().getReference().child("Jully").child(favuser);//also called  CAR
        aug_dataRef= FirebaseDatabase.getInstance().getReference().child("August").child(favuser);//also called  CAR
        sep_dataRef= FirebaseDatabase.getInstance().getReference().child("Sep").child(favuser);//also called  CAR
        oct_dataRef= FirebaseDatabase.getInstance().getReference().child("oct").child(favuser);//also called  CAR
        nov_dataRef= FirebaseDatabase.getInstance().getReference().child("Nov").child(favuser);//also called  CAR
        dec_dataRef= FirebaseDatabase.getInstance().getReference().child("December").child(favuser);//also called  CAR


        final String check_amount = amount.getText().toString();
        amount_dataref=FirebaseDatabase.getInstance().getReference().child("Amount").child(favuser);
        amount_dataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //String amount_new= snapshot.child("amount").getValue().toString();
                //String amount_new2= snapshot.child("meter_reading").getValue().toString();

                //textview_foramount.setText(amount_new);
                if (snapshot.child("Jan_Amount").exists()){

                    //  3  String amount_new= snapshot.child("Jan_Amount").child("amount").getValue().toString();
                    //  3  textview_foramount.setText(amount_new);
                    //  3  a=Integer.parseInt(textview_foramount.getText().toString());

                    //String amount_new2= snapshot.child("meter_reading").getValue().toString();
                    //textview_foramount2.setText(amount_new2);

                    //b=Integer.parseInt(textview_foramount2.getText().toString());
                    //d=Integer.parseInt(amount.getText().toString());
                    //c=a+b;

                    //result_sum.setText(Integer.toString(c));

                    Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();



                    /*if (amount.getText().toString().trim().length()> 0){

                        String amount_new= snapshot.child("amount").getValue().toString();
                        String amount_new2= snapshot.child("meter_reading").getValue().toString();
                        textview_foramount.setText(amount_new);
                        textview_foramount2.setText(amount_new2);

                        a=Integer.parseInt(textview_foramount.getText().toString());
                        b=Integer.parseInt(textview_foramount2.getText().toString());
                        //d=Integer.parseInt(amount.getText().toString());
                        c=a+b;

                        //result_sum.setText(Integer.toString(c));

                        Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(MainActivity.this, "Data failed", Toast.LENGTH_SHORT).show();
                    }*/



                }else{

                    Toast.makeText(MainActivity.this, "Data failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void dec_upload() {

        final String key3=dec_dataRef.push().getKey();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        String favusername = user.getEmail();

        String fuel1 = fuel.getText().toString();//new
        String amount1 = amount.getText().toString();//new
        String cng1 = cng.getText().toString();//new
        String meter1= meter.getText().toString();
        String date1= date.getText().toString();


        HashMap hashMap=new HashMap();
        hashMap.put("user", favusername );
        hashMap.put("fuel", fuel1 );
        hashMap.put("amount",amount1 );
        hashMap.put("cng", cng1 );
        hashMap.put("meter", meter1);//b
        hashMap.put("date", date1);

        dec_dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(getApplicationContext(),All.class));
            }
        });
        dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void oct_upload() {

        final String key3=oct_dataRef.push().getKey();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        String favusername = user.getEmail();

        String fuel1 = fuel.getText().toString();//new
        String amount1 = amount.getText().toString();//new
        String cng1 = cng.getText().toString();//new
        String meter1= meter.getText().toString();
        String date1= date.getText().toString();


        HashMap hashMap=new HashMap();
        hashMap.put("user", favusername );
        hashMap.put("fuel", fuel1 );
        hashMap.put("amount",amount1 );
        hashMap.put("cng", cng1 );
        hashMap.put("meter", meter1);//b
        hashMap.put("date", date1);

        oct_dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(getApplicationContext(),All.class));
            }
        });
        dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void nov_upload() {

        final String key3=nov_dataRef.push().getKey();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        String favusername = user.getEmail();

        String fuel1 = fuel.getText().toString();//new
        String amount1 = amount.getText().toString();//new
        String cng1 = cng.getText().toString();//new
        String meter1= meter.getText().toString();
        String date1= date.getText().toString();


        HashMap hashMap=new HashMap();
        hashMap.put("user", favusername );
        hashMap.put("fuel", fuel1 );
        hashMap.put("amount",amount1 );
        hashMap.put("cng", cng1 );
        hashMap.put("meter", meter1);//b
        hashMap.put("date", date1);

        nov_dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(getApplicationContext(),All.class));
            }
        });
        dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void aug_upload() {

        final String key3=aug_dataRef.push().getKey();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        String favusername = user.getEmail();

        String fuel1 = fuel.getText().toString();//new
        String amount1 = amount.getText().toString();//new
        String cng1 = cng.getText().toString();//new
        String meter1= meter.getText().toString();
        String date1= date.getText().toString();


        HashMap hashMap=new HashMap();
        hashMap.put("user", favusername );
        hashMap.put("fuel", fuel1 );
        hashMap.put("amount",amount1 );
        hashMap.put("cng", cng1 );
        hashMap.put("meter", meter1);//b
        hashMap.put("date", date1);

        aug_dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(getApplicationContext(),All.class));
            }
        });
        dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sep_upload() {

        final String key3=sep_dataRef.push().getKey();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        String favusername = user.getEmail();

        String fuel1 = fuel.getText().toString();//new
        String amount1 = amount.getText().toString();//new
        String cng1 = cng.getText().toString();//new
        String meter1= meter.getText().toString();
        String date1= date.getText().toString();


        HashMap hashMap=new HashMap();
        hashMap.put("user", favusername );
        hashMap.put("fuel", fuel1 );
        hashMap.put("amount",amount1 );
        hashMap.put("cng", cng1 );
        hashMap.put("meter", meter1);//b
        hashMap.put("date", date1);

        sep_dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(getApplicationContext(),All.class));
            }
        });
        dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void jully_upload() {

        final String key3=jully_dataRef.push().getKey();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        String favusername = user.getEmail();

        String fuel1 = fuel.getText().toString();//new
        String amount1 = amount.getText().toString();//new
        String cng1 = cng.getText().toString();//new
        String meter1= meter.getText().toString();
        String date1= date.getText().toString();


        HashMap hashMap=new HashMap();
        hashMap.put("user", favusername );
        hashMap.put("fuel", fuel1 );
        hashMap.put("amount",amount1 );
        hashMap.put("cng", cng1 );
        hashMap.put("meter", meter1);//b
        hashMap.put("date", date1);

        jully_dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(getApplicationContext(),All.class));
            }
        });
        dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void june_upload() {

        final String key3=june_dataRef.push().getKey();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        String favusername = user.getEmail();

        String fuel1 = fuel.getText().toString();//new
        String amount1 = amount.getText().toString();//new
        String cng1 = cng.getText().toString();//new
        String meter1= meter.getText().toString();
        String date1= date.getText().toString();


        HashMap hashMap=new HashMap();
        hashMap.put("user", favusername );
        hashMap.put("fuel", fuel1 );
        hashMap.put("amount",amount1 );
        hashMap.put("cng", cng1 );
        hashMap.put("meter", meter1);//b
        hashMap.put("date", date1);

        june_dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(getApplicationContext(),All.class));
            }
        });
        dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void may_upload() {

        final String key3=may_dataRef.push().getKey();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        String favusername = user.getEmail();

        String fuel1 = fuel.getText().toString();//new
        String amount1 = amount.getText().toString();//new
        String cng1 = cng.getText().toString();//new
        String meter1= meter.getText().toString();
        String date1= date.getText().toString();


        HashMap hashMap=new HashMap();
        hashMap.put("user", favusername );
        hashMap.put("fuel", fuel1 );
        hashMap.put("amount",amount1 );
        hashMap.put("cng", cng1 );
        hashMap.put("meter", meter1);//b
        hashMap.put("date", date1);

        may_dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(getApplicationContext(),All.class));
            }
        });
        dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void april_upload() {

        final String key3=april_dataRef.push().getKey();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        String favusername = user.getEmail();

        String fuel1 = fuel.getText().toString();//new
        String amount1 = amount.getText().toString();//new
        String cng1 = cng.getText().toString();//new
        String meter1= meter.getText().toString();
        String date1= date.getText().toString();

        HashMap hashMap=new HashMap();
        hashMap.put("user", favusername );
        hashMap.put("fuel", fuel1 );
        hashMap.put("amount",amount1 );
        hashMap.put("cng", cng1 );
        hashMap.put("meter", meter1);//b
        hashMap.put("date", date1);

        april_dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(getApplicationContext(),All.class));
            }
        });
        dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void march_upload() {

        final String key3=march_dataRef.push().getKey();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        String favusername = user.getEmail();

        String fuel1 = fuel.getText().toString();//new
        String amount1 = amount.getText().toString();//new
        String cng1 = cng.getText().toString();//new
        String meter1= meter.getText().toString();
        String date1= date.getText().toString();


        HashMap hashMap=new HashMap();
        hashMap.put("user", favusername );
        hashMap.put("fuel", fuel1 );
        hashMap.put("amount",amount1 );
        hashMap.put("cng", cng1 );
        hashMap.put("meter", meter1);//b
        hashMap.put("date", date1);

        march_dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(getApplicationContext(),calender_activity_1.class));
            }
        });
        dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void feb_upload() {

        final String key3=feb_dataRef.push().getKey();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        String favusername = user.getEmail();

        String fuel1 = fuel.getText().toString();//new
        String amount1 = amount.getText().toString();//new
        String cng1 = cng.getText().toString();//new
        String meter1= meter.getText().toString();
        String date1= date.getText().toString();


        HashMap hashMap=new HashMap();
        hashMap.put("user", favusername );
        hashMap.put("fuel", fuel1 );
        hashMap.put("amount",amount1 );
        hashMap.put("cng", cng1 );
        hashMap.put("meter", meter1);//b
        hashMap.put("date", date1);

        feb_dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(getApplicationContext(),calender_activity_1.class));
            }
        });
        dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void jan_upload() {

        final String key3=jan_dataRef.push().getKey();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        String favusername = user.getEmail();

        String fuel1 = fuel.getText().toString();//new
        final String amount1 = amount.getText().toString();//new
        String cng1 = cng.getText().toString();//new
        String meter1= meter.getText().toString();
        String date1= date.getText().toString();


        //                    a=Integer.parseInt(textview_foramount.getText().toString());


        HashMap hashMap=new HashMap();
        hashMap.put("user", favusername );
        hashMap.put("fuel", fuel1 );
        hashMap.put("amount",amount1 );
        hashMap.put("cng", cng1 );
        hashMap.put("meter", meter1);//b
        hashMap.put("date", date1);


        //hashMap1.put("meter_reading", meter1);
        //hashMap1.put("meter_reading", result_sum);

        //hashMap1.put("amm",amount123);
        amount_dataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child("Jan_Amount").exists()){

                    String amount_new= snapshot.child("Jan_Amount").child(key3).child("amount").getValue().toString();
                    textview_foramount.setText(amount_new);
                    a=Integer.parseInt(textview_foramount.getText().toString());
                    ja=Integer.parseInt(amount1);
                    d=ja+a;
                    result_sum.setText(Integer.toString(d));

                }else {
                    Toast.makeText(MainActivity.this, "Data Failed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        String amount_final = result_sum.getText().toString();
        HashMap hashMap1=new HashMap();
        hashMap1.put("amount",amount1);
        //hashMap1.put("amount1", amount_final);

        amount_dataref.child("Jan_Amount").setValue(hashMap1).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
            }
        });

        jan_dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(getApplicationContext(),All.class));
            }
        });
        dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
            }
        });



    }

    /*private void uploadImage() {

        final String key3=dataRef.push().getKey();
        // final String url= storageRef3.child(key3+".jpg").getDownloadUrl().toString();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        String favusername = user.getEmail();

        String fuel1 = fuel.getText().toString();//new
        String amount1 = amount.getText().toString();//new
        String cng1 = cng.getText().toString();//new
        String meter1= meter.getText().toString();
        //String result1= result.getText().toString();
        String date1= date.getText().toString();
        //String date_123= date_pick.getText().toString();


        HashMap hashMap=new HashMap();
        hashMap.put("user", favusername );
        hashMap.put("fuel", fuel1 );
        hashMap.put("amount",amount1 );
        hashMap.put("cng", cng1 );
        hashMap.put("meter", meter1);//b
        //hashMap.put("result", result1);
        hashMap.put("date", date1);

        //     Intent intent=new Intent(HomeActivity3.this,people_images.class);
        //   intent.putExtra("keyofposition",key3);

        dataRef.child(key3).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                 Toast.makeText(MainActivity.this, "Data succesfull", Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(getApplicationContext(),All.class));
            }
        });

    }*/

    @Override
    public void onBackPressed() {
        finishAffinity();
    }



    // date picker fragment
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH , month);
        c.set(Calendar.DAY_OF_MONTH , dayofmonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        date.setText(currentDateString);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String text = parent.getItemAtPosition(i).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        cng.setText(text);

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}










