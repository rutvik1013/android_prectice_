package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ToggleButton;

public class Loginform extends AppCompatActivity {

    ToggleButton toggleButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginform);

        toggleButton=findViewById(R.id.togglebutton);


        LoadFragment(new LoginFragment3());

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                LoadFragment(new RegistrationFragment3());
            }
            else
            {
                LoadFragment(new LoginFragment3());
            }
        });
    }

    private void LoadFragment(Fragment fragment)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.framcontainer,fragment);
        ft.commit();
    }
}