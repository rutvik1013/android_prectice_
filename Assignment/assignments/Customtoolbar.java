package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Customtoolbar extends AppCompatActivity {

    ListView listView_;
    private ArrayList<Custommodel>list;
    private CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customtoolbar);

        listView_=findViewById(R.id.listview_);

        list=new ArrayList<>();

        list.add(new Custommodel(R.drawable.img1,"Babariya Rutvik"));
        list.add(new Custommodel(R.drawable.image2,"Babariya Dhaval"));
        list.add(new Custommodel(R.drawable.image3,"Babariya Bhavin"));
        list.add(new Custommodel(R.drawable.image4,"Babariya Bhavesh"));
        list.add(new Custommodel(R.drawable.image5,"Babariya Suresh"));
        list.add(new Custommodel(R.drawable.image6,"Babariya Nayan"));
        list.add(new Custommodel(R.drawable.image7,"Babariya Jayraj"));
        list.add(new Custommodel(R.drawable.image8,"Babariya Narendra"));
        list.add(new Custommodel(R.drawable.image9,"Babariya Mahipat"));
        list.add(new Custommodel(R.drawable.image10,"Babariya Yuvraj"));

        adapter=new CustomAdapter(this,list);
        listView_.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu,menu);
        MenuItem msearch=menu.findItem(R.id.searchview);
        SearchView searchView=(SearchView)msearch.getActionView();
        searchView.setQueryHint("Search Here");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    private void filter(String text){
        ArrayList<Custommodel>filteredlist=new ArrayList<>();
        for (Custommodel custommodel:list){
            if (custommodel.getName().toLowerCase().contains(text.toLowerCase()));
            {
                filteredlist.add(custommodel);

            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(getApplicationContext(), "No Data found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.filterList(filteredlist);
        }
    }
}