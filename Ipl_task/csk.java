package com.example.ipl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class csk extends AppCompatActivity {

    ListView listView;
    private ArrayList<cskmodel>csklist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csk);

        listView=findViewById(R.id.cskplayerlist);

        ArrayList<cskmodel>csklist=new ArrayList<>();

        csklist.add(new cskmodel(R.drawable.dhoni,"M.s.Dhoni"));
        csklist.add(new cskmodel(R.drawable.suresh,"Suresh Raina"));
        csklist.add(new cskmodel(R.drawable.jadeja,"Ravindra Jadeja"));
        csklist.add(new cskmodel(R.drawable.ruturaj,"Ruturaj Giakwad"));
        csklist.add(new cskmodel(R.drawable.rahane,"Ajinkya Rahane"));
        csklist.add(new cskmodel(R.drawable.shivam,"Shivam Dube"));
        csklist.add(new cskmodel(R.drawable.devon,"Devon Conway"));
        csklist.add(new cskmodel(R.drawable.strokes,"Ben Strokes"));
        csklist.add(new cskmodel(R.drawable.shardul,"Shardul Thakur"));
        csklist.add(new cskmodel(R.drawable.santner,"Mitchell Santner"));
        csklist.add(new cskmodel(R.drawable.deepak,"Deepak Chahar"));


        cskadapter adapter=new cskadapter(this,csklist);
        listView.setAdapter(adapter);
    }
}