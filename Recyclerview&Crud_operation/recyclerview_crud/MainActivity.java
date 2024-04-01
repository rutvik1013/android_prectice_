package com.example.recyclerview_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<Model>list;
    Myadapter myadapter;
    FloatingActionButton floatingActionButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        floatingActionButton=findViewById(R.id.f1);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Model>list=new ArrayList<>();

        list.add(new Model(R.drawable.img1,"Babariya Rutvik","Age: 24","Ahmedabad"));
        list.add(new Model(R.drawable.image2,"Babariya Dhaval","Age: 24","Rajkot"));
        list.add(new Model(R.drawable.image3,"Babariya Jayraj","Age: 24","Keshod"));
        list.add(new Model(R.drawable.image3,"Babariya Bhavin","Age: 24","Manavadar"));
        list.add(new Model(R.drawable.image4,"Babariya Suresh","Age: 25","Manavadar"));
        list.add(new Model(R.drawable.image5,"Babariya Jaydip","Age: 27","Keshod"));
        list.add(new Model(R.drawable.image6,"Babariya Yuvraj","Age: 28","Junagadh"));
        list.add(new Model(R.drawable.image7,"Babariya Parikshit","Age: 30","Thaniyana"));
        list.add(new Model(R.drawable.image8,"Babariya Nayan","Age: 22","Kolkata"));
        list.add(new Model(R.drawable.image9,"Dholakiya Ronak","Age: 22","Rajkot"));
        list.add(new Model(R.drawable.image10,"Jadeja Ruturaj","Age: 21","Rajkot"));
        list.add(new Model(R.drawable.image11,"Karamata Raju","Age: 24","Dhoraji"));
        list.add(new Model(R.drawable.image12,"Babariya Parth","Age: 20","Rajkot"));
        list.add(new Model(R.drawable.image13,"Babariya Nildip","Age: 60","Thaniyana"));
        list.add(new Model(R.drawable.image14,"Babariya Mahipat","Age: 29","Thaniyana"));
        list.add(new Model(R.drawable.image15,"Babariya Alpesh","Age: 26","Thaniyana"));
        list.add(new Model(R.drawable.image16,"Pethani Monak","Age: 20","Rajkot"));
        list.add(new Model(R.drawable.image17,"Koradiya Jenti","Age: 20","Manavadar"));
        list.add(new Model(R.drawable.image18,"Rajakotiya Pratik","Age: 24","Ahmedabad"));
        list.add(new Model(R.drawable.image19,"Dangar Bhavin","Age: 24","Gandhinagar"));
        list.add(new Model(R.drawable.image20,"Ratanpara Utsav","Age: 24","Ahmedabad"));

        Myadapter myadapter=new Myadapter(this,list);
        recyclerView.setAdapter(myadapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.layout_design);

                EditText edtname=dialog.findViewById(R.id.edt_name);
                EditText edtage=dialog.findViewById(R.id.edt_age);
                EditText edtadress=dialog.findViewById(R.id.edt_adress);
                Button btnsubmit=dialog.findViewById(R.id.btnsubmit);


                btnsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name=edtname.getText().toString();
                        String age=edtage.getText().toString();
                        String adress=edtadress.getText().toString();

                        list.add(new Model(R.drawable.image19,name,age,adress));
                        myadapter.notifyItemInserted(list.size()-1);
                        recyclerView.scrollToPosition(list.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

    }
}