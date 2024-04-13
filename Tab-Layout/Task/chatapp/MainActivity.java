package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    TabLayout tabLayout;
    ViewPager viewPager;
    Fragment_Chat_Adapter adapter;
    ArrayList<Fragment_chat_Model>chat_list;

    private int[] tabIcons = {R.drawable.baseline_chat_24,
            R.drawable.baseline_update_24,
            R.drawable.baseline_call_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chat_list=new ArrayList<>();

        viewPager = findViewById(R.id.viewpager);
        setupviewpager();

        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        setTabIcons();


    }

    private void setTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setupviewpager(){
        ChatFragmentAdapter adapter = new ChatFragmentAdapter(getSupportFragmentManager());
        adapter.addtitle("Chats", new ChatsFragment());
        adapter.addtitle("Status", new StatusFragment());
        adapter.addtitle("Calls", new CallsFragment());
        viewPager.setAdapter(adapter);

    }


}


