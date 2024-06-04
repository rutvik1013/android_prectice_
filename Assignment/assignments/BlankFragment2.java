package com.example.assignments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BlankFragment2 extends Fragment {

    EditText edtfrag;
    Button btnfrag;

    public BlankFragment2() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank2, container, false);

      edtfrag=view.findViewById(R.id.edtfrag);
      btnfrag=view.findViewById(R.id.btnfrag);


       btnfrag.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(getActivity(), MainActivity2.class);
               i.putExtra("key",edtfrag.getText().toString());
               startActivity(i);
           }
       });

        return  view;
    }
}