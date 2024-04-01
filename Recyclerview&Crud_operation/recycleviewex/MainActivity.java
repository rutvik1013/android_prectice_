package com.example.recycleviewex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Model>list;
    Myadapter myadapter;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        floatingActionButton=findViewById(R.id.f1);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.update_design);

                EditText edt_m_name=dialog.findViewById(R.id.edt_edit_name);
                EditText edt_m_price=dialog.findViewById(R.id.edt_edit_price);
                Button btnaction=dialog.findViewById(R.id.btnadd);

                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String name=edt_m_name.getText().toString();
                        String price=edt_m_price.getText().toString();

                        list.add(new Model(R.drawable.iphone14,name,price));
                        myadapter.notifyItemInserted(list.size()-1);
                        recyclerView.scrollToPosition(list.size()-1);

                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ArrayList<Model>list=new ArrayList<>();

        list.add(new Model(R.drawable.samsung_s24_ultra,"Samsung Galaxy s24 Ultra","Price: 1,40,000"));
        list.add(new Model(R.drawable.samsung_s24,"Samsung Galaxy s24","Price: 80,000"));
        list.add(new Model(R.drawable.samsung_s23_ultra,"Samsung Galaxy s23 Ultra","Price: 1,32,000"));
        list.add(new Model(R.drawable.samsung_s23,"Samsung Galaxy s23","Price: 70,000"));
        list.add(new Model(R.drawable.samsung_galaxy_a55,"Samsung Galaxy a55","Price: 39,999"));
        list.add(new Model(R.drawable.samsung_a15,"Samsung Galaxy a15","Price: 19,9999"));
        list.add(new Model(R.drawable.iphone_14_pro_max,"Iphone 15 pro Max","Price: 1,48,000"));
        list.add(new Model(R.drawable.iphone15_pro,"Iphone 15 Pro","Price: 1,15,000"));
        list.add(new Model(R.drawable.iphone_15,"Iphone 15","Price: 74,999"));
        list.add(new Model(R.drawable.iphone_14_pro_max,"Iphone 14 Pro Max","Price: 1,30,000"));
        list.add(new Model(R.drawable.iphone_14_pro,"Iphone 14 Pro","Price: 1,20,000"));
        list.add(new Model(R.drawable.iphone14,"Iphone 14","Price: 62,000"));
        list.add(new Model(R.drawable.redmi_13_pro,"Redmi 13 Pro","Price: 23,999"));
        list.add(new Model(R.drawable.redmi_note_13,"Redmi Note 13","Price: 15,9999"));

        Myadapter myadapter=new Myadapter(this,list);
        recyclerView.setAdapter(myadapter);

    }
}