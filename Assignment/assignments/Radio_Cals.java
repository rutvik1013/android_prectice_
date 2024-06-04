package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.example.assignments.databinding.ActivityRadioCalsBinding;

public class Radio_Cals extends AppCompatActivity {
    ActivityRadioCalsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRadioCalsBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);


        binding.addRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                binding.btncalculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        binding.txtcalculate.setText(String.valueOf(Integer.parseInt(binding.edtradio1stnumber.getText().toString())+Integer.parseInt(binding.edtradio2ndnumber.getText().toString())));
                        binding.linear.setBackgroundColor(Color.LTGRAY);
                    }
                });
            }
        });
        binding.subRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                binding.btncalculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        binding.txtcalculate.setText(String.valueOf(Integer.parseInt(binding.edtradio1stnumber.getText().toString())-Integer.parseInt(binding.edtradio2ndnumber.getText().toString())));
                        binding.linear.setBackgroundColor(Color.YELLOW);
                    }
                });
            }
        });
        binding.multiRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                binding.btncalculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        binding.txtcalculate.setText(String.valueOf(Integer.parseInt(binding.edtradio1stnumber.getText().toString())*Integer.parseInt(binding.edtradio2ndnumber.getText().toString())));
                        binding.linear.setBackgroundColor(Color.RED);
                    }
                });
            }
        });
        binding.divRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                binding.btncalculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        binding.txtcalculate.setText(String.valueOf(Integer.parseInt(binding.edtradio1stnumber.getText().toString())/Integer.parseInt(binding.edtradio2ndnumber.getText().toString())));
                        binding.linear.setBackgroundColor(Color.DKGRAY);
                    }
                });
            }
        });
    }
}