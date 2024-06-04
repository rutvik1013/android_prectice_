package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

public class Radio_color extends AppCompatActivity {

    RadioButton redradio;
    RadioButton yellowradio;
    RadioButton greenradio;
    RadioButton blueradio;
    RelativeLayout relativeLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_color);

        redradio=findViewById(R.id.red_radio);
        yellowradio=findViewById(R.id.yellow_radio);
        greenradio=findViewById(R.id.green_radio);
        blueradio=findViewById(R.id.blue_radio);
        relativeLayout=findViewById(R.id.relativelayout);


        redradio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                relativeLayout.setBackgroundColor(Color.RED);
            }
        });
        yellowradio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                relativeLayout.setBackgroundColor(Color.YELLOW);
            }
        });
        greenradio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                relativeLayout.setBackgroundColor(Color.GREEN);
            }
        });
        blueradio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                relativeLayout.setBackgroundColor(Color.BLUE);
            }
        });


    }
}