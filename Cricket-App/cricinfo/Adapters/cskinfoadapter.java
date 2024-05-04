package com.example.cricinfo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricinfo.CricModel.CskpagerModel;
import com.example.cricinfo.CricModel.Fragment_Csk_Model;
import com.example.cricinfo.R;
import com.github.siyamed.shapeimageview.CircularImageView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class cskinfoadapter extends RecyclerView.Adapter<cskinfoview>
{
private Context context;
private ArrayList<CskpagerModel>cskinfolist;

public cskinfoadapter(Context context,ArrayList<CskpagerModel>cskinfolist){
    this.context=context;
    this.cskinfolist=cskinfolist;
}

    @NonNull
    @Override
    public cskinfoview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.info_csk_design,parent,false);
        cskinfoview cskinfoview=new cskinfoview(view);
        return cskinfoview;
    }

    @Override
    public void onBindViewHolder(@NonNull cskinfoview holder, int position) {
    CskpagerModel model=cskinfolist.get(position);

        holder.csk_player_info_image.setImageResource(model.getC_image());
        holder.txt_csk_player_info_name.setText(model.getC_name());
        holder.txt_csk_player_info_country.setText(model.getC_country());
        holder.txt_csk_player_info_born_date.setText(model.getBorn());
        holder.txt_csk_player_born_place.setText(model.getBirth_place());
        holder.getTxt_csk_player_info_nikname.setText(model.getNickname());
        holder.txt_csk_player_info_role.setText(model.getRole());
        holder.txt_csk_player_info_batting_style.setText(model.getBatting_style());
        holder.txt_bowling_style.setText(model.getBowling_style());
    }

    @Override
    public int getItemCount() {
        return cskinfolist.size();
    }
}
class cskinfoview extends RecyclerView.ViewHolder{

    CircularImageView csk_player_info_image;
    TextView txt_csk_player_info_name;
    TextView txt_csk_player_info_country;
    TextView txt_csk_player_info_born_date;
    TextView txt_csk_player_born_place;
    TextView getTxt_csk_player_info_nikname;
    TextView txt_csk_player_info_role;
    TextView txt_csk_player_info_batting_style;
    TextView txt_bowling_style;

    public cskinfoview(@NonNull View itemView) {
        super(itemView);

        csk_player_info_image=itemView.findViewById(R.id.csk_player_info_image);
        txt_csk_player_info_name=itemView.findViewById(R.id.txt_csk_player_info_name);
        txt_csk_player_info_country=itemView.findViewById(R.id.txt_csk_player_info_country);
        txt_csk_player_info_born_date=itemView.findViewById(R.id.txt_born_date);
        txt_csk_player_born_place=itemView.findViewById(R.id.txt_born_place);
        getTxt_csk_player_info_nikname=itemView.findViewById(R.id.Txt_Nickname);
        txt_csk_player_info_role=itemView.findViewById(R.id.TXT_role);
        txt_csk_player_info_batting_style=itemView.findViewById(R.id.TXT_Battingstyle);
        txt_bowling_style=itemView.findViewById(R.id.TXT_Bowlingstyle);
    }
}