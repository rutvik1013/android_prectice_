package com.example.datepicker_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerActivity extends AppCompatActivity {

    Button btntime;
    TextView txttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        txttime=findViewById(R.id.txttime);
        btntime=findViewById(R.id.btntime);

        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c=Calendar.getInstance();

                int hour=c.get(Calendar.HOUR_OF_DAY);
                int miniut=c.get(Calendar.MINUTE);


                TimePickerDialog timePickerDialog=new TimePickerDialog(TimePickerActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        txttime.setText(hourOfDay+":"+minute);
                    }
                },hour,miniut,false);
                timePickerDialog.show();
            }
        });
    }
}