package com.dawai.firebaseconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class update extends AppCompatActivity {

    EditText u_name,u_pass;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        u_name = findViewById(R.id.u_user);
        u_pass = findViewById(R.id.u_pass);
        btn_save=findViewById(R.id.btn_save);
        Intent data = getIntent();
        u_name.setText(data.getStringExtra("user"));
        u_pass.setText(data.getStringExtra("pass"));
        String id = data.getStringExtra("id");

        btn_save.setOnClickListener(view->{
            DatabaseReference db = FirebaseDatabase.getInstance("https://databasetest-baab5-default-rtdb.firebaseio.com").getReference("user");

            User u1 = new User(id,u_name.getText().toString(),u_pass.getText().toString());
            db.child(id).setValue(u1);

            Intent back = new Intent(update.this,select_data.class);
            startActivity(back);

        });


    }
}