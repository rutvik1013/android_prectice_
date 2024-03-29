package com.example.checkbox_form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.checkbox_form.databinding.ActivityCheckboxBinding;

public class CheckboxActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ActivityCheckboxBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCheckboxBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);


        binding.checkbox1.setOnCheckedChangeListener(this);
        binding.checkbox2.setOnCheckedChangeListener(this);
        binding.checkbox3.setOnCheckedChangeListener(this);
        binding.checkbox4.setOnCheckedChangeListener(this);


        binding.btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.checkbox1.isChecked()){
                    Toast.makeText(CheckboxActivity.this, "English", Toast.LENGTH_SHORT).show();
                }
                if (binding.checkbox2.isChecked()){
                    Toast.makeText(CheckboxActivity.this, "Gujarati", Toast.LENGTH_SHORT).show();
                }
                if (binding.checkbox3.isChecked()){
                    Toast.makeText(CheckboxActivity.this, "Hindi", Toast.LENGTH_SHORT).show();
                }
                if (binding.checkbox4.isChecked()){
                    Toast.makeText(CheckboxActivity.this, "Tamil", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}