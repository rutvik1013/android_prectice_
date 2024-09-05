package com.example.jsonpersingapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jsonpersingapi.databinding.ActivityFullScreenactivityBinding;
import com.squareup.picasso.Picasso;

public class FullScreenactivity extends AppCompatActivity {

    ActivityFullScreenactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFullScreenactivityBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        // Get the data from the intent
        Intent i=getIntent();
        String name=i.getStringExtra("name");
        String realname=i.getStringExtra("realname");
        String team=i.getStringExtra("team");
        String firstapperence=i.getStringExtra("firstappearance");
        String createby=i.getStringExtra("createdby");
        String publisherValue=i.getStringExtra("publisher");
        String bio=i.getStringExtra("bio");
        String imageurl=i.getStringExtra("imageurl");

        // Set the data to the views
        binding.txtname.setText(name);
        binding.txtrealname.setText(realname);
        binding.txtTeam.setText(team);
        binding.txtFirstapperence.setText(firstapperence);
        binding.txtCreatedby.setText(createby);
        binding.txtPublisher.setText(publisherValue);
        binding.txtBio.setText(bio);

        Picasso.get().load(imageurl).into(binding.imagemovie);
    }
}
