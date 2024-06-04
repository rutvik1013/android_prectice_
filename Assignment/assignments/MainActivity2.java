package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textViewfrag;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewfrag=findViewById(R.id.txtfrag);


        BlankFragment2 blankFragment2=new BlankFragment2();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fram_container,blankFragment2);
        ft.commit();


        Intent i=getIntent();
        String name=i.getStringExtra("key");
        textViewfrag.setText(name);
    }
}