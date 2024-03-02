package com.example.button_color;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button buttonred;
    Button buttonyellow;
    Button buttonwhite;
    Button buttongreen;
    Button buttonblue;
    RelativeLayout relativeLayout;
    RelativeLayout relativeLayout2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonred=findViewById(R.id.btnred);
        buttonyellow=findViewById(R.id.btnyellow);
        buttonwhite=findViewById(R.id.btnwhite);
        buttongreen=findViewById(R.id.btngreen);
        buttonblue=findViewById(R.id.btnblue);
        relativeLayout=findViewById(R.id.relativelayout);
        relativeLayout2=findViewById(R.id.relativelayout2);

        buttonred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //relativeLayout.setBackgroundResource(R.color.Red);
                    relativeLayout2.setBackgroundResource(R.color.Red);
            }
        });

        buttonyellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //relativeLayout.setBackgroundResource(R.color.Yellow);
                relativeLayout2.setBackgroundResource(R.color.Yellow);
            }
        });
        buttonwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //relativeLayout.setBackgroundResource(R.color.white);
                relativeLayout2.setBackgroundResource(R.color.black);
            }
        });
        buttongreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //relativeLayout.setBackgroundResource(R.color.Green);
                relativeLayout2.setBackgroundResource(R.color.Green);
            }
        });
        buttonblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //relativeLayout.setBackgroundResource(R.color.Blue);
                relativeLayout2.setBackgroundResource(R.color.Blue);
            }
        });
    }
}