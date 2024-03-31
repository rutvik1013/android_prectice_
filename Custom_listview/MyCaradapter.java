package com.example.customlist_car;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCaradapter extends BaseAdapter
{
    private Context context;
    private ArrayList<Car_brand_Model>carbrandlist;

    public MyCaradapter(Context context,ArrayList<Car_brand_Model>carbrandlist){
        this.context=context;
        this.carbrandlist=carbrandlist;

    }

    @Override
    public int getCount() {
        return carbrandlist.size();
    }

    @Override
    public Object getItem(int position) {
        return carbrandlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.carbrand_design,parent,false);
        }
        ImageView imageView=convertView.findViewById(R.id.car_brand_image);
        TextView textView=convertView.findViewById(R.id.car_brand_name);

        Car_brand_Model car_brand_model=carbrandlist.get(position);

        imageView.setImageResource(car_brand_model.getCar_brand_image());
        textView.setText(car_brand_model.getCar_brand_name());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,Carlist.class);
                i.putExtra("position",position);
                context.startActivity(i);
            }
        });

        return convertView;
    }
}
