package com.example.customlistview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customlistview.R;
import com.example.customlistview.carmodel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public  class carAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<carmodel> carList;
    private ArrayList<carmodel> selectedCars;

    public carAdapter(Context context, ArrayList<carmodel> carList, ArrayList<carmodel> selectedCars) {
        this.context = context;
        this.carList = carList;
        this.selectedCars = selectedCars != null ? selectedCars : new ArrayList<>();
    }

    @Override
    public int getCount() {
        return carList.size();
    }

    @Override
    public Object getItem(int position) {
        return carList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.car_design, parent, false);
        }

        carmodel car = carList.get(position);
        CircleImageView carImage = convertView.findViewById(R.id.car_image);
        TextView carName = convertView.findViewById(R.id.car_text_name);
        TextView carPrice = convertView.findViewById(R.id.car_text_price);

        carImage.setImageResource(car.getImage());
        carName.setText(car.getCar_name());
        carPrice.setText(car.getCar_price());

        // Handling selection
        if (selectedCars.contains(car)) {
            convertView.setBackgroundColor(Color.LTGRAY); // Or any color you want to highlight the selected item
        } else {
            convertView.setBackgroundColor(Color.WHITE); // Default color for unselected
        }

        convertView.setOnClickListener(v -> {
            if (selectedCars.contains(car)) {
                selectedCars.remove(car);  // Remove car from the selected list if it's already selected
                Toast.makeText(context, car.getCar_name() + " Deselect", Toast.LENGTH_SHORT).show();
            } else {
                if (selectedCars.size() < 5) {
                    selectedCars.add(car);  // Add car to the selected list if not already selected
                    Toast.makeText(context, car.getCar_name() + " Selected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "You can only select 5 cars", Toast.LENGTH_SHORT).show();
                }
            }
            notifyDataSetChanged(); // Refresh the view
        });

        return convertView;
    }
}