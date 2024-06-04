package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class ReverceNumber extends AppCompatActivity {


    EditText edtnumber;
    TextView txtreversenumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverce_number);


        edtnumber=findViewById(R.id.edtnum);
        txtreversenumber=findViewById(R.id.txt_reverse_number);


        edtnumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                    String edtnumber=s.toString();
                    String reversetext=new StringBuilder(edtnumber).reverse().toString();
                    txtreversenumber.setText(reversetext);
            }
        });
    }
}