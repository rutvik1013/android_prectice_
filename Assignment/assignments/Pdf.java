package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class Pdf extends AppCompatActivity {

    AppCompatButton btnpdf;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        btnpdf=findViewById(R.id.openpdf);

        btnpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openPdf();
            }

        });


    }
    private void openPdf(){
        String Value="https://topsint.com/careercenter/assignment/android_assignment.pdf";
        Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse(Value));
        startActivity(i);
    }
}