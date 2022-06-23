package com.dawai.firebaseconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class select_data extends AppCompatActivity {

    ListView lv;

    DatabaseReference db;

    ArrayList<User> data;

    Button btn_back,btn_search;

    EditText txt_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_data);
    btn_back = findViewById(R.id.btn_back);
    btn_search = findViewById(R.id.btn_search);
    txt_search = findViewById(R.id.txtsearch);

    btn_back.setOnClickListener(view -> {
        Intent intent =new Intent(select_data.this,MainActivity.class);
        startActivity(intent);
    });

    btn_search.setOnClickListener(view -> {

        search();
    });

        lv = findViewById(R.id.lv);

        db = FirebaseDatabase.getInstance("https://databasetest-baab5-default-rtdb.firebaseio.com").getReference("user");
fetch();
    }



    public void fetch()
    {

        data = new ArrayList<>();

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot firebase: snapshot.getChildren())
                {
                    User u1 = firebase.getValue(User.class);
                    data.add(u1);
                }
                Adapterlv adapterlv = new Adapterlv(data,select_data.this);
                lv.setAdapter(adapterlv);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }    public void search()
    {

        data = new ArrayList<>();

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot firebase: snapshot.getChildren())
                {
                    User u1 = firebase.getValue(User.class);
                 if(u1.uname.contains(txt_search.getText().toString()))
                 {
                     data.add(u1);
                 }

                }
                Adapterlv adapterlv = new Adapterlv(data,select_data.this);
                lv.setAdapter(adapterlv);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }



}