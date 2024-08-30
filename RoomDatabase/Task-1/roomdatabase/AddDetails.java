package com.example.roomdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.roomdatabase.databinding.ActivityAddDetailsBinding;

public class AddDetails extends AppCompatActivity {
    ActivityAddDetailsBinding binding;
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddDetailsBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        viewModel=new ViewModelProvider(this).get(ViewModel.class);


        binding.addDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=binding.edtname.getText().toString();
                String age=binding.edtage.getText().toString();
                String city=binding.edtcity.getText().toString();
                String phone_number=binding.edtphone.getText().toString();
                String email=binding.edtemail.getText().toString();
                String password=binding.edtpassword.getText().toString();


                if (TextUtils.isEmpty(name)){
                    binding.edtname.setError("Please Enter Name");
                }
                else if (TextUtils.isEmpty(age)){
                    binding.edtage.setError("Please Enter Age");
                }
                else if (TextUtils.isEmpty(city)){
                    binding.edtcity.setError("You Have to Enter your city name");
                } else if (TextUtils.isEmpty(phone_number)) {
                    binding.edtphone.setError("You have to enter your phone number");

                } else if (TextUtils.isEmpty(email)) {
                    binding.edtemail.setError("Email Required");

                } else if (TextUtils.isEmpty(password))
                {
                    binding.edtpassword.setError("Email Password is Required");

                }
                else
                {
                    UserModel userModel=new UserModel(0,1,name,age,city,phone_number,email,password);
                    viewModel.insert(userModel);
                    Toast.makeText(AddDetails.this, "All Details Has been Inserted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });

    }
}