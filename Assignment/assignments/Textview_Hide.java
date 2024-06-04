package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.assignments.databinding.ActivityTextviewHideBinding;

public class Textview_Hide extends AppCompatActivity {

    ActivityTextviewHideBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTextviewHideBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);


        binding.buttonhide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txthideshow.setVisibility(View.GONE);
            }
        });
        binding.buttonshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txthideshow.setVisibility(View.VISIBLE);
            }
        });
    }
}