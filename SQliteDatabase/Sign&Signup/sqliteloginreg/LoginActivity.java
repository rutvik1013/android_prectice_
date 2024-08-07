package com.example.sqliteloginreg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqliteloginreg.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    DbHelper dbHelper;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dbHelper = new DbHelper(this);

        sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("session", false) && !sharedPreferences.getString("email", "").isEmpty()) {
            Intent i = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(i);
            finish(); // Finish the current activity so the user cannot go back to the login screen
        }

        binding.btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.edtemail.getText().toString().trim();
                String password = binding.edtpass.getText().toString().trim();

                if (email.isEmpty()) {
                    binding.edtemail.setError("Please Enter Email Address");
                } else if (password.isEmpty()) {
                    binding.edtpass.setError("You have to Enter password");
                } else {
                    if (dbHelper.validateUser(email, password)) {
                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("session", true);
                        editor.putString("email", email);
                        editor.apply(); // Use apply instead of commit for asynchronous save

                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(i);
                        finish(); // Finish the current activity so the user cannot go back to the login screen
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.signuptext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
