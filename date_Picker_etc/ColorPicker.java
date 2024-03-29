package com.example.datepicker_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import yuku.ambilwarna.AmbilWarnaDialog;

public class ColorPicker extends AppCompatActivity {

    Button setcolorbtn,pickcolorbtn;
    TextView textViewname;
    View colorpreview;
    int Defaultcolor;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        setcolorbtn=findViewById(R.id.set_color_btn);
        pickcolorbtn=findViewById(R.id.pick_color_btn);
        textViewname=findViewById(R.id.txtname);
        colorpreview=findViewById(R.id.selected_view);

        Defaultcolor=0;

        pickcolorbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(  View v) {
                    openColorPickerDialog();
            }
        });
        setcolorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewname.setTextColor(Defaultcolor);
            }
        });


    }

    private void openColorPickerDialog() {
        AmbilWarnaDialog ambilWarnaDialog=new AmbilWarnaDialog(this, Defaultcolor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }


            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                Defaultcolor=color;
                colorpreview.setBackgroundColor(Defaultcolor);
            }
        });
        ambilWarnaDialog.show();

    }


}