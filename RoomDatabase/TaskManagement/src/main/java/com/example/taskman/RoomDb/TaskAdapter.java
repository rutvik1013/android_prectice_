package com.example.taskman.RoomDb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskman.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<MyTaskView> {

    private Context context;
    private List<TaskModel> list;
    private TaskViewmodel viewmodel;

    public TaskAdapter(ViewModelStoreOwner owner, Context context, List<TaskModel> list) {
        this.context = context;
        this.list = list;
        this.viewmodel = new ViewModelProvider(owner).get(TaskViewmodel.class);
    }

    @NonNull
    @Override
    public MyTaskView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.task_design, parent, false);
        return new MyTaskView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTaskView holder, int position) {
        TaskModel taskModel = list.get(position);

        holder.txt_task_name.setText(taskModel.getTask_name());
        holder.txt_task_description.setText(taskModel.getTask_description());
        holder.txt_task_date.setText(taskModel.getTask_date());
        holder.txt_task_time.setText(taskModel.getTask_time());

        // Set priority color and check if the task is due
        updatePriorityIndicator(holder, taskModel);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogPlus dialogPlus = DialogPlus.newDialog(holder.itemView.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_design))
                        .setExpanded(true, ViewGroup.LayoutParams.WRAP_CONTENT)
                        .create();

                View myView = dialogPlus.getHolderView();

                EditText edtName = myView.findViewById(R.id.update_edtname);
                EditText edtDescription = myView.findViewById(R.id.update_edtdescription);
                EditText edtDate = myView.findViewById(R.id.update_edtdate);
                EditText edtTime = myView.findViewById(R.id.update_edt_time);
                FloatingActionButton updateTaskBtn = myView.findViewById(R.id.update_task_btn);

                // For Priority Update
                ImageView highPriority = myView.findViewById(R.id.update_high_priority);
                ImageView mediumPriority = myView.findViewById(R.id.update_midium_priority);
                ImageView lowPriority = myView.findViewById(R.id.update_low_priority);

                edtName.setText(taskModel.getTask_name());
                edtDescription.setText(taskModel.getTask_description());
                edtDate.setText(taskModel.getTask_date());
                edtTime.setText(taskModel.getTask_time());

                // Set current Priority
                setPriorityIndicator(taskModel.getTask_priority(), highPriority, mediumPriority, lowPriority);

                // Priority ClickListener
                highPriority.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setPriorityIndicator("1", highPriority, mediumPriority, lowPriority);
                        taskModel.setTask_priority("1");
                    }
                });

                mediumPriority.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setPriorityIndicator("2", highPriority, mediumPriority, lowPriority);
                        taskModel.setTask_priority("2");
                    }
                });

                lowPriority.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setPriorityIndicator("3", highPriority, mediumPriority, lowPriority);
                        taskModel.setTask_priority("3");
                    }
                });

                updateTaskBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = edtName.getText().toString();
                        String description = edtDescription.getText().toString();
                        String date = edtDate.getText().toString();
                        String time = edtTime.getText().toString();

                        TaskModel updateTask = new TaskModel(taskModel.getId(), name, description, date, time, taskModel.getTask_priority());
                        viewmodel.UpdateTask(updateTask);
                        dialogPlus.dismiss();
                    }
                });

                dialogPlus.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setTask(List<TaskModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public TaskModel getTaskAt(int position) {
        return list.get(position);
    }

    private void updatePriorityIndicator(MyTaskView holder, TaskModel taskModel) {
        String priority = taskModel.getTask_priority();
        if (isTaskDue(taskModel.getTask_date(), taskModel.getTask_time())) {
            holder.task_priority.setBackgroundResource(R.drawable.due_priority);
        } else {
            switch (priority) {
                case "1":
                    holder.task_priority.setBackgroundResource(R.drawable.red_priority);
                    break;
                case "2":
                    holder.task_priority.setBackgroundResource(R.drawable.yellow_priority);
                    break;
                case "3":
                    holder.task_priority.setBackgroundResource(R.drawable.green_priority);
                    break;
            }
        }
    }

    private void setPriorityIndicator(String priority, ImageView highPriority, ImageView mediumPriority, ImageView lowPriority) {
        highPriority.setImageResource(0);
        mediumPriority.setImageResource(0);
        lowPriority.setImageResource(0);

        switch (priority) {
            case "1":
                highPriority.setImageResource(R.drawable.baseline_done_24);
                break;
            case "2":
                mediumPriority.setImageResource(R.drawable.baseline_done_24);
                break;
            case "3":
                lowPriority.setImageResource(R.drawable.baseline_done_24);
                break;
        }
    }

    private boolean isTaskDue(String taskDate, String taskTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String taskDateTime = taskDate + " " + taskTime;

        try {
            Date taskDueDate = dateFormat.parse(taskDateTime);
            Date currentDate = new Date();
            return currentDate.after(taskDueDate);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}

class MyTaskView extends RecyclerView.ViewHolder {

    TextView txt_task_name, txt_task_description, txt_task_date, txt_task_time;
    View task_priority;

    public MyTaskView(@NonNull View itemView) {
        super(itemView);
        txt_task_name = itemView.findViewById(R.id.txt_task_name);
        txt_task_description = itemView.findViewById(R.id.txt_task_description);
        txt_task_date = itemView.findViewById(R.id.txt_task_date);
        txt_task_time = itemView.findViewById(R.id.txt_task_time);
        task_priority = itemView.findViewById(R.id.task_priority);
    }
}
