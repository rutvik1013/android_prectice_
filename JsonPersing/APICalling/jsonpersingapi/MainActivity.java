package com.example.jsonpersingapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jsonpersingapi.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private List<JsonModel>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        list=new ArrayList<>();

        String url="https://simplifiedcoding.net/demos/marvel/";

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        String name = jsonObject.getString("name");
                        String realname = jsonObject.getString("realname");
                        String team = jsonObject.getString("team");
                        String firstapperence = jsonObject.getString("firstappearance");
                        String createdby = jsonObject.getString("createdby");
                        String publisher = jsonObject.getString("publisher");
                        String imageurl = jsonObject.getString("imageurl");
                        String bio = jsonObject.getString("bio");

                        JsonModel model = new JsonModel(name, realname, team, firstapperence, createdby, publisher, imageurl, bio);

                        model.setName(name);
                        model.setRealname(realname);
                        model.setTeam(team);
                        model.setFirstappearance(firstapperence);
                        model.setCreatedby(createdby);
                        model.setPublisher(publisher);
                        model.setImageurl(imageurl);
                        model.setBio(bio);

                        list.add(model);

                    }
                    MyAdapter adapter = new MyAdapter(getApplicationContext(), list);
                    binding.listview.setAdapter(adapter);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Internet Connection unavailable", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }
}