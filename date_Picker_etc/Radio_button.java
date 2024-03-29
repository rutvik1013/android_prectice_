package com.example.datepicker_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.example.datepicker_ex.databinding.ActivityRadioButtonBinding;

public class Radio_button extends AppCompatActivity {
    ActivityRadioButtonBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRadioButtonBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

//        binding.radioyellow.setOnCheckedChangeListener((compoundButton,b)->{
//            if (binding.radioyellow.isChecked()){
//                binding.relativelayout.setBackgroundColor(Color.YELLOW);
//            }
//        });
//        binding.radioblue.setOnCheckedChangeListener((compoundButton,b)->{
//            if (binding.radioblue.isChecked()){
//                binding.relativelayout.setBackgroundColor(Color.BLUE);
//            }
//        });
//        binding.radiored.setOnCheckedChangeListener((compoundButton,b)->{
//            if (binding.radiored.isChecked()){
//                binding.relativelayout.setBackgroundColor(Color.RED);
//            }
//        });
//        binding.radioblack.setOnCheckedChangeListener((compoundButton,b)->{
//            if (binding.radioblack.isChecked()){
//                binding.relativelayout.setBackgroundColor(Color.BLACK);
//            }
//        });
//        binding.radiowhite.setOnCheckedChangeListener((compundButton,b)->{
//            if (binding.radiowhite.isChecked()){
//                binding.relativelayout.setBackgroundColor(Color.WHITE);
//            }
//        });

        binding.addRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    binding.btncalculator.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            binding.txtTotal.setText(String.valueOf(Integer.parseInt(binding.edt1stnmumber.getText().toString())+Integer.parseInt(binding.edt2ndnumber.getText().toString())));
                            binding.linear.setBackgroundColor(Color.YELLOW);
                        }
                    });
                }
            }
        });
        binding.subRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    binding.btncalculator.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            binding.txtTotal.setText(String.valueOf(Integer.parseInt(binding.edt1stnmumber.getText().toString())-Integer.parseInt(binding.edt2ndnumber.getText().toString())));
                            binding.linear.setBackgroundColor(Color.BLUE);

                        }
                    });
                }
            }
        });
        binding.multiRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    binding.btncalculator.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            binding.txtTotal.setText(String.valueOf(Integer.parseInt(binding.edt1stnmumber.getText().toString())*Integer.parseInt(binding.edt2ndnumber.getText().toString())));
                            binding.linear.setBackgroundColor(Color.GREEN);
                        }
                    });
                }
            }
        });
        binding.divRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    binding.btncalculator.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            binding.txtTotal.setText(String.valueOf(Integer.parseInt(binding.edt1stnmumber.getText().toString())/Integer.parseInt(binding.edt2ndnumber.getText().toString())));
                            binding.linear.setBackgroundColor(Color.DKGRAY);
                        }
                    });
                }
            }
        });
    }
}