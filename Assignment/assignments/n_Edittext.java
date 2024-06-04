package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class n_Edittext extends AppCompatActivity {

    EditText edtinputnumber;
    AppCompatButton btngenerate;
    LinearLayout linearLayout;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nedittext);

        edtinputnumber=findViewById(R.id.edt_input_number);
        btngenerate=findViewById(R.id.generatebtn);
        linearLayout=findViewById(R.id.linear_cointener);


    btngenerate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            linearLayout.removeAllViews();
            String input=edtinputnumber.getText().toString();

            if (input.isEmpty()){
                Toast.makeText(n_Edittext.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
            }
            int numberoffields=Integer.parseInt(input);

            for (int i=0;i<numberoffields;i++){

                EditText editText=new EditText(n_Edittext.this);
                editText.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT

                ));
                editText.setHint("Field "+(i+1));
                linearLayout.addView(editText);
            }
        }
    });

    }
}