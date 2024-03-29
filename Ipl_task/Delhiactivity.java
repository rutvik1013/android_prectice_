package com.example.ipl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Delhiactivity extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhiactivity);

        ArrayList<Dc_Model>dclist=new ArrayList<>();

        dclist.add(new Dc_Model(R.drawable.rishabh,"Rishabh Pant"));
        dclist.add(new Dc_Model(R.drawable.warner,"Devid Warner"));
        dclist.add(new Dc_Model(R.drawable.prithvi,"Prithvi Shaw"));
        dclist.add(new Dc_Model(R.drawable.axar,"Axar Patel"));
        dclist.add(new Dc_Model(R.drawable.lalit,"Lalit Yadav"));
        dclist.add(new Dc_Model(R.drawable.marsh,"Mitchell Marsh"));
        dclist.add(new Dc_Model(R.drawable.abhishek_p,"Abhishek Porell"));
        dclist.add(new Dc_Model(R.drawable.ishant,"Ishant Sharma"));
        dclist.add(new Dc_Model(R.drawable.lungi_ngidi,"Lungi ngidi"));
        dclist.add(new Dc_Model(R.drawable.kuldeep,"Kuldeep Yadav"));
        dclist.add(new Dc_Model(R.drawable.anrich_nortje,"Anrich Nortje"));

        DcAdapter adapter=new DcAdapter(this,dclist);
        listView.setAdapter(adapter);
    }
}