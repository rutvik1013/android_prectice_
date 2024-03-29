package com.example.listtview_ex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
ListView listView;
ArrayList<String>list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.list);

        list.add("Rutvik");
        list.add("Dhaval");
        list.add("Jayraj");
        list.add("Ronak");
        list.add("Rutvik");
        list.add("Dhaval");
        list.add("Jayraj");
        list.add("Ronak");
        list.add("Rutvik");
        list.add("Dhaval");
        list.add("Jayraj");
        list.add("Ronak");
        list.add("Rutvik");
        list.add("Dhaval");
        list.add("Jayraj");
        list.add("Ronak");
        list.add("Rutvik");
        list.add("Dhaval");
        list.add("Jayraj");
        list.add("Ronak");
        list.add("Rutvik");
        list.add("Dhaval");
        list.add("Jayraj");
        list.add("Ronak");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, SpinnerActivity.class);
                Toast.makeText(MainActivity.this, "List is Ready", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

    }
}