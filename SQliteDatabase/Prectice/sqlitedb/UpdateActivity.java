package com.example.sqlitedb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sqlitedb.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {
    ActivityUpdateBinding binding;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        dbHelper=new DbHelper(this);

        Intent i=getIntent();
        int id=i.getIntExtra("id",101);
        binding.edtname.setText(i.getStringExtra("name"));
        binding.edtphonenumber.setText(i.getStringExtra("phone_number"));

        binding.btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=binding.edtname.getText().toString();
                String phone_number=binding.edtphonenumber.getText().toString();

                Model m=new Model();
                m.setId(id);
                m.setName(name);
                m.setPhone_number(phone_number);

                int updateId=dbHelper.updateContacts(m);
                Toast.makeText(UpdateActivity.this, "Contact Updated", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
            }
        });

    }
}