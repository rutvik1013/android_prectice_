package com.example.cricinfo.FragmentCsk;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cricinfo.Adapters.cskinfoadapter;
import com.example.cricinfo.CricModel.CskpagerModel;
import com.example.cricinfo.R;

import java.util.ArrayList;


public class InfoFragment extends Fragment {


    RecyclerView csk_info_recyclerview;
    private ArrayList<CskpagerModel>csk_info_list;

    public InfoFragment() {
        // Required empty public constructor
    }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_info, container, false);




        csk_info_recyclerview=view.findViewById(R.id._csk_info_recyclerview);

        csk_info_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        csk_info_list=new ArrayList<>();

        Intent i=getActivity().getIntent();
        int position=i.getIntExtra("position",101);


       if (position==0){
           csk_info_list.add(new CskpagerModel(R.drawable.dhoni,"MS Dhoni","India","July 07,1981 (42 Years)","Ranchi,Bihar (now Jharkhand)","Dhoni","WK-Batsman","Right-Handed Bat","Right-arm medium"));

       }
       if (position==1){
           csk_info_list.add(new CskpagerModel(R.drawable.suresh,"Suresh Raina","India","November 27, 1986 (37 Years)","Muradnagar, Ghaziabad, Uttar Pradesh","Raina","Batsman","Left Handed Bat","Right-arm offbreak"));
       }
       if (position==2){
           csk_info_list.add(new CskpagerModel(R.drawable.ruturaj,"Ruturaj Gaikwad","India","January 31, 1997 (27 Years)","Pune,Maharashtra","Giakwad","Batsman","Right Handed Bat","Right-arm offbreak"));
       }
       if (position==3){
           csk_info_list.add(new CskpagerModel(R.drawable.rahane,"Ajinkya Rahane","India","June 06, 1988 (35 Years)","Ashwi-KD,Maharashtra","Rahane","Batsman","Right Handed Bat","Right-arm medium"));
       }
       if (position==4){
           csk_info_list.add(new CskpagerModel(R.drawable.jadeja,"Ravindra Jadeja","India","December 06, 1988 (35 Years)","Navagam-Khed, Saurashtra","Jadeja","Bowling Allrounder","Left Handed Bat","Left-arm orthodox"));
       }
       if (position==5){
           csk_info_list.add(new CskpagerModel(R.drawable.rachin,"Rachin Ravindra","New Zealand","November 18, 1999 (24 Years)","Wellington","Ravindra","Batting Allrounder","Left-Handed Bat","Left-arm orthodox"));
       }
       if (position==6){
           csk_info_list.add(new CskpagerModel(R.drawable.shivam,"Shivam Dube","India","June 26, 1993 (30 Years)","Mumbai","Shivam Dube","Bowling Allrounder","Left Handed Bat","Right-arm medium"));

       }
       if (position==7){
           csk_info_list.add(new CskpagerModel(R.drawable.devon,"Devon Comway","New Zealand","July 08, 1991 (32 Years)","Johannesburg,Transvaal","Conway","WK-Batsman","Left Handed Bat","Right-arm medium"));

       }
       if (position==8){
           csk_info_list.add(new CskpagerModel(R.drawable.deepak,"Deepak Chahar","India","August 07, 1992 (31 Years)","Agra, Uttar Pradesh","Chahar","Bowler","Right Handed Bat","Right-arm medium"));
       }
       if (position==9){
           csk_info_list.add(new CskpagerModel(R.drawable.shardul,"Shardul Thakur","India","October 16, 1991 (32 Years)","Palghar, Maharashtra","Thakur","Bowler","Right Handed Bat","Right-arm-fast medium"));

       }
       if (position==10){
           csk_info_list.add(new CskpagerModel(R.drawable.santner,"Mitchell Santner","New Zealand","February 05, 1992 (32 Years)","Hamilton","Santner","Bowling Allrounder","Left Handed Bat","Left-arm orthodox"));
       }


        cskinfoadapter cskinfoadapter=new cskinfoadapter(getActivity(),csk_info_list);
        csk_info_recyclerview.setAdapter(cskinfoadapter);


        return view;
    }
}