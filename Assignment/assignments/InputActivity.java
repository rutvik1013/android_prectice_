package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class InputActivity extends AppCompatActivity {

    TextInputEditText edtfirstnum;
    TextInputEditText edtsecondnum;
    AppCompatButton btnsubmit;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        edtfirstnum=findViewById(R.id.edt1stnum);
        edtsecondnum=findViewById(R.id.edt2ndnum);
        btnsubmit=findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edt1stnum=edtfirstnum.getText().toString();
                String edt2ndnum=edtsecondnum.getText().toString();

                if (edt1stnum.isEmpty()||edt2ndnum.isEmpty()){
                    Toast.makeText(InputActivity.this, "You Have to Enter both two numbers", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int num1=Integer.parseInt(edt1stnum);
                    int num2=Integer.parseInt(edt2ndnum);


                    Intent i=new Intent(getApplicationContext(), Input_number_second_activity.class);
                    i.putExtra("num1",num1);
                    i.putExtra("num2",num2);
                    startActivity(i);
                }
            }
        });

    }
}