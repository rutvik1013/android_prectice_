package com.example.chatapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class StatusFragment extends Fragment {

    RecyclerView statusrecyclerview;
    private ArrayList<Fragment_status_Model>statuslist;
    private Context context;
    Fragment_status_adapter status_adapter;
    public StatusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_status, container, false);


        statusrecyclerview=view.findViewById(R.id.status_recycleview);

        statusrecyclerview.setLayoutManager(new LinearLayoutManager(context));

        ArrayList<Fragment_status_Model>statuslist=new ArrayList<>();


        statuslist.add(new Fragment_status_Model(R.drawable.img1,"Babariya Rutvik","Just now"));
        statuslist.add(new Fragment_status_Model(R.drawable.image2,"Babariya Dhaval","10 Minutes ago"));
        statuslist.add(new Fragment_status_Model(R.drawable.image3,"Babariya Jayraj","12 Minutes ago"));
        statuslist.add(new Fragment_status_Model(R.drawable.image4,"Babariya Bhavesh","15 Minutes ago"));
        statuslist.add(new Fragment_status_Model(R.drawable.image5,"Babariya Bhavin","20 Minutes ago"));
        statuslist.add(new Fragment_status_Model(R.drawable.image7,"Babariya Mahipat","25 Miniuts ago"));
        statuslist.add(new Fragment_status_Model(R.drawable.image12,"Babariya Alpesh","25 Miniuts ago"));
        statuslist.add(new Fragment_status_Model(R.drawable.image11,"Babariya Yuvraj","12.34 pm"));
        statuslist.add(new Fragment_status_Model(R.drawable.image13,"Dayatar Vishal","1.45 pm"));
        statuslist.add(new Fragment_status_Model(R.drawable.image8,"Dholakiya Ronak","2.00 pm"));
        statuslist.add(new Fragment_status_Model(R.drawable.image9,"Jadeja Ruturaj","2.15 pm"));
        statuslist.add(new Fragment_status_Model(R.drawable.image10,"Rajkotiya Pratik","2.45 pm"));
        statuslist.add(new Fragment_status_Model(R.drawable.image14,"Ratanpara Utsav","5.00 pm"));
        statuslist.add(new Fragment_status_Model(R.drawable.image15,"Babariya Jaydip","Yesterday"));
        statuslist.add(new Fragment_status_Model(R.drawable.img1,"Dayatar Vivek","Yesterday"));


        status_adapter=new Fragment_status_adapter(getActivity(),statuslist);
        statusrecyclerview.setAdapter(status_adapter);



        return view;
    }
}