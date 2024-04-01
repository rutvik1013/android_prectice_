package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnfragment,btnfragmen2,btnfragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnfragment=findViewById(R.id.btnfragment);
        btnfragmen2=findViewById(R.id.btnfragment2);
        btnfragment3=findViewById(R.id.btnfragment3);

        btnfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loadfragment(new BlankFragment());
            }
        });
        btnfragmen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadfragment(new BlankFragment2());
            }
        });
        btnfragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadfragment(new BlankFragment3());
            }
        });

    }
    public void loadfragment(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fragmentcontainer, fragment,null);
        ft.commit();
    }
}