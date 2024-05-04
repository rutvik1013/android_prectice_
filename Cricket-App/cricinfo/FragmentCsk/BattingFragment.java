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

import com.example.cricinfo.Adapters.PlayerBattingAdapter;
import com.example.cricinfo.CricModel.Player_Batting_model;
import com.example.cricinfo.R;

import java.util.ArrayList;

public class BattingFragment extends Fragment {

    RecyclerView battingrecyclerview;
    private ArrayList<Player_Batting_model>battingplayerlist;


    public BattingFragment() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_batting, container, false);

        Intent i=getActivity().getIntent();
        int position=i.getIntExtra("position",102);

        battingplayerlist=new ArrayList<>();

        battingrecyclerview=view.findViewById(R.id.batting_recycler);

        battingrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (position==0){
            battingplayerlist.add(new Player_Batting_model("MS Dhoni","Matches","Innings","Runs","Balls","Highest","Average","Strike Rate","90","144","4876","8248","224","38.09","59.12","350","297","10773","12303","183","50.58","87.56","98","85","1617","1282","56","37.6","126.13","259","225","5178","3776","84","39.53","137.13"));
        }
        if (position==1){
            battingplayerlist.add(new Player_Batting_model("Suresh Raina","Matches","Innings","Runs","Balls","Highest","Average","Strike Rate","18","31","768","1445","120","26.48","53.15","226","194","5615","6005","116","35.31","93.51","78","66","1604","1190","101","29.16","134.79","205","200","5528","4043","100","32.42","136.72"));
        }
        if (position==2){
            battingplayerlist.add(new Player_Batting_model("Ruturaj Giakwad","Matches","Innings","Runs","Balls","Highest","Average","Strike Rate","0","0","0","0","0","0","0","6","6","115","157","71","19.17","73.25","19","17","500","357","123","35.71","140.06","61","60","2244","1625","108","42.34","138.09"));
        }
        if (position==3){
            battingplayerlist.add(new Player_Batting_model("Ajinkya Rahane","Matches","Innings","Runs","Balls","Highest","Average","Strike Rate","85","144","5077","10256","188","38.46","49.5","90","87","2962","3767","111","35.26","78.63","20","20","375","331","61","20.83","113.29","181","167","4570","3703","105","30.47","123.47"));
        }
        if (position==4){
            battingplayerlist.add(new Player_Batting_model("Ravindra Jadeja","Matches","Innings","Runs","Balls","Highest","Average","Strike Rate","72","105","3036","5437","175","36.14","55.84","197","132","2756","3240","87","32.42","85.06","66","36","480","383","46","22.86","125.33","235","179","2849","2212","62","27.39","128.8"));
        }
        if (position==5){
            battingplayerlist.add(new Player_Batting_model("Rachin Ravindra","Matches","Innings","Runs","Balls","Highest","Average","Strike Rate","7","14","519","1053","240","39.92","49.29","25","21","820","759","123","41.0","108.04","20","18","214","160","68","16.46","133.75","7","7","133","81","46","19.0","164.2"));
        }
        if (position==6){
            battingplayerlist.add(new Player_Batting_model("Shivam Dube","Matches","Innings","Runs","Balls","Highest","Average","Strike Rate","0","0","0","0","0","0","0","1","1","9","6","9","9.0","150.0","21","14","276","190","63","39.43","145.26","60","56","1456","883","95","32.36","148.12"));
        }
        if (position==7){
            battingplayerlist.add(new Player_Batting_model("Devon Conway","Matches","Innings","Runs","Balls","Highest","Average","Strike Rate","20","37","1497","2981","200","41.58","50.22","32","31","1246","1388","152","44.5","89.77","46","42","1338","1037","99","39.35","129.03","23","22","924","654","92","48.63","141.28"));
        }
        if (position==8){
            battingplayerlist.add(new Player_Batting_model("Deepak Chahar","Matches","Innings","Runs","Balls","Highest","Average","Strike Rate","0","0","0","0","0","0","0","13","9","203","207","69","33.83","98.07","25","7","53","28","31","26.5","189.29","80","13","80","59","39","11.43","135.59"));
        }
        if (position==9){
            battingplayerlist.add(new Player_Batting_model("Shardul Thakur","Matches","Innings","Runs","Balls","Highest","Average","Strike Rate","11","18","331","522","67","19.47","63.41","47","25","329","313","50","17.32","105.11","25","6","69","38","22","23.0","181.58","90","34","286","204","68","11.92","140.2"));
        }
        if (position==10){
            battingplayerlist.add(new Player_Batting_model("Mitchell Santner","Matches","Innings","Runs","Balls","Highest","Average","Strike Rate","26","35","804","1858","126","24.36","43.27","104","78","1355","1485","67","27.65","91.25","100","68","650","532","77","16.25","122.18","15","7","56","54","22","18.67","103.7"));
        }


        PlayerBattingAdapter adapter=new PlayerBattingAdapter(getActivity(),battingplayerlist);
        battingrecyclerview.setAdapter(adapter);

        return view;


    }
}