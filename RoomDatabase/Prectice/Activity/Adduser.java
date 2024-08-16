package com.example.roomdbexam.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.roomdbexam.Activity.Roomdbclass.UserModel;
import com.example.roomdbexam.Activity.Roomdbclass.ViewModel;
import com.example.roomdbexam.databinding.ActivityAdduserBinding;

public class Adduser extends AppCompatActivity {
    private ActivityAdduserBinding binding;
    private ViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdduserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel=new ViewModelProvider(this).get(ViewModel.class);


        binding.btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=binding.edtname.getText().toString();
                String age=binding.edtage.getText().toString();
                String email=binding.edtemail.getText().toString();
                String password=binding.edtpass.getText().toString();


                if (name.isEmpty() || age.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Adduser.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                UserModel model=new UserModel(0,name,age,email,password);
                viewModel.insert(model);
                Toast.makeText(Adduser.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }
}
