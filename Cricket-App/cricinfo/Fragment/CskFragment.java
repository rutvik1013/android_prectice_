package com.example.cricinfo.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cricinfo.Adapters.Fragment_Csk_adapter;
import com.example.cricinfo.CricModel.Fragment_Csk_Model;
import com.example.cricinfo.FragmentCsk.InfoFragment;
import com.example.cricinfo.R;

import java.util.ArrayList;


public class CskFragment extends Fragment {

    RecyclerView cskrecyclerview;
    private ArrayList<Fragment_Csk_Model>csklist;


    public CskFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_csk, container, false);

        cskrecyclerview=view.findViewById(R.id.csk_recyclerview);

        cskrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));


        csklist=new ArrayList<>();

        csklist.add(new Fragment_Csk_Model(R.drawable.dhoni,"MS Dhoni","WK-Batter"));
        csklist.add(new Fragment_Csk_Model(R.drawable.suresh,"Suresh Raina","Batter"));
        csklist.add(new Fragment_Csk_Model(R.drawable.ruturaj,"Ruturaj Gaikwad (C)","Batter"));
        csklist.add(new Fragment_Csk_Model(R.drawable.rahane,"Ajinkya Rahane","Batter"));
        csklist.add(new Fragment_Csk_Model(R.drawable.jadeja,"Ravindra Jadeja","Bowling Allrounder"));
        csklist.add(new Fragment_Csk_Model(R.drawable.rachin,"Rachin Ravindra","Batting Allrounder"));
        csklist.add(new Fragment_Csk_Model(R.drawable.shivam,"Shivam Dube","Bowling Allrounder"));
        csklist.add(new Fragment_Csk_Model(R.drawable.devon,"Devon Conway","Batter"));
        csklist.add(new Fragment_Csk_Model(R.drawable.deepak,"Deepak Chahar","Bowler"));
        csklist.add(new Fragment_Csk_Model(R.drawable.shardul,"Shardul Thakur","Bowler"));
        csklist.add(new Fragment_Csk_Model(R.drawable.santner,"Mitchell Santner","Bowling Allrounder"));


        Fragment_Csk_adapter adapter=new Fragment_Csk_adapter(getActivity(),csklist);
        cskrecyclerview.setAdapter(adapter);

        return view;
    }
}