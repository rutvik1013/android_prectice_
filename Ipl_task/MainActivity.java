package com.example.ipl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   ImageView cskimage;
   ImageView miimage;
   ImageView rcbimage;
   ImageView dcimage;
   ImageView gtimage;
   ImageView rrimage;
   ImageView punjabimage;
   ImageView lsgimage;
   ImageView srhimage;
   ImageView kkrimage;

   TextView csktext;
   TextView mitext;
   TextView rcbtext;
   TextView dctext;
   TextView gttext;
   TextView rrtext;
   TextView punjabtext;
   TextView lsgtext;
   TextView srhtext;
   TextView kkrtext;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cskimage=findViewById(R.id.csk);
        miimage=findViewById(R.id.mi);
        rcbimage=findViewById(R.id.rcb);
        dcimage=findViewById(R.id.dc);
        gtimage=findViewById(R.id.gujarat);
        rrimage=findViewById(R.id.rr);
        punjabimage=findViewById(R.id.punjab_kings);
        lsgimage=findViewById(R.id.lsg);
        srhimage=findViewById(R.id.srh);
        kkrimage=findViewById(R.id.kkr);

        csktext=findViewById(R.id.csktext);
        mitext=findViewById(R.id.mi_text);
        rcbtext=findViewById(R.id.rcb_text);
        dctext=findViewById(R.id.delhitext);
        gttext=findViewById(R.id.gujarattext);
        rrtext=findViewById(R.id.rajasthantext);
        punjabtext=findViewById(R.id.punjabkingstext);
        lsgtext=findViewById(R.id.lsgtext);
        srhtext=findViewById(R.id.srhtext);
        kkrtext=findViewById(R.id.kkrtext);


        // Chennai Super Kings

        cskimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),csk.class);
               Toast.makeText(MainActivity.this,"Csk Team",Toast.LENGTH_LONG).show();
               startActivity(i);
            }
        });

        csktext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String csk_url="https://www.chennaisuperkings.com/";

                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(csk_url));
                startActivity(i);
            }
        });

        // Mumbai indians

        miimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MiActivity.class);
                Toast.makeText(MainActivity.this, "Mumbai indians team", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        mitext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mi_url="https://www.mumbaiindians.com/";

                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(mi_url));
                startActivity(i);
            }
        });

        // Royal Challenger Benglore

        rcbimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), RcbActivity.class);
                Toast.makeText(MainActivity.this, "Rcb Team", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        rcbtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rcb_url="https://www.royalchallengers.com/";
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(rcb_url));
                startActivity(i);

            }
        });

        // Delhi Capitals

        dcimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), Delhiactivity.class);
                Toast.makeText(MainActivity.this, "Delhi Capitals Team", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
        dctext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dc_url="https://www.delhicapitals.in/";

                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(dc_url));
                startActivity(i);
            }
        });

        // Rajasthan Royals
        rrimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),RajasthanActivity.class);
                Toast.makeText(MainActivity.this, "Rajasthan Royals Team", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        rrtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rr_url="https://www.rajasthanroyals.com/";

                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(rr_url));
                startActivity(i);
            }
        });

        // Gujarat Titans

        gtimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), GujaratActivity.class);
                Toast.makeText(getApplicationContext(), "Gujarat Titans Team", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        gttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gt_url="https://www.gujarattitansipl.com/";
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(gt_url));
                startActivity(i);
            }
        });
        // Punjab Kings

        punjabimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), PunjabActivity.class);
                Toast.makeText(MainActivity.this, "Punjab Kings Team", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        punjabtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String punjab_url="https://www.punjabkingsipl.in/";
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(punjab_url));
                startActivity(i);
            }
        });

        // Kolkata Knight Riders

        kkrimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), Kkractivity.class);
                Toast.makeText(MainActivity.this, "Kolkata Team", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
        kkrtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kkr_url="https://www.kkr.in/";
            }
        });

    }
}