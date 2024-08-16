package com.example.roomdbexam.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdbexam.Activity.Roomdbclass.MyAdapter;
import com.example.roomdbexam.Activity.Roomdbclass.UserModel;
import com.example.roomdbexam.Activity.Roomdbclass.ViewModel;
import com.example.roomdbexam.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ViewModel viewModel;
    private MyAdapter adapter;
    private List<UserModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this, this, list);
        binding.recyclerview.setAdapter(adapter);

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        // Observe LiveData
        viewModel.getAllData_().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) {
                if (userModels != null) {
                    adapter.setList(userModels);
                } else {
                    Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.floating.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, Adduser.class);
            startActivity(i);
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                UserModel userModel = adapter.getUserAt(viewHolder.getAdapterPosition());
                viewModel.delete(userModel);
                Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(binding.recyclerview);
    }
}
