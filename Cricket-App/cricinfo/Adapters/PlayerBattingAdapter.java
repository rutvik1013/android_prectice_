package com.example.cricinfo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cricinfo.CricModel.Player_Batting_model;
import com.example.cricinfo.R;
import java.util.ArrayList;

public class PlayerBattingAdapter extends RecyclerView.Adapter<MyPlayerBattingView> {
    private Context context;
    private ArrayList<Player_Batting_model> playerbattinglist;

    public PlayerBattingAdapter(Context context, ArrayList<Player_Batting_model> playerbattinglist) {
        this.context = context;
        this.playerbattinglist = playerbattinglist;
    }

    @NonNull
    @Override
    public MyPlayerBattingView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.batting_fragment_design, parent, false);
        return new MyPlayerBattingView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPlayerBattingView holder, int position) {
        Player_Batting_model player_batting_model = playerbattinglist.get(position);


        holder.txt_player_name.setText(player_batting_model.getPlayerName());
        holder.player_txt_matches.setText(player_batting_model.getMatches());
        holder.player_txt_innings.setText(player_batting_model.getInnings());
        holder.player_txt_runs.setText(player_batting_model.getRuns());
        holder.player_txt_balls.setText(player_batting_model.getBalls());
        holder.player_txt_highest.setText(player_batting_model.getHighest());
        holder.player_txt_average.setText(player_batting_model.getAverage());
        holder.player_txt_strike_rate.setText(player_batting_model.getStrikeRate());
        holder.player_test_matches_txt.setText(player_batting_model.getTestMatches());
        holder.player_test_innings_txt.setText(player_batting_model.getTestInnings());
        holder.player_test_runs_txt.setText(player_batting_model.getTestRuns());
        holder.player_test_balls_txt.setText(player_batting_model.getTestBalls());
        holder.player_test_highest_txt.setText(player_batting_model.getTestHighest());
        holder.player_test_average_txt.setText(player_batting_model.getTestAverage());
        holder.player_test_strike_rate_txt.setText(player_batting_model.getTestStrikeRate());
        holder.txt_player_odi_matches.setText(player_batting_model.getOdiMatches());
        holder.txt_player_odi_innings.setText(player_batting_model.getOdiInnings());
        holder.txt_player_odi_runs.setText(player_batting_model.getOdiRuns());
        holder.txt_player_odi_balls.setText(player_batting_model.getOdiBalls());
        holder.txt_player_odi_highest.setText(player_batting_model.getOdiHighest());
        holder.txt_player_odi_average.setText(player_batting_model.getOdiAverage());
        holder.txt_player_odi_strike_rate.setText(player_batting_model.getOdiStrikeRate());
        holder.text_player_t20_matches.setText(player_batting_model.getT20Matches());
        holder.text_player_t20_innings.setText(player_batting_model.getT20Innings());
        holder.text_player_t20_runs.setText(player_batting_model.getT20Runs());
        holder.text_player_t20_balls.setText(player_batting_model.getT20Balls());
        holder.text_player_t20_highest.setText(player_batting_model.getT20Highest());
        holder.text_player_t20_average.setText(player_batting_model.getT20Average());
        holder.text_player_t20_strike_rate.setText(player_batting_model.getT20StrikeRate());
        holder.text_view_player_ipl_matches.setText(player_batting_model.getIplMatches());
        holder.text_view_player_ipl_innings.setText(player_batting_model.getIplInnings());
        holder.text_view_player_ipl_runs.setText(player_batting_model.getIplRuns());
        holder.text_view_player_ipl_balls.setText(player_batting_model.getIplBalls());
        holder.text_view_player_ipl_highest.setText(player_batting_model.getIplHighest());
        holder.text_view_player_ipl_average.setText(player_batting_model.getIplAverage());
        holder.text_view_player_ipl_strike_rate.setText(player_batting_model.getIplStrikeRate());

    }

    @Override
    public int getItemCount() {
        return playerbattinglist.size();
    }
}

class MyPlayerBattingView extends RecyclerView.ViewHolder {
    TextView txt_player_name;
    TextView test_txt_player_career;
    TextView odi_txt_player_career;
    TextView t20_txt_player_career;
    TextView ipl_txt_player_career;
    TextView player_txt_matches;
    TextView player_txt_innings;
    TextView player_txt_runs;
    TextView player_txt_balls;
    TextView player_txt_highest;
    TextView player_txt_average;
    TextView player_txt_strike_rate;
    TextView player_test_matches_txt;
    TextView player_test_innings_txt;
    TextView player_test_runs_txt;
    TextView player_test_balls_txt;
    TextView player_test_highest_txt;
    TextView player_test_average_txt;
    TextView player_test_strike_rate_txt;
    TextView txt_player_odi_matches;
    TextView txt_player_odi_innings;
    TextView txt_player_odi_runs;
    TextView txt_player_odi_balls;
    TextView txt_player_odi_highest;
    TextView txt_player_odi_average;
    TextView txt_player_odi_strike_rate;
    TextView text_player_t20_matches;
    TextView text_player_t20_innings;
    TextView text_player_t20_runs;
    TextView text_player_t20_balls;
    TextView text_player_t20_highest;
    TextView text_player_t20_average;
    TextView text_player_t20_strike_rate;
    TextView text_view_player_ipl_matches;
    TextView text_view_player_ipl_innings;
    TextView text_view_player_ipl_runs;
    TextView text_view_player_ipl_balls;
    TextView text_view_player_ipl_highest;
    TextView text_view_player_ipl_average;
    TextView text_view_player_ipl_strike_rate;
    public MyPlayerBattingView(@NonNull View itemView) {
        super(itemView);
        txt_player_name = itemView.findViewById(R.id.txt_player_batting_frag_name);
        player_txt_matches = itemView.findViewById(R.id.txt_player_matches);
        player_txt_innings = itemView.findViewById(R.id.txt_player_innings);
        player_txt_runs = itemView.findViewById(R.id.txt_player_runs);
        player_txt_balls = itemView.findViewById(R.id.txt_player_balls);
        player_txt_highest = itemView.findViewById(R.id.test_txt_player_highest);
        player_txt_average = itemView.findViewById(R.id.txt_player_average);
        player_txt_strike_rate = itemView.findViewById(R.id.txt_player_strike_rate);
        test_txt_player_career = itemView.findViewById(R.id.txt_player_test_carrer);
        odi_txt_player_career = itemView.findViewById(R.id.txt_player_odi_carrer);
        t20_txt_player_career = itemView.findViewById(R.id.txt_player_t20_carrer);
        ipl_txt_player_career = itemView.findViewById(R.id.txt_player_ipl_carrer);
        player_test_matches_txt=itemView.findViewById(R.id.test_txt_player_matches);
        player_test_innings_txt=itemView.findViewById(R.id.test_txt_player_innings);
        player_test_runs_txt=itemView.findViewById(R.id.test_txt_player_runs);
        player_test_balls_txt=itemView.findViewById(R.id.test_txt_player_balls);
        player_test_highest_txt=itemView.findViewById(R.id.Test_txt_player_highest);
        player_test_average_txt=itemView.findViewById(R.id.test_txt_player_average);
        player_test_strike_rate_txt=itemView.findViewById(R.id.test_txt_player_strike_rate);
        txt_player_odi_matches=itemView.findViewById(R.id.odi_txt_player_matches);
        txt_player_odi_innings=itemView.findViewById(R.id.odi_txt_player_innings);
        txt_player_odi_runs=itemView.findViewById(R.id.odi_txt_player_runs);
        txt_player_odi_balls=itemView.findViewById(R.id.odi_txt_player_balls);
        txt_player_odi_highest=itemView.findViewById(R.id.odi_txt_player_highest);
        txt_player_odi_average=itemView.findViewById(R.id.odi_txt_player_average);
        txt_player_odi_strike_rate=itemView.findViewById(R.id.odi_txt_player_strike_rate);
        text_player_t20_matches=itemView.findViewById(R.id.t20_txt_player_matches);
        text_player_t20_innings=itemView.findViewById(R.id.t20_txt_player_innings);
        text_player_t20_runs=itemView.findViewById(R.id.t20_txt_player_runs);
        text_player_t20_balls=itemView.findViewById(R.id.t20_txt_player_balls);
        text_player_t20_highest=itemView.findViewById(R.id.t20_txt_player_highest);
        text_player_t20_average=itemView.findViewById(R.id.t20_txt_player_average);
        text_player_t20_strike_rate=itemView.findViewById(R.id.t20_txt_player_strike_rate);
        text_view_player_ipl_matches=itemView.findViewById(R.id.ipl_txt_player_matches);
        text_view_player_ipl_innings=itemView.findViewById(R.id.ipl_txt_player_innings);
        text_view_player_ipl_runs=itemView.findViewById(R.id.ipl_txt_player_runs);
        text_view_player_ipl_balls=itemView.findViewById(R.id.ipl_txt_player_balls);
        text_view_player_ipl_highest=itemView.findViewById(R.id.ipl_txt_player_highest);
        text_view_player_ipl_average=itemView.findViewById(R.id.ipl_txt_player_average);
        text_view_player_ipl_strike_rate=itemView.findViewById(R.id.ipl_txt_player_strike_rate);
    }
}
