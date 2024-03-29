package com.example.ipl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;

import java.util.ArrayList;

public class RcbAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<rcb_model>rcblist;

    public RcbAdapter(Context context,ArrayList<rcb_model>rcblist)
    {
        this.context=context;
        this.rcblist=rcblist;
    }

    @Override
    public int getCount() {
        return rcblist.size();
    }

    @Override
    public Object getItem(int position) {
        return rcblist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
                convertView= LayoutInflater.from(context).inflate(R.layout.rcb_design,parent,false);

        }
        CircularImageView imageView=convertView.findViewById(R.id.rcb_player_image);
        TextView rcbname=convertView.findViewById(R.id.rcb_player_text);

        rcb_model model=rcblist.get(position);

        imageView.setImageResource(model.getRcb_image());
        rcbname.setText(model.getRcb_player_name());

        return convertView;
    }
}
