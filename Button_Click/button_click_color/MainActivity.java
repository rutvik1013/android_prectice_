package com.example.button_click_color;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnyellow;
    Button btngreen;
    Button btnred;
    Button btnwhite;
    Button btnblue;
    ConstraintLayout constraintLayout;
    ConstraintLayout constraintLayout2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnyellow=findViewById(R.id.buttonyellow);
        btngreen=findViewById(R.id.buttongreen);
        btnred=findViewById(R.id.buttonred);
        btnwhite=findViewById(R.id.buttonwhite);
        btnblue=findViewById(R.id.buttonblue);
        constraintLayout=findViewById(R.id.constraintlayout);
        constraintLayout2=findViewById(R.id.constraintlayout2);



        btnyellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                constraintLayout2.setBackgroundResource(R.color.Yellow);

            }
        });
        btngreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                constraintLayout2.setBackgroundResource(R.color.green);

            }
        });
        btnred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                constraintLayout2.setBackgroundResource(R.color.Red);
            }
        });
        btnwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                constraintLayout2.setBackgroundResource(R.color.black);
            }
        });
        btnblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                constraintLayout2.setBackgroundResource(R.color.Blue);
            }
        });






    }
}