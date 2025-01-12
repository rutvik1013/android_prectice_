package com.example.custom_selection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import de.hdodenhof.circleimageview.CircleImageView;

public class customviewactivity extends AppCompatActivity {
        CircleImageView imgcaller;
        TextView txtname,txtphonenumber;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customviewactivity);

        imgcaller=findViewById(R.id.callerimage);
        txtname=findViewById(R.id.txt_name);
        txtphonenumber=findViewById(R.id.txt_phone_number);

        // Retrieve data from Intent
        custom_model model=getIntent().getParcelableExtra("position");
        imgcaller.setImageResource(model.getImage());
        txtname.setText(model.getName());
        txtphonenumber.setText(model.getPhone_number());
    }
}