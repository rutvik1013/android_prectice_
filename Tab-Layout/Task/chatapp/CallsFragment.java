package com.example.chatapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class CallsFragment extends Fragment {

    RecyclerView callrecyclerview;
    private ArrayList<Fragment_Call_Model>call_list;
    private Context context;
    TextView textView;

    private Fragment_Call_adapter call_adapter;


    public CallsFragment() {
        // Required empty public constructor
    }




    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_calls, container, false);

        callrecyclerview=view.findViewById(R.id.call_recyclerview);
        textView=view.findViewById(R.id.tv_empty);

        callrecyclerview.setLayoutManager(new LinearLayoutManager(context));

        ArrayList<Fragment_Call_Model>call_list=new ArrayList<>();

        call_list.add(new Fragment_Call_Model(R.drawable.image4,"Babariya Rutvik","12-09-2012"));
        call_list.add(new Fragment_Call_Model(R.drawable.image6,"Babariya Dhaval","12-02-2010"));
        call_list.add(new Fragment_Call_Model(R.drawable.image7,"Babariya Jayraj","12-09-2023"));
        call_list.add(new Fragment_Call_Model(R.drawable.image2,"Babariya Bhavesh","12-09-2015"));
        call_list.add(new Fragment_Call_Model(R.drawable.image14,"Babariya Bhavin","07-09-2017"));
        call_list.add(new Fragment_Call_Model(R.drawable.image19,"Babariya Nayan","11-10-2018"));
        call_list.add(new Fragment_Call_Model(R.drawable.image20,"Babariya Narendra","10-12,2010"));
        call_list.add(new Fragment_Call_Model(R.drawable.image11,"Dayatar Vishal","12-09-2016"));
        call_list.add(new Fragment_Call_Model(R.drawable.image16,"Dholakiya Ronak","12-08-2021"));
        call_list.add(new Fragment_Call_Model(R.drawable.image12,"Jadeja Ruturaj","24-03-2023"));
        call_list.add(new Fragment_Call_Model(R.drawable.image13,"Babariya Jaydip","12-09-2012"));
        call_list.add(new Fragment_Call_Model(R.drawable.image17,"Babariya Yuvraj","24,03-2024"));


        call_adapter=new Fragment_Call_adapter(getActivity(),call_list,textView);
        callrecyclerview.setAdapter(call_adapter);

        return view;
    }
}