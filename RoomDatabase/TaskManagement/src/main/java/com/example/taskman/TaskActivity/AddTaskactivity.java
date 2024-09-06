package com.example.taskman.TaskActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.taskman.R;
import com.example.taskman.RoomDb.TaskModel;
import com.example.taskman.RoomDb.TaskViewmodel;
import com.example.taskman.databinding.ActivityAddTaskactivityBinding;

import java.util.Calendar;

public class AddTaskactivity extends AppCompatActivity {

    ActivityAddTaskactivityBinding binding;
    TaskViewmodel viewmodel;
    String priority = "1";  // Default priority

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTaskactivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        viewmodel = new ViewModelProvider(this).get(TaskViewmodel.class);

        binding.edtdate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(AddTaskactivity.this, (datePicker, i, i1, i2) ->
                    binding.edtdate.setText(i2 + "/" + (i1 + 1) + "/" + i), year, month, day);
            datePickerDialog.show();
        });

        binding.edtTime.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(AddTaskactivity.this, (timePicker, i, i1) ->
                    binding.edtTime.setText(String.format("%02d:%02d", i, i1)), hour, minute, false);
            timePickerDialog.show();
        });

        binding.addTaskBtn.setOnClickListener(v -> {
            String task_name = binding.edtname.getText().toString();
            String description = binding.edtdescription.getText().toString();
            String date = binding.edtdate.getText().toString();
            String time = binding.edtTime.getText().toString();

            if (TextUtils.isEmpty(task_name) || TextUtils.isEmpty(description) || TextUtils.isEmpty(date) || TextUtils.isEmpty(time)) {
                Toast.makeText(AddTaskactivity.this, "You have to fill all details", Toast.LENGTH_SHORT).show();
            } else {
                TaskModel model = new TaskModel(0, task_name, description, date, time, priority);
                viewmodel.InsertTask(model);
                Toast.makeText(AddTaskactivity.this, "Task inserted", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddTaskactivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        binding.highPriority.setOnClickListener(v -> {
            setPriority(1);
        });

        binding.midiumPriority.setOnClickListener(v -> {
            setPriority(2);
        });

        binding.lowPriority.setOnClickListener(v -> {
            setPriority(3);
        });
    }

    private void setPriority(int level) {
        priority = String.valueOf(level);
        binding.highPriority.setImageResource(0);
        binding.midiumPriority.setImageResource(0);
        binding.lowPriority.setImageResource(0);
        binding.highPriority.setBackgroundResource(0);
        binding.midiumPriority.setBackgroundResource(0);
        binding.lowPriority.setBackgroundResource(0);

        switch (level) {
            case 1:
                binding.highPriority.setImageResource(R.drawable.baseline_done_24);
                binding.highPriority.setBackgroundResource(R.drawable.red_priority);
                break;
            case 2:
                binding.midiumPriority.setImageResource(R.drawable.baseline_done_24);
                binding.midiumPriority.setBackgroundResource(R.drawable.yellow_priority);
                break;
            case 3:
                binding.lowPriority.setImageResource(R.drawable.baseline_done_24);
                binding.lowPriority.setBackgroundResource(R.drawable.green_priority);
                break;
        }
    }
}
