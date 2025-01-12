package com.example.custom_selection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyCustomView> {

    private Activity activity;
    private ArrayList<custom_model> customList;
    private ArrayList<custom_model> selectedList = new ArrayList<>();
    private TextView textEmpty;
    private ImageView imageclear;

    private mainviewmodel mainViewModel;
    private boolean isEnabled = false;
    private boolean isSelectAll = false;

    public MyAdapter(Activity activity, ArrayList<custom_model> customList, TextView textEmpty, ImageView imageclear) {
        this.activity = activity;
        this.customList = customList;
        this.textEmpty = textEmpty;
        this.imageclear = imageclear;
    }

    public void filteredList(ArrayList<custom_model> filterlist) {
        customList = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyCustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_design, parent, false);
        mainViewModel = new ViewModelProvider((FragmentActivity) activity).get(mainviewmodel.class);
        return new MyCustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCustomView holder, int position) {
        custom_model customModel = customList.get(position);

        // Set data to views
        holder.imageCall.setImageResource(customModel.getImage());
        holder.textName.setText(customModel.getName());
        holder.textPhoneNumber.setText(customModel.getPhone_number());

        // Handle item click
        holder.itemView.setOnClickListener(view -> {
            if (isEnabled) {
                toggleSelection(holder);
            } else {
                Intent intent = new Intent(activity, customviewactivity.class);
                intent.putExtra("position", customModel);
                activity.startActivity(intent);
                Toast.makeText(activity, "Clicked " + customModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        // Handle long press to enable ActionMode
        holder.itemView.setOnLongClickListener(view -> {
            if (!isEnabled) {
                ((AppCompatActivity) activity).startActionMode(actionModeCallback);
                toggleSelection(holder);
            }
            return true;
        });

        // Update selection visuals
        if (selectedList.contains(customModel)) {
            holder.checkbox.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.checkbox.setVisibility(View.GONE);
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        return customList.size();
    }

    // Toggle selection state of an item
    private void toggleSelection(MyCustomView holder) {
        custom_model customModel = customList.get(holder.getAdapterPosition());

        if (selectedList.contains(customModel)) {
            // Deselect item
            holder.checkbox.setVisibility(View.GONE);
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
            selectedList.remove(customModel);
        } else {
            // Select item
            holder.checkbox.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundColor(Color.LTGRAY);
            selectedList.add(customModel);
        }

        // Update ViewModel with selection size
        mainViewModel.setText(String.valueOf(selectedList.size()));
    }

    // ActionMode callback for managing contextual actions
    private final ActionMode.Callback actionModeCallback = new ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.select_menu, menu);
            isEnabled = true;
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            mainViewModel.getText().observe((LifecycleOwner) activity, mode::setTitle);
            return true;
        }

        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.delete_call) {
                // Delete selected items
                customList.removeAll(selectedList);
                selectedList.clear();
                if (customList.isEmpty()) {
                    textEmpty.setVisibility(View.VISIBLE);
                    imageclear.setVisibility(View.VISIBLE);
                }
                notifyDataSetChanged();
                mode.finish();
                return true;
            } else if (item.getItemId() == R.id.select_all_call) {
                // Select or deselect all items
                if (selectedList.size() == customList.size()) {
                    isSelectAll = false;
                    selectedList.clear();
                } else {
                    isSelectAll = true;
                    selectedList.clear();
                    selectedList.addAll(customList);
                }
                mainViewModel.setText(String.valueOf(selectedList.size()));
                notifyDataSetChanged();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            isEnabled = false;
            isSelectAll = false;
            selectedList.clear();
            notifyDataSetChanged();
        }
    };

    // ViewHolder class
    static class MyCustomView extends RecyclerView.ViewHolder {
        CircleImageView imageCall;
        ImageView checkbox;
        TextView textName, textPhoneNumber;

        public MyCustomView(@NonNull View itemView) {
            super(itemView);
            imageCall = itemView.findViewById(R.id.image_caller);
            textName = itemView.findViewById(R.id.text_name);
            textPhoneNumber = itemView.findViewById(R.id.text_phone_number);
            checkbox = itemView.findViewById(R.id.imagecheck);
        }
    }
}
