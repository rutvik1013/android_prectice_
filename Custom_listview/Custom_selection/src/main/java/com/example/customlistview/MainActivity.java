package com.example.customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private ArrayList<carmodel> list;
    private ArrayList<carmodel> selectedcarlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        list = new ArrayList<>();

        list.add(new carmodel(R.drawable.bmw_x1, "BMW X1", "Price: 49.50 Lakhs"));
        list.add(new carmodel(R.drawable.bmwx7, "BMW X7", "Price: 1.27 to 1.33 Cr"));
        list.add(new carmodel(R.drawable.bmwm3, "BMW M3", "Price: 1.47 cr"));
        list.add(new carmodel(R.drawable.bmwm4, "BMW M4", "Price: 1.53 cr"));
        list.add(new carmodel(R.drawable.bmwm5_, "BMW M5", "Price: 1.99 cr"));
        list.add(new carmodel(R.drawable.audiq1, "Audi Q1", "Price: 28 Lakhs"));
        list.add(new carmodel(R.drawable.audiq2, "Audi Q2", "Price: 34.99 to 48.89 Lakhs"));
        list.add(new carmodel(R.drawable.audiq3, "Audi Q3", "Price: 44.25 to 54.65 Lakhs"));
        list.add(new carmodel(R.drawable.audiq4, "Audi Q4", "Price: 70 Lakhs"));
        list.add(new carmodel(R.drawable.audiq5, "Audi Q5", "65.51 lakh to 70.80 lakhs"));
        list.add(new carmodel(R.drawable.hyundai_i20, "Hyundai i20", "Price: 7.04 Lakhs"));
        list.add(new carmodel(R.drawable.hyundai_venue, "Hyundai Venue", "Price: 7.94 Lakhs"));
        list.add(new carmodel(R.drawable.hyundai_aura, "Hyundai Aura", "Price: 6.49 Lakhs"));
        list.add(new carmodel(R.drawable.hyundai_creta, "Hyundai Creta", "Price: 20.30 Lakhs"));
        list.add(new carmodel(R.drawable.hyundai_alcazar, "Hyundai Alcazar", "Price: 14.99 Lakhs"));
        list.add(new carmodel(R.drawable.toyota_fortuner, "Toyota Fortuner", "Price: 33.43 Lakh to 40.03 Lakh"));
        list.add(new carmodel(R.drawable.toyota_camry, "Toyota Camry", "Price: 55.76 Lakhs"));
        list.add(new carmodel(R.drawable.toyota_innova_hycross, "Toyota innova Hycross", "Price: 19.94 Lakhs"));
        list.add(new carmodel(R.drawable.toyota_taisor, "Toyota Taisor", "Price: 7.74 Lakhs"));
        list.add(new carmodel(R.drawable.toyota_vellfire, "Toyota Vellfire", "Price: 1.22 crore to 1.33 crore"));

        carAdapter adapter = new carAdapter(getApplicationContext(), list,selectedcarlist);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_selct, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.selct_item) {
            // If the selected cars list has 5 items, send to the next activity
            if (selectedcarlist.size() == 5) {
                Intent i = new Intent(MainActivity.this, NextActivity.class);
                i.putParcelableArrayListExtra("selectedcars", selectedcarlist);
                startActivity(i);
            } else {
                Toast.makeText(MainActivity.this, "You can Select only 5 items", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}