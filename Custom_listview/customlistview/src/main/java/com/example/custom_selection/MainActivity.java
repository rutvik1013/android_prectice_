package com.example.custom_selection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<custom_model> customlist;
    TextView textempty;
    ImageView imageclear;
    MyAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customlist = new ArrayList<>();

        textempty = findViewById(R.id.textview_empty);
        imageclear = findViewById(R.id.image_call);

        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        customlist.add(new custom_model(R.drawable.image1, " Name: Rutvik Babariya", " Phone Number: 6351202084"));
        customlist.add(new custom_model(R.drawable.image2, " Name: Dhaval Babariya", " Phone Number: 9878654532"));
        customlist.add(new custom_model(R.drawable.image3, " Name: Jayraj Babariya", " Phone Number: 7689673412"));
        customlist.add(new custom_model(R.drawable.image4, " Name: Bhavesh Babariya", " Phone Number: 7865456765"));
        customlist.add(new custom_model(R.drawable.image5, " Name: Bhavin Babariya", " Phone Number: 7656789096"));
        customlist.add(new custom_model(R.drawable.image6, " Name: Ronak Dholakiya", " Phone Number: 8986789043"));
        customlist.add(new custom_model(R.drawable.image7, " Name: Dhairya Shah", " Phone Number: 65439787878"));
        customlist.add(new custom_model(R.drawable.image8, " Name: Ruturaj Jadeja", " Phone Number: 7123456789"));
        customlist.add(new custom_model(R.drawable.image9, " Name: Raju Karamata", " Phone Number: 8129067862"));
        customlist.add(new custom_model(R.drawable.image10, " Name: Narendra Rathod", " Phone Number: 6355053750"));
        customlist.add(new custom_model(R.drawable.image11, "Name: Bhavin Dangar", " Phone Number: 8756431238"));
        customlist.add(new custom_model(R.drawable.image12, " Name: Rajakotiya Pratik", " Phone Number: 9876098769"));
        customlist.add(new custom_model(R.drawable.image13, " Name: Makavana Dikshit", " Phone Number: 7654234561"));
        customlist.add(new custom_model(R.drawable.image14, " Name: Viramgama Dhruv", " Phone Number: 8765890670"));
        customlist.add(new custom_model(R.drawable.image15, " Name: Kaneriya Meet", " Phone Number: 8123567890"));
        customlist.add(new custom_model(R.drawable.image16, " Name: Tilva Parth", " Phone Number: 6351299810"));
        customlist.add(new custom_model(R.drawable.image17, " Name: Jaydip Babariya", " Phone Number: 7890543421"));
        customlist.add(new custom_model(R.drawable.image18, " Name: Mahipat Babariya", " Phone Number: 8790190566"));
        customlist.add(new custom_model(R.drawable.image19, " Name: Alpesh Babariya", " Phone Number: 7654321234"));
        customlist.add(new custom_model(R.drawable.image20, " Name: Yuvraj Babariya", " Phone Number: 7613087564"));

        adapter = new MyAdapter(this, customlist, textempty, imageclear);
        recyclerView.setAdapter(adapter);


    }

    // calling onCreateOptionsMenu to inflate our menu file
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.searchview, menu);

        MenuItem searchItem = menu.findItem(R.id.search_name);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });

        return true;
    }

    private void filter(String text) {
        ArrayList<custom_model> filteredlist = new ArrayList<>();

        for (custom_model item : customlist) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }

        if (filteredlist.isEmpty()) {
            Toast.makeText(this, "Data Not Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.filteredList(filteredlist);
        }
    }
}