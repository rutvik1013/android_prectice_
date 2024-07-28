package com.example.sqlitedbtask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sqlitedbtask.databinding.ActivityInsertBinding;

public class InsertActivity extends AppCompatActivity {
    ActivityInsertBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityInsertBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        databaseHelper=new DatabaseHelper(this);


        binding.btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date=binding.edtdate.getText().toString();
                String name=binding.edtname.getText().toString();
                String phone_number=binding.edtphone.getText().toString();
                String email=binding.edtemail.getText().toString();
                String adress=binding.edtadress.getText().toString();

                detailsModel model=new detailsModel();

                model.setDate(date);
                model.setName(name);
                model.setPhone_number(phone_number);
                model.setEmail(email);
                model.setAdress(adress);

                databaseHelper.insertdetails(model);
                Toast.makeText(InsertActivity.this, "Details Inserted", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InsertActivity.this, ViewData.class));

            }
        });

    }
}