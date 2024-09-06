package com.example.taskman.TaskActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.taskman.R;
import com.example.taskman.RoomDb.TaskAdapter;
import com.example.taskman.RoomDb.TaskModel;
import com.example.taskman.RoomDb.TaskViewmodel;
import com.example.taskman.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private TaskViewmodel viewmodel;
    private List<TaskModel> list;
    private TaskAdapter adapter;
    private Drawable deleteIcon;
    private final ColorDrawable background = new ColorDrawable(Color.BLACK);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        list = new ArrayList<>();

        binding.recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter = new TaskAdapter(this, this, list);
        binding.recyclerview.setAdapter(adapter);

        viewmodel = new ViewModelProvider(this).get(TaskViewmodel.class);

        // Observing all tasks sorted by date and time from the ViewModel
        viewmodel.get_Task_By_Date_and_Time().observe(this, new Observer<List<TaskModel>>() {
            @Override
            public void onChanged(List<TaskModel> taskmodel) {
                if (taskmodel != null) {
                    list = taskmodel;
                    adapter.setTask(taskmodel);
                } else {
                    Toast.makeText(MainActivity.this, "No Task Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.createTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AddTaskactivity.class);
                startActivity(i);
            }
        });

        // Initialize the delete icon
        deleteIcon = ContextCompat.getDrawable(this, R.drawable.baseline_delete_24);

        // Item TouchHelper for swipe to delete the task
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // Delete the task
                TaskModel taskModel = adapter.getTaskAt(viewHolder.getAdapterPosition());
                viewmodel.DeleteTask(taskModel);
                Toast.makeText(MainActivity.this, "Deleted The Task", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

                View itemView = viewHolder.itemView;
                int backgroundCornerOffset = 20;

                int iconMargin = (itemView.getHeight() - deleteIcon.getIntrinsicHeight()) / 2;
                int iconTop = itemView.getTop() + (itemView.getHeight() - deleteIcon.getIntrinsicHeight()) / 2;
                int iconBottom = iconTop + deleteIcon.getIntrinsicHeight();

                if (dX < 0) { // Swipe to left
                    int iconLeft = itemView.getRight() - iconMargin - deleteIcon.getIntrinsicWidth();
                    int iconRight = itemView.getRight() - iconMargin;
                    deleteIcon.setBounds(iconLeft, iconTop, iconRight, iconBottom);

                    background.setBounds(itemView.getRight() + ((int) dX) - backgroundCornerOffset,
                            itemView.getTop(), itemView.getRight(), itemView.getBottom());
                } else { // Unswiped (reset state)
                    background.setBounds(0, 0, 0, 0);
                    deleteIcon.setBounds(0, 0, 0, 0);
                }

                background.draw(c);
                deleteIcon.draw(c);
            }
        }).attachToRecyclerView(binding.recyclerview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_task, menu);

        MenuItem searchItem = menu.findItem(R.id.search_task_);
        if (searchItem != null) {
            SearchView searchView = (SearchView) searchItem.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filter(newText);
                    return false;
                }
            });
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.sort_date) {
            // Observe sorted data by date and time
            viewmodel.get_Task_By_Date_and_Time().observe(this, new Observer<List<TaskModel>>() {
                @Override
                public void onChanged(List<TaskModel> sortedTasks) {
                    // Update the adapter with the sorted list
                    adapter.setTask(sortedTasks);
                }
            });
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void filter(String text) {
        List<TaskModel> filteredList = new ArrayList<>();
        for (TaskModel taskModel : list) {
            if (taskModel.getTask_name().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(taskModel);
            }
        }
        adapter.setTask(filteredList);
    }
}
