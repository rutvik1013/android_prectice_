package com.example.cricinfo.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricinfo.CricActivity.CskListActivity;
import com.example.cricinfo.CricModel.Fragment_Csk_Model;
import com.example.cricinfo.R;
import com.github.siyamed.shapeimageview.CircularImageView;

import java.util.ArrayList;

public class Fragment_Csk_adapter extends RecyclerView.Adapter<cskView> {
    private Context context;
    private ArrayList<Fragment_Csk_Model> csklist;

    public Fragment_Csk_adapter(Context context, ArrayList<Fragment_Csk_Model> csklist) {
        this.context = context;
        this.csklist = csklist;

    }

    @NonNull
    @Override
    public cskView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(context).inflate(R.layout.fragment_csk_design,parent,false);
       cskView cskView=new cskView(view);
       return cskView;
    }

    @Override
    public void onBindViewHolder(@NonNull cskView holder, @SuppressLint("RecyclerView") int position) {
        Fragment_Csk_Model fragment_csk_model=csklist.get(position);

        holder.csk_player_image.setImageResource(fragment_csk_model.getCsk_player_image());
        holder.txt_csk_player_name.setText(fragment_csk_model.getCsk_player_name());
        holder.txt_csk_player_role.setText(fragment_csk_model.getCsk_player_role());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent i=new Intent(context,CskListActivity.class);
              i.putExtra("position",position);
              context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return csklist.size();
    }
}
class cskView extends RecyclerView.ViewHolder{

   CircularImageView csk_player_image;
    TextView txt_csk_player_name;
    TextView txt_csk_player_role;
    public cskView(@NonNull View itemView) {
        super(itemView);

        csk_player_image=itemView.findViewById(R.id.csk_player_image);
        txt_csk_player_name=itemView.findViewById(R.id.txt_csk_player_name);
        txt_csk_player_role=itemView.findViewById(R.id.txt_csk_player_role);
    }
}
