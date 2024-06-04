package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Textsize extends AppCompatActivity {

    TextView txtname;
    AppCompatButton btnincrease;
    AppCompatButton btndecrease;
    float fontsize=20f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textsize);


        txtname=findViewById(R.id.txtname);
        btnincrease=findViewById(R.id.btnincrease);
        btndecrease=findViewById(R.id.btndecrease);


        btnincrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fontsize+=2f;
                txtname.setTextSize(fontsize);
            }
        });
        btndecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fontsize-=2f;
                txtname.setTextSize(fontsize);
            }
        });


    }
}