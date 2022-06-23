package com.dawai.firebaseconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText txtuser,txtpass;
    Button btn_insert,display;

    //connection string
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtuser = findViewById(R.id.txtuser);
        txtpass = findViewById(R.id.txtpass);
        btn_insert = findViewById(R.id.btn_insert);
        display = findViewById(R.id.display);


        btn_insert.setOnClickListener(view -> {
            DatabaseReference db = FirebaseDatabase.getInstance("https://databasetest-baab5-default-rtdb.firebaseio.com").getReference("user");

            String id = System.currentTimeMillis()+"";
            User user = new User(id,txtuser.getText().toString(),txtpass.getText().toString());
            db.child(id).setValue(user);
            Toast.makeText(MainActivity.this, "inserted", Toast.LENGTH_SHORT).show();
        });

        display.setOnClickListener(view -> {
            Intent intent =new Intent(MainActivity.this,select_data.class);
            startActivity(intent);
        });

    }
}