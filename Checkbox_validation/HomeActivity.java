package com.example.checkbox_form;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
   com.example.checkbox_form.databinding.ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= com.example.checkbox_form.databinding.ActivityHomeBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        binding.btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder builder=new StringBuilder("\n Selected items:\n");
                int amount=0;

              if (binding.chkpizza.isChecked()){
                  builder.append("\n Pizza Rs.150\n");
                  amount+=150;
              }
              if (binding.chkburger.isChecked()){
                  builder.append("\n Burger Rs.170\n");
                  amount+=170;
              }
              if (binding.chkdhosa.isChecked()){
                  builder.append("\n Dhosa Rs.250\n");
                  amount+=250;
              }
              if (binding.chknoodles.isChecked()){
                  builder.append("\n Noodles Rs.300\n");
                  amount+=300;
              }
              if (binding.chkmanchurian.isChecked()){
                  builder.append("\n Manchrian Rs.500\n");
                  amount+=500;

              }
              builder.append("----------------------------");
              builder.append("\n Total: "+amount);

                Intent i=new Intent(HomeActivity.this, BillActivity.class);
                i.putExtra("Bill: ",builder.toString());
                startActivity(i);

            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}