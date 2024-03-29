package com.example.ipl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;

import java.util.ArrayList;

public class DcAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<Dc_Model>dclist;

    public DcAdapter(Context context,ArrayList<Dc_Model>dclist){
        this.context=context;
        this.dclist=dclist;

    }

    @Override
    public int getCount() {
        return dclist.size();
    }

    @Override
    public Object getItem(int position) {
        return dclist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.dc_design,parent,false);
        }
        CircularImageView imageView=convertView.findViewById(R.id.dc_player_image);
        TextView txtdcname=convertView.findViewById(R.id.dc_player_text);

        Dc_Model model=dclist.get(position);

        imageView.setImageResource(model.getDc_image());
        txtdcname.setText(model.getDc_player_name());

        return convertView;
    }
}
