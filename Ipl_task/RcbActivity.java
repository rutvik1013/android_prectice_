package com.example.ipl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class RcbActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<rcb_model>rcblist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcb);

        listView=findViewById(R.id.rcblist);

        ArrayList<rcb_model>rcblist=new ArrayList<>();

        rcblist.add(new rcb_model(R.drawable.virat,"Virat Kohli"));
        rcblist.add(new rcb_model(R.drawable.faf,"Faf du Plassis"));
        rcblist.add(new rcb_model(R.drawable.maxwell,"Glenn Maxwell"));
        rcblist.add(new rcb_model(R.drawable.cameron_green,"Cameron_green"));
        rcblist.add(new rcb_model(R.drawable.rajat,"Rajat Patidar"));
        rcblist.add(new rcb_model(R.drawable.dinesh,"Dinesh Kartik"));
        rcblist.add(new rcb_model(R.drawable.will_jacks,"Will Jacks"));
        rcblist.add(new rcb_model(R.drawable.karn,"Karn Sharma"));
        rcblist.add(new rcb_model(R.drawable.anuj,"Anuj Rawat"));
        rcblist.add(new rcb_model(R.drawable.siraj,"Mohammed Siraj"));
        rcblist.add(new rcb_model(R.drawable.suyash,"Suyash S Prabhudesai"));

        RcbAdapter adapter=new RcbAdapter(this,rcblist);
        listView.setAdapter(adapter);
    }
}