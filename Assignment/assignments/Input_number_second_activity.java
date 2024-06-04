package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class Input_number_second_activity extends AppCompatActivity {

    TextView txtinput;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_number_second);

        txtinput=findViewById(R.id.txtinputnumber);

        int num1=getIntent().getIntExtra("num1",0);
        int num2=getIntent().getIntExtra("num2",0);

        StringBuilder Numbers=new StringBuilder();

        for (int i=num1+1;i<num2;i++){
            Numbers.append(i).append(" ");

        }
        txtinput.setText(Numbers.toString());


    }
}