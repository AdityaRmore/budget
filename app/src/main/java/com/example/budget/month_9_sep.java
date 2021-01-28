package com.example.budget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class month_9_sep extends AppCompatActivity {

    RecyclerView recyc ;
    TextView month_text;

    FirebaseRecyclerOptions<Car> options;
    FirebaseRecyclerAdapter<Car, MyVieHolder> madapter;
    DatabaseReference dataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.month_9_sep);

        recyc=findViewById(R.id.sep_recyc);
        month_text=findViewById(R.id.textviewof_month);

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getApplicationContext());
        recyc.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyc.setHasFixedSize(true);



        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String favuser=user.getUid();
        dataRef= FirebaseDatabase.getInstance().getReference().child("Sep").child(favuser);//also called  CAR

        jan_data();
    }


    private void jan_data() {

        options = new FirebaseRecyclerOptions.Builder<Car>().setQuery(dataRef, Car.class).build();
        madapter = new  FirebaseRecyclerAdapter<Car, MyVieHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyVieHolder holder, final int position, @NonNull final Car model) {

                holder.fuel1.setText(model.getFuel());
                holder.amount1.setText(model.getAmount());
                holder.cng1.setText(model.getCng());
                holder.meter1.setText(model.getMeter());
                holder.date1.setText(model.getDate());

            }
            @NonNull
            @Override
            public MyVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view2, parent, false);
                return new MyVieHolder(v);
            }
        };
        madapter.startListening();
        recyc.setAdapter(madapter);
    }
}