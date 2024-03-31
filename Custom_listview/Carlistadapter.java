package com.example.customlist_car;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;

import java.util.ArrayList;

public class Carlistadapter extends BaseAdapter
{
    private Context context;
    private ArrayList<Car_list_model>carlist;

    public Carlistadapter(Context context,ArrayList<Car_list_model>carlist){
        this.context=context;
        this.carlist=carlist;

    }

    @Override
    public int getCount() {
        return carlist.size();
    }

    @Override
    public Object getItem(int position) {
        return carlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.carlistdesign,parent,false);

        }
        ImageView imgcar=convertView.findViewById(R.id.car_list_image);
        TextView txtcarname=convertView.findViewById(R.id.car_name_text);
        TextView txtcarprice=convertView.findViewById(R.id.car_price_text);

        Car_list_model car_list_model=carlist.get(position);

        imgcar.setImageResource(car_list_model.getCar_image());
        txtcarname.setText(car_list_model.getCar_name());
        txtcarprice.setText(car_list_model.getCar_price());

        return convertView;


    }
}
