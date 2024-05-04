package com.example.cricinfo.FragmentCsk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cricinfo.Adapters.PlayerBowlingAdapter;
import com.example.cricinfo.CricModel.Player_Bowling_Model;
import com.example.cricinfo.R;

import java.util.ArrayList;


public class BowlingFragment extends Fragment {

    private ArrayList<Player_Bowling_Model>bowlinglist;
    RecyclerView bowlingrecyclerview;


    public BowlingFragment() {
        // Required empty public constructor
    }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_bowling, container, false);

        bowlingrecyclerview=view.findViewById(R.id.baowling_recyclerview);
        bowlingrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        bowlinglist=new ArrayList<>();

        Intent i=getActivity().getIntent();
        int position=i.getIntExtra("position",103);

        if (position==0){
            bowlinglist.add(new Player_Bowling_Model("MS Dhoni","Matches","Innings","Balls","Runs","Maidens","Wickets","Avg","Eco","4W","5W","90","7","96","67","1","0","0.0","4.19","0","0","350","2","36","31","0","1","31.0","5.17","0","0","98","0","0","0","0","0","0","0","0","0","260","0","0","0","0","0","0","0","0","0"));
        }
        if (position==1){
            bowlinglist.add(new Player_Bowling_Model("Suresh Raina","Matches","Innings","Balls","Runs","Maidens","Wickets","Avg","Eco","4W","5W","18","22","1041","603","22","13","46.38","3.48","0","0","226","101","2126","1811","5","36","50.31","5.11","0","0","78","27","349","442","0","13","34.0","7.6","0","0","205","69","908","1118","0","25","44.72","7.39","0","0"));
        }
        if (position==2){
            bowlinglist.add(new Player_Bowling_Model("Ruturaj Giakwad","Matches","Innings","Balls","Runs","Maidens","Wickets","Avg","Eco","4W","5W","0","0","0","0","0","0","0","0","0","0","6","0","0","0","0","0","0","0","0","0","19","0","0","0","0","0","0","0","0","0","62","0","0","0","0","0","0","0","0","0"));

        }
        if (position==3){
            bowlinglist.add(new Player_Bowling_Model("Ajinkya Rahane","Matches","Innings","Balls","Runs","Maidens","Wickets","Avg","Eco","4W","5W","85","0","0","0","0","0","0","0","0","0","90","0","0","0","0","0","0","0","0","0","20","0","0","0","0","0","0","0","0","0","182","1","6","5","0","1","5.0","5.0","0","0"));

        }
        if (position==4){
            bowlinglist.add(new Player_Bowling_Model("Ravindra Jadeja","Matches","Innings","Balls","Runs","Maidens","Wickets","Avg","Eco","4W","5W","72","136","17233","7096","706","294","24.14","2.47","13","13","197","189","9750","7936","56","220","36.07","4.88","7","2","66","64","1272","1506","4","53","28.42","7.1","0","0","236","207","3751","4751","2","157","30.26","7.6","3","1"));
        }
        if (position==5){
            bowlinglist.add(new Player_Bowling_Model("Rachin Ravindra","Matches","Innings","Balls","Runs","Maidens","Wickets","Avg","Eco","4W","5W","7","11","719","331","28","10","33.1","2.76","0","0","25","20","835","839","0","18","46.61","6.03","1","0","20","13","222","247","0","11","22.35","6.68","0","0","7","2","12","7","0","0","0.0","3.5","0","0"));
        }
        if (position==6){
            bowlinglist.add(new Player_Bowling_Model("Shivam Dube","Matches","Innings","Balls","Runs","Maidens","Wickets","Avg","Eco","4W","5W","0","0","0","0","0","0","0","0","0","0","1","1","47","68","0","0","0.0","8.68","0","0","21","19","219","360","0","8","45.0","8.68","0","0","61","14","112","180","0","5","36.0","9.64","0","0"));

        }
        if (position==7){
            bowlinglist.add(new Player_Bowling_Model("Devon Conway","Matches","Innings","Balls","Runs","Maidens","Wickets","Avg","Eco","4W","5W","20","0","0","0","0","0","0","0","0","0","32","0","0","0","0","0","0","0","0","0","46","0","0","0","0","0","0","0","0","0","23","0","0","0","0","0","0","0","0","0"));

        }
        if (position==8){
            bowlinglist.add(new Player_Bowling_Model("Deepak Chahar","Matches","Innings","Balls","Runs","Maidens","Wickets","Avg","Eco","4W","5W","0","0","0","0","0","0","0","0","0","0","13","12","510","489","5","16","30.56","5.75","0","0","25","25","540","747","2","31","24.1","8.3","0","1","81","81","1669","2221","6","77","28.84","7.98","2","0"));

        }
        if (position==9){
            bowlinglist.add(new Player_Bowling_Model("Shardul Thakur","Matches","Innings","Balls","Runs","Maidens","Wickets","Avg","Eco","4W","5W","11","19","1449","880","36","31","28.39","3.64","1","1","47","46","1940","2014","10","65","30.98","6.23","3","0","25","24","506","772","0","33","23.39","9.15","1","0","91","88","1782","2739","3","91","30.1","9.22","1","0"));

        }
        if (position==10){
             bowlinglist.add(new Player_Bowling_Model("Mitchell Santner","Matches","Innings","Balls","Runs","Maidens","Wickets","Avg","Eco","4W","5W","26","44","4553","2080","164","53","39.25","2.74","0","0","104","99","4875","3960","18","107","37.01","4.87","0","2","100","98","2072","2457","2","111","22.14","7.11","3","0","15","15","312","358","0","13","27.54","6.88","0","0"));

        }

        PlayerBowlingAdapter adapter=new PlayerBowlingAdapter(getActivity(),bowlinglist);
        bowlingrecyclerview.setAdapter(adapter);



        return  view;
    }
}