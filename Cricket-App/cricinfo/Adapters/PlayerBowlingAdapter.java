package com.example.cricinfo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricinfo.CricModel.Player_Bowling_Model;
import com.example.cricinfo.R;

import java.util.ArrayList;

public class PlayerBowlingAdapter extends RecyclerView.Adapter<MyBowlingView>
{
    private Context context;
    private ArrayList<Player_Bowling_Model>bowlinglist;

    public PlayerBowlingAdapter(Context context,ArrayList<Player_Bowling_Model>bowlinglist){
        this.context=context;
        this.bowlinglist=bowlinglist;

    }

    @NonNull
    @Override
    public MyBowlingView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.bowling_fragment_design,parent,false);
        MyBowlingView myBowlingView=new MyBowlingView(view);

        return myBowlingView;
    }

    @Override
    public void onBindViewHolder(@NonNull MyBowlingView holder, int position) {
        Player_Bowling_Model player_bowling_model=bowlinglist.get(position);


        holder.txt_Player_bowling_name.setText(player_bowling_model.getPlayer_name());
       holder.txt_player_matches_bowling.setText(player_bowling_model.getMatches_());
       holder.player_test_txt_player_matches_bowling.setText(player_bowling_model.getTest_matches());
       holder.player_odi_txt_player_matches_bowling.setText(player_bowling_model.getOdi_matches());
       holder.player_t20_txt_player_matches_bowling.setText(player_bowling_model.getT20_matches());
       holder.player_ipl_txt_player_matches_bowling.setText(player_bowling_model.getIpl_matches());
       holder.txt_player_innings_bowling.setText(player_bowling_model.getInnings_());
       holder.txt_player_test_innings_bowling.setText(player_bowling_model.getTest_innings());
       holder.txt_player_odi_innings_bowling.setText(player_bowling_model.getOdi_innings());
       holder.txt_player_t20_innings_bowling.setText(player_bowling_model.getT20_innings());
       holder.txt_player_ipl_innings_bowling.setText(player_bowling_model.getIpl_innings());
       holder.text_player_balls_bowling.setText(player_bowling_model.getBalls_());
       holder.text_player_test_balls_bowling.setText(player_bowling_model.getTest_balls());
       holder.text_player_odi_balls_bowling.setText(player_bowling_model.getOdi_balls());
       holder.text_player_t20_balls_bowling.setText(player_bowling_model.getT20_balls());
       holder.text_player_ipl_balls_bowling.setText(player_bowling_model.getIpl_balls());
       holder.textView_player_runs.setText(player_bowling_model.getRuns_());
       holder.textView_player_test_runs_bowling.setText(player_bowling_model.getTest_runs());
       holder.textView_player_odi_runs_bowling.setText(player_bowling_model.getOdi_runs());
       holder.textView_player_t20_runs_bowling.setText(player_bowling_model.getT20_runs());
       holder.textView_player_ipl_runs_bowling.setText(player_bowling_model.getIpl_runs());
       holder.maiden_textview.setText(player_bowling_model.getMaidens());
       holder.test_maiden_textview.setText(player_bowling_model.getTest_maidens());
       holder.odi_maiden_textview.setText(player_bowling_model.getOdi_maidens());
       holder.t20_maiden_textview.setText(player_bowling_model.getT20_maidens());
       holder.ipl_maiden_textview.setText(player_bowling_model.getIpl_maidens());
       holder.textView_wickets.setText(player_bowling_model.getWickets());
       holder.textView_test_wickets.setText(player_bowling_model.getTest_Wickets());
       holder.textView_odi_wickets.setText(player_bowling_model.getOdi_wickets());
       holder.textView_t20_wickets.setText(player_bowling_model.getT20_wickets());
       holder.textView_ipl_wickets.setText(player_bowling_model.getIpl_wickets());
       holder.textv_avg.setText(player_bowling_model.getAvg());
       holder.textv_test_avg.setText(player_bowling_model.getTest_avg());
       holder.textv_odi_avg.setText(player_bowling_model.getOdi_avg());
       holder.textv_t20_avg.setText(player_bowling_model.getT20_avg());
       holder.textv_ipl_avg.setText(player_bowling_model.getIpl_avg());
       holder.economy_text.setText(player_bowling_model.getEconomy());
       holder.test_economy_text.setText(player_bowling_model.getTest_economy());
       holder.odi_economy_text.setText(player_bowling_model.getOdi_economy());
       holder.t20_economy_text.setText(player_bowling_model.getT20_economy());
       holder.ipl_economy_text.setText(player_bowling_model.getIpl_economy());
       holder.w4_txt.setText(player_bowling_model.getW4());
       holder.test_4w_txt.setText(player_bowling_model.getTest_w4());
       holder.odi_4w_txt.setText(player_bowling_model.getOdi_w4());
       holder.t20_4w_txt.setText(player_bowling_model.getT20_w4());
       holder.ipl_4w_txt.setText(player_bowling_model.getIpl_w4());
       holder.w5_text.setText(player_bowling_model.getW5());
       holder.test_w5_text.setText(player_bowling_model.getTest_w5());
       holder.odi_w5_text.setText(player_bowling_model.getOdi_w5());
       holder.t20_w5_text.setText(player_bowling_model.getT20_w5());
       holder.ipl_w5_text.setText(player_bowling_model.getIpl_w5());

    }

    @Override
    public int getItemCount() {
        return bowlinglist.size();
    }
}
class MyBowlingView extends RecyclerView.ViewHolder{

    TextView txt_Player_bowling_name;
    TextView txt_bowling_career;
    TextView txt_player_test_carrer_bowliong;
    TextView txt_player_odi_carrer_bowling;
    TextView txt_t20_carreer_bowling;
    TextView txt_ipl_career_bowling;
    TextView txt_player_matches_bowling;
    TextView player_test_txt_player_matches_bowling;
    TextView player_odi_txt_player_matches_bowling;
    TextView player_t20_txt_player_matches_bowling;
    TextView player_ipl_txt_player_matches_bowling;
    TextView txt_player_innings_bowling;
    TextView txt_player_test_innings_bowling;
    TextView txt_player_odi_innings_bowling;
    TextView txt_player_t20_innings_bowling;
    TextView txt_player_ipl_innings_bowling;
    TextView text_player_balls_bowling;
    TextView text_player_test_balls_bowling;
    TextView text_player_odi_balls_bowling;
    TextView text_player_t20_balls_bowling;
    TextView text_player_ipl_balls_bowling;
    TextView textView_player_runs;
    TextView textView_player_test_runs_bowling;
    TextView textView_player_odi_runs_bowling;
    TextView textView_player_t20_runs_bowling;
    TextView textView_player_ipl_runs_bowling;
    TextView maiden_textview;
    TextView test_maiden_textview;
    TextView odi_maiden_textview;
    TextView t20_maiden_textview;
    TextView ipl_maiden_textview;
    TextView textView_wickets;
    TextView textView_test_wickets;
    TextView textView_odi_wickets;
    TextView textView_t20_wickets;
    TextView textView_ipl_wickets;
    TextView textv_avg;
    TextView textv_test_avg;
    TextView textv_odi_avg;
    TextView textv_t20_avg;
    TextView textv_ipl_avg;
    TextView economy_text;
    TextView test_economy_text;
    TextView odi_economy_text;
    TextView t20_economy_text;
    TextView ipl_economy_text;
    TextView w4_txt;
    TextView test_4w_txt;
    TextView odi_4w_txt;
    TextView t20_4w_txt;
    TextView ipl_4w_txt;
    TextView w5_text;
    TextView test_w5_text;
    TextView odi_w5_text;
    TextView t20_w5_text;
    TextView ipl_w5_text;


    public MyBowlingView(@NonNull View itemView) {
        super(itemView);

        txt_Player_bowling_name=itemView.findViewById(R.id.txt_player_bowling_frag_name);
        txt_bowling_career=itemView.findViewById(R.id.txt_player_bowling_carrer);
        txt_player_test_carrer_bowliong=itemView.findViewById(R.id.txt_player_test_carrer_bowling);
        txt_player_odi_carrer_bowling=itemView.findViewById(R.id.txt_player_odi_carrer_bowling);
        txt_t20_carreer_bowling=itemView.findViewById(R.id.txt_player_t20_carrer_bowling);
        txt_ipl_career_bowling=itemView.findViewById(R.id.txt_player_ipl_carrer_bowling);
        txt_player_matches_bowling=itemView.findViewById(R.id.txt_player_matches_bowling);
        player_test_txt_player_matches_bowling=itemView.findViewById(R.id.test_txt_player_matches_bowling);
        player_odi_txt_player_matches_bowling=itemView.findViewById(R.id.odi_txt_player_matches_bowling);
        player_t20_txt_player_matches_bowling=itemView.findViewById(R.id.t20_txt_player_matches_bowling);
        player_ipl_txt_player_matches_bowling=itemView.findViewById(R.id.ipl_txt_player_matches_bowling);
        txt_player_innings_bowling=itemView.findViewById(R.id.txt_player_innings_bowling);
        txt_player_test_innings_bowling=itemView.findViewById(R.id.test_txt_player_innings_bowling);
        txt_player_odi_innings_bowling=itemView.findViewById(R.id.odi_txt_player_innings_bowling);
        txt_player_t20_innings_bowling=itemView.findViewById(R.id.t20_txt_player_innings_bowling);
        txt_player_ipl_innings_bowling=itemView.findViewById(R.id.ipl_txt_player_innings_bowling);
        text_player_balls_bowling=itemView.findViewById(R.id.txt_player_balls_bowling);
        text_player_test_balls_bowling=itemView.findViewById(R.id.test_txt_player_balls_bowling);
        text_player_odi_balls_bowling=itemView.findViewById(R.id.odi_txt_player_balls_bowling);
        text_player_t20_balls_bowling=itemView.findViewById(R.id.t20_txt_player_balls_bowling);
        text_player_ipl_balls_bowling=itemView.findViewById(R.id.ipl_txt_player_balls_bowling);
        textView_player_runs=itemView.findViewById(R.id.txt_player_runs_bowling);
        textView_player_test_runs_bowling=itemView.findViewById(R.id.test_txt_player_runs_bowling);
        textView_player_odi_runs_bowling=itemView.findViewById(R.id.odi_txt_player_runs_bowling);
        textView_player_t20_runs_bowling=itemView.findViewById(R.id.t20_txt_player_runs_bowling);
        textView_player_ipl_runs_bowling=itemView.findViewById(R.id.ipl_txt_player_runs_bowling);
        maiden_textview=itemView.findViewById(R.id.txt_player_maidens);
        test_maiden_textview=itemView.findViewById(R.id.test_txt_player_maidens);
        odi_maiden_textview=itemView.findViewById(R.id.odi_txt_player_maidens);
        t20_maiden_textview=itemView.findViewById(R.id.t20_txt_player_maidens);
        ipl_maiden_textview=itemView.findViewById(R.id.ipl_txt_player_maidens);
        textView_wickets=itemView.findViewById(R.id.txt_player_wickets);
        textView_test_wickets=itemView.findViewById(R.id.test_txt_player_wickets);
        textView_odi_wickets=itemView.findViewById(R.id.odi_txt_player_wickets);
        textView_t20_wickets=itemView.findViewById(R.id.t20_txt_player_wickets);
        textView_ipl_wickets=itemView.findViewById(R.id.ipl_txt_player_wickets);
        textv_avg=itemView.findViewById(R.id.txt_player_avg);
        textv_test_avg=itemView.findViewById(R.id.test_txt_player_avg);
        textv_odi_avg=itemView.findViewById(R.id.odi_txt_player_avg);
        textv_t20_avg=itemView.findViewById(R.id.t20_txt_player_avg);
        textv_ipl_avg=itemView.findViewById(R.id.ipl_txt_player_avg);
        economy_text=itemView.findViewById(R.id.txt_player_economy);
        test_economy_text=itemView.findViewById(R.id.test_txt_player_economy);
        odi_economy_text=itemView.findViewById(R.id.odi_txt_player_economy);
        t20_economy_text=itemView.findViewById(R.id.t20_txt_player_economy);
        ipl_economy_text=itemView.findViewById(R.id.ipl_txt_player_economy);
        w4_txt=itemView.findViewById(R.id.txt_player_4w);
        test_4w_txt=itemView.findViewById(R.id.test_txt_player_4w);
        odi_4w_txt=itemView.findViewById(R.id.odi_txt_player_4w);
        t20_4w_txt=itemView.findViewById(R.id.t20_txt_player_4w);
        ipl_4w_txt=itemView.findViewById(R.id.ipl_txt_player_4w);
        w5_text=itemView.findViewById(R.id.txt_player_5w);
        test_w5_text=itemView.findViewById(R.id.test_txt_player_5w);
        odi_w5_text=itemView.findViewById(R.id.odi_txt_player_5w);
        t20_w5_text=itemView.findViewById(R.id.t20_txt_player_5w);
        ipl_w5_text=itemView.findViewById(R.id.ipl_txt_player_5w);

    }



}
