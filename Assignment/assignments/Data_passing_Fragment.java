package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class Data_passing_Fragment extends AppCompatActivity {

    TextInputEditText edtdata;
    AppCompatButton btnpassdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_passing_fragment);

        edtdata=findViewById(R.id.edtdata);
        btnpassdata=findViewById(R.id.btnpassdata);









        btnpassdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=edtdata.getText().toString();

                Bundle bundle=new Bundle();
                bundle.putString("name",name);


                BlankFragment blankFragment=new BlankFragment();
                blankFragment.setArguments(bundle);

                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.framcontainer, blankFragment);
                ft.commit();
            }
        });
    }
}