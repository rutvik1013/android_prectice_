package com.example.sqlitedbtask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sqlitedbtask.databinding.ActivityViewDataBinding;

import java.util.ArrayList;
import java.util.List;

public class ViewData extends AppCompatActivity {
    ActivityViewDataBinding binding;
     private ArrayList<detailsModel>list;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityViewDataBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        databaseHelper=new DatabaseHelper(this);
        list=new ArrayList<>();
        list=databaseHelper.viewdetails();

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));

       binding.floting.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(getApplicationContext(), InsertActivity.class);
               startActivity(i);
           }
       });


        DetailsAdapter adapter=new DetailsAdapter(this,list,databaseHelper);
        binding.recyclerview.setAdapter(adapter);


    }
}