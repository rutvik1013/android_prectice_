package com.example.retrofitapicalling;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.retrofitapicalling.databinding.ActivityFullScreenBinding;
import com.squareup.picasso.Picasso;

public class FullScreen extends AppCompatActivity {

    ActivityFullScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFullScreenBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);


        // get data from Retrofit Adapter class using getIntent()

        Intent i=getIntent();

        String imageurl=i.getStringExtra("imageurl");
        String name=i.getStringExtra("name");
        String realname=i.getStringExtra("realname");
        String team=i.getStringExtra("team");
        String firstappearance=i.getStringExtra("firstappearance");
        String createdby=i.getStringExtra("createdby");
        String publisher=i.getStringExtra("publisher");
        String bio=i.getStringExtra("bio");


        // get the image from the api using picasso
        Picasso.get().load(imageurl).into(binding.imagemovie);

        // get the data from the api
        binding.textname.setText(name);
        binding.textrealname.setText(realname);
        binding.textTeam.setText(team);
        binding.textFirstapperence.setText(firstappearance);
        binding.textCreatedby.setText(createdby);
        binding.textPublisher.setText(publisher);
        binding.textBio.setText(bio);
    }
}