package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    Toolbar toolbar;
   ViewPager viewPager;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager=findViewById(R.id.viewpager);
        setupviewpager();



        tabLayout=findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);




    }

    private void setupviewpager() {
        Fragment_adapter adapter=new Fragment_adapter(getSupportFragmentManager());
        adapter.addtitle("Chats",new ChatFragment());
        adapter.addtitle("Status",new StatusFragment());
        adapter.addtitle("Calls",new CallFragment());
        viewPager.setAdapter(adapter);

    }


}