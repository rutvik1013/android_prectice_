package com.example.ipl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class cskadapter extends BaseAdapter {

    private Context context;
    private ArrayList<cskmodel>csklist;

    public cskadapter(Context context,ArrayList<cskmodel>csklist){
        this.context=context;
        this.csklist=csklist;

    }

    @Override
    public int getCount() {
        return csklist.size();
    }

    @Override
    public Object getItem(int position) {
        return csklist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.csklist,parent,false);

        }
        ImageView cskimage=convertView.findViewById(R.id.csk_player_img);
        TextView csktextname=convertView.findViewById(R.id.csk_txt_name);

        cskmodel cskplayer=csklist.get(position);


        cskimage.setImageResource(cskplayer.getImage());
        csktextname.setText(cskplayer.getName());

        return convertView;

    }
}
