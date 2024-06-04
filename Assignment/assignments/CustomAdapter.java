package com.example.assignments;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Custommodel> list;
    private ArrayList<Custommodel> filteredList;


    public CustomAdapter(Context context, ArrayList<Custommodel> list) {
        this.context = context;
        this.list = list;
        this.filteredList = list;
    }

    @Override
    public int getCount() {
        return filteredList.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.design, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.imgcustom);
        TextView textView = convertView.findViewById(R.id.txt_name_custom);

        Custommodel custommodel = filteredList.get(position);

        imageView.setImageResource(custommodel.getImage());
        textView.setText(custommodel.getName());

        return convertView;
    }
    public void filterList(ArrayList<Custommodel>filteredList){
        this.list=filteredList;
        notifyDataSetChanged();
    }


}
