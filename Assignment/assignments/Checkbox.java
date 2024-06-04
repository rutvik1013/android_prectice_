package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class Checkbox extends AppCompatActivity{

    CheckBox checkBox;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        checkBox = findViewById(R.id.checkname);
        textView = findViewById(R.id.txt_check_name);

       checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
           if (isChecked){
               textView.setVisibility(View.VISIBLE);
           }
           else
           {
               textView.setVisibility(View.GONE);
           }
       });
    }
}
