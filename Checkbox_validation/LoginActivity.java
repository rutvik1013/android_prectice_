package com.example.checkbox_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText edtname,edtemail,edtpass;
    Button btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtname=findViewById(R.id.edtname);
        edtemail=findViewById(R.id.edtemail);
        edtpass=findViewById(R.id.edtpass);
        btnlogin=findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtname.getText().toString();
                String email=edtemail.getText().toString();
                String password=edtpass.getText().toString();

                if (name.length()==0&&email.length()==0&&password.length()==0){
                    edtname.setError("Please Enter Your Full Name");
                    edtemail.setError("Please Enter Your Email Adress");
                    edtpass.setError("Please Enter Your Password");
                }
                else if (edtname.length()==0){
                    edtname.setError("Please Enter Your Full Name");
                }
                else if (edtemail.length()==0){
                    edtemail.setError("Please Enter Your Email Adress");
                }
                else if (edtpass.length()==0){
                    edtpass.setError("Please Enter Your Password");
                }
                else {
                    if (name.equals("Babariya Rutvik")&&email.equals("babariyarutviksinh85@gmail.com")&&password.equals("1013")){
                        Toast.makeText(LoginActivity.this, "Loggin", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}