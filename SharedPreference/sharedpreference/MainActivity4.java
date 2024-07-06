package com.example.sharedpreference;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView txtshared;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);


        txtshared=findViewById(R.id.txtshared);

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String a=sharedPreferences.getString("a1","Rutvik");
        String b=sharedPreferences.getString("b1","Jayraj");
        boolean c=sharedPreferences.getBoolean("c1",false);
        String d=sharedPreferences.getString("d1","Dhaval");


        txtshared.append("\n"+a+"\n");
        txtshared.append("\n"+b+"\n");
        txtshared.append("\n"+c+"\n");
        txtshared.append("\n"+d+"\n");


    }
}