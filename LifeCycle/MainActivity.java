package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtweight;
    EditText edtheightft;
    EditText edtheinch;
    Button btnbmi;
    TextView txtresult;
    LinearLayout layout;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtweight=findViewById(R.id.edtheight);
        edtheightft=findViewById(R.id.edtweightft);
        edtheinch=findViewById(R.id.edtheightinch);
        btnbmi=findViewById(R.id.btnbmi);
        txtresult=findViewById(R.id.txtresult);
        layout=findViewById(R.id.linearlayout);


        btnbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight=Integer.parseInt(edtweight.getText().toString());
                int heft=Integer.parseInt(edtheightft.getText().toString());
                int heinch=Integer.parseInt(edtheinch.getText().toString());

                int totalInch=heft*12+heinch;
                double totalcm=totalInch*2.53;
                double totalM=totalcm/100;
                double bmi=weight/(totalM*totalM);

                if (bmi>25){
                    txtresult.setText("You are Overweight");
                    layout.setBackgroundResource(R.color.O_Weight);
                }
                else if (bmi<18){
                    txtresult.setText("You are Underweight");
                    layout.setBackgroundResource(R.color.U_weight);
                }
                else {
                    txtresult.setText("You are Healthy");
                    layout.setBackgroundResource(R.color.healthy);
                }
            }
        });
    }
}