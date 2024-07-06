package com.example.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.sharedpreference.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sharedPreferences = getSharedPreferences("session", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("session", false) && !sharedPreferences.getString("name", "").isEmpty()) {
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);
            finish();
        }

        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.edtname.getText().toString();
                String email = binding.edtemail.getText().toString();
                String password = binding.edtpass.getText().toString();

                if (name.isEmpty()) {
                    binding.edtname.setError("Enter Name");
                } else if (email.isEmpty()) {
                    binding.edtemail.setError("Enter Email");
                } else if (password.isEmpty()) {
                    binding.edtpass.setError("Enter Password");
                } else {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("session", true);
                    editor.putString("name", name);
                    editor.putString("email", email);
                    editor.putString("password", password);
                    editor.apply();
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
