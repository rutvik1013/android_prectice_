package com.example.cricinfo.CricActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.cricinfo.Adapters.CskFragmentpageradapter;
import com.example.cricinfo.FragmentCsk.BattingFragment;
import com.example.cricinfo.FragmentCsk.BowlingFragment;
import com.example.cricinfo.FragmentCsk.InfoFragment;
import com.example.cricinfo.R;
import com.google.android.material.tabs.TabLayout;

public class CskListActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    CskFragmentpageradapter cskFragmentpageradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csk_list);

        viewPager=findViewById(R.id.cskviewpager);

        tabLayout=findViewById(R.id.csktablayout);


        setupviewpager();

        tabLayout.setupWithViewPager(viewPager);


    }
    private void setupviewpager(){
        cskFragmentpageradapter=new CskFragmentpageradapter(getSupportFragmentManager());
        cskFragmentpageradapter.addFragment("Info",new InfoFragment());
        cskFragmentpageradapter.addFragment("Batting",new BattingFragment());
        cskFragmentpageradapter.addFragment("Bowling",new BowlingFragment());
       viewPager.setAdapter(cskFragmentpageradapter);
    }



}