package com.example.retrofitapicalling;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.retrofitapicalling.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String apiUrl="https://simplifiedcoding.net/demos/marvel/";
    private Apiinterface apiinterface;
    private List<RetrofitModel>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        apiinterface=ApiClient.getApi().create(Apiinterface.class);

        binding.recycleview.setHasFixedSize(true);

        binding.recycleview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));



        Call<List<RetrofitModel>>call=apiinterface.getdata();

        call.enqueue(new Callback<List<RetrofitModel>>() {
            @Override
            public void onResponse(Call<List<RetrofitModel>> call, Response<List<RetrofitModel>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Data Are Showing", Toast.LENGTH_SHORT).show();
                }
                list=response.body();
                RetrofitAdapter adapter=new RetrofitAdapter(MainActivity.this,list);
                binding.recycleview.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<RetrofitModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "No Internet Try Again Later!", Toast.LENGTH_SHORT).show();
            }
        });




    }
}