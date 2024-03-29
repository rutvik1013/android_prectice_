package com.example.ipl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MiActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi);

        gridView=findViewById(R.id.mi_grid);

        ArrayList<Mi_Model>milist=new ArrayList<>();

        milist.add(new Mi_Model(R.drawable.rohit_,"Rohit Sharma"));
        milist.add(new Mi_Model(R.drawable.hardik,"Hardik Pandya"));
        milist.add(new Mi_Model(R.drawable.ishan,"Ishan Kishan"));
        milist.add(new Mi_Model(R.drawable.suryakumar,"SuryaKumar Yadav"));
        milist.add(new Mi_Model(R.drawable.piyush,"Piyush Chawala"));
        milist.add(new Mi_Model(R.drawable.akash,"Akash Madhawal"));
        milist.add(new Mi_Model(R.drawable.tilak,"Tilak Varma"));
        milist.add(new Mi_Model(R.drawable.tim_devid,"Tim David"));
        milist.add(new Mi_Model(R.drawable.arjun,"Arjun Tendulakar"));
        milist.add(new Mi_Model(R.drawable.dewald,"Dewald Bravis"));
        milist.add(new Mi_Model(R.drawable.bumrah,"Jasprit Bumrah"));

        Miadapter miadapter=new Miadapter(this,milist);
        gridView.setAdapter(miadapter);

    }
}