package com.example.datepicker_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.example.datepicker_ex.databinding.ActivitySeekbarBinding;

public class SeekbarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    ActivitySeekbarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySeekbarBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        binding.seekred.setOnSeekBarChangeListener(this);
        binding.seekgreen.setOnSeekBarChangeListener(this);
        binding.seekblue.setOnSeekBarChangeListener(this);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int red=binding.seekred.getProgress();
        int green=binding.seekgreen.getProgress();
        int blue=binding.seekblue.getProgress();
        int backgroundcolor=Color.rgb(red,green,blue);
        binding.linearlayout.setBackgroundColor(backgroundcolor);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}