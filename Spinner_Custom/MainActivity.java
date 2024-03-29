package com.example.spinner_cutom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    private ArrayList<Model>fruitlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.spinner);

        ArrayList<Model>fruitlist=new ArrayList<>();

        fruitlist.add(new Model("Apple",R.drawable.apple,"Vitamin-C"));
        fruitlist.add(new Model("Banana",R.drawable.banana,"improve digstive system"));
        fruitlist.add(new Model("Pineapple",R.drawable.pineapple,"Strengthen Bones"));
        fruitlist.add(new Model("Custard Apple",R.drawable.custard_apple,"promotes the digestion process"));
        fruitlist.add(new Model("Grapes",R.drawable.grapes,"The nutrients in grapes may help protect against cancer"));
        fruitlist.add(new Model("Orange",R.drawable.orange,"Helps your body make collagen"));
        fruitlist.add(new Model("Mango",R.drawable.mango,"Support your healthy weight goals"));
        fruitlist.add(new Model("Pomogranet",R.drawable.pomogranet,"Heart health benefits"));
        fruitlist.add(new Model("Watermelon",R.drawable.watermelon,"Helps in blood sugar management"));
        fruitlist.add(new Model("Papaya",R.drawable.papaya,"protection against heart disease"));

        MyAdapter adapter=new MyAdapter(this,fruitlist);
        spinner.setAdapter(adapter);

    }
}