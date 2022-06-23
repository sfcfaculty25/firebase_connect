package com.dawai.firebaseconnect;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Adapterlv extends BaseAdapter {

    ArrayList<User> data;
    Context context;

    public Adapterlv(ArrayList<User> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
     DatabaseReference db = FirebaseDatabase.getInstance("https://databasetest-baab5-default-rtdb.firebaseio.com").getReference("user");
        View root = LayoutInflater.from(context).inflate(R.layout.listview_content,null);

        TextView user = root.findViewById(R.id.uname);
        TextView pass = root.findViewById(R.id.pass);
        Button btn_del = root.findViewById(R.id.btn_delete);
        Button btn_update = root.findViewById(R.id.btn_update);

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                db.child(data.get(position).getUserid()).removeValue();
                Intent intent = new Intent(context,select_data.class);
                context.startActivity(intent);
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,update.class);
                i.putExtra("id",data.get(position).getUserid());
                i.putExtra("user",data.get(position).getUname());
                i.putExtra("pass",data.get(position).getPass());
                context.startActivity(i);
            }
        });

        user.setText(data.get(position).getUname());
        pass.setText(data.get(position).getPass());

        return root;
    }
}
