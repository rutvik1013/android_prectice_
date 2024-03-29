package com.example.spinner_cutom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<Model>fruitlist;

    public MyAdapter(Context context,ArrayList<Model>fruitlist){
        this.context=context;
        this.fruitlist=fruitlist;
    }

    @Override
    public int getCount() {
        return fruitlist.size();
    }

    @Override
    public Object getItem(int position) {
        return fruitlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.spinner_list,parent,false);

        }
        ImageView imgfruit=convertView.findViewById(R.id.img_spinner);
        TextView txt_name_fruit=convertView.findViewById(R.id.txtname);
        TextView txt_banifits=convertView.findViewById(R.id.txtbanifits);

        Model model=fruitlist.get(position);

        imgfruit.setImageResource(model.getImage());
        txt_name_fruit.setText(model.getName());
        txt_banifits.setText(model.getBanifits());

        return convertView;
    }
}
