package com.example.listtview_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {

    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    ArrayList<String> spinnerlist;
    ArrayList<String>autotxtlist;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = findViewById(R.id.spinner);
        autoCompleteTextView=findViewById(R.id.autoCompletetxt);

        // Initialize spinner list
        spinnerlist = new ArrayList<>();
        spinnerlist.add("Rutvik");
        spinnerlist.add("Dhaval");
        spinnerlist.add("Jayraj");
        spinnerlist.add("Ronak");
        spinnerlist.add("Ruturaj");
        spinnerlist.add("Raju");


        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerlist);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        // Auto Complete textview

        autotxtlist=new ArrayList<>();

        autotxtlist.add("C");
        autotxtlist.add("C++");
        autotxtlist.add("Java");
        autotxtlist.add("Kotlin");
        autotxtlist.add("Javascript");
        autotxtlist.add("Python");
        autotxtlist.add("C#");
        autotxtlist.add("HTML");
        autotxtlist.add("Objective C");
        autotxtlist.add("Rutvik");

        ArrayAdapter<String>autoadapter=new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,autotxtlist);
        autoCompleteTextView.setAdapter(autoadapter);
        autoCompleteTextView.setThreshold(1);



    }
}
