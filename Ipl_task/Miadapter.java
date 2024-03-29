package com.example.ipl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Miadapter extends ArrayAdapter<Mi_Model>
{
    private Context mcontext;
    private ArrayList<Mi_Model>Mmilist;

    public Miadapter(Context context,ArrayList<Mi_Model>milist){
        super(context,0,milist);
        mcontext=context;
        Mmilist=milist;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem =convertView;
        if (listItem==null){
            listItem= LayoutInflater.from(mcontext).inflate(R.layout.mi_player_design,parent,false);

        }
        Mi_Model mi_model=Mmilist.get(position);

        ImageView miimage=listItem.findViewById(R.id.mi_player_image);
        miimage.setImageResource(mi_model.getMi_image());

        TextView mitxt=listItem.findViewById(R.id.mi_player_text);
        mitxt.setText(mi_model.getMi_player_name());

        return listItem;

    }
}
