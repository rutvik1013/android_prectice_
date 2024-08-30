package com.example.roomdatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.roomdatabase.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private ViewModel viewModel;
    private Myadapter myadapter;
    private List<UserModel>list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        list=new ArrayList<>();

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        myadapter=new Myadapter(this,this,list);
        binding.recyclerview.setAdapter(myadapter);


        viewModel=new ViewModelProvider(this).get(ViewModel.class);

        binding.floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddDetails.class));
            }
        });

        viewModel.getAllUsers().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> models) {
                if (models!=null){
                    myadapter.setDetails(models);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Details Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}