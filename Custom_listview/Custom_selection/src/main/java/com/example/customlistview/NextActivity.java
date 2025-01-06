package com.example.customlistview;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class NextActivity extends AppCompatActivity {
    GridView gridView;
    private ArrayList<carmodel>carlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        gridView=findViewById(R.id.gridview);

        ArrayList<carmodel>selectedcars=getIntent().getParcelableArrayListExtra("selectedcars");

        if (selectedcars!=null&&selectedcars.size()>0){
            carAdapter adapter=new carAdapter(this,selectedcars,carlist);
            gridView.setAdapter(adapter);
        }
        else {
            Toast.makeText(this, "No Item Selected", Toast.LENGTH_SHORT).show();
        }
    }
}