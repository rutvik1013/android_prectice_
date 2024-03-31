package com.example.customlist_car;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView carlist;
    private ArrayList<Carlist>carbrandlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carlist=findViewById(R.id.carbrandlist);

        ArrayList<Car_brand_Model>carbrandlist=new ArrayList<>();

        carbrandlist.add(new Car_brand_Model(R.drawable.bmw,"BMW"));
        carbrandlist.add(new Car_brand_Model(R.drawable.audi,"Audi"));
        carbrandlist.add(new Car_brand_Model(R.drawable.kia,"Kia"));
        carbrandlist.add(new Car_brand_Model(R.drawable.tata,"Tata"));
        carbrandlist.add(new Car_brand_Model(R.drawable.toyota,"Toyota"));
        carbrandlist.add(new Car_brand_Model(R.drawable.skoda,"Skoda"));
        carbrandlist.add(new Car_brand_Model(R.drawable.hyundai,"Hyundai"));
        carbrandlist.add(new Car_brand_Model(R.drawable.ford,"Ford"));
        carbrandlist.add(new Car_brand_Model(R.drawable.mahindra,"Mahindra"));
        carbrandlist.add(new Car_brand_Model(R.drawable.porche,"Porche"));

        MyCaradapter caradapter=new MyCaradapter(this,carbrandlist);
        carlist.setAdapter(caradapter);
    }
}