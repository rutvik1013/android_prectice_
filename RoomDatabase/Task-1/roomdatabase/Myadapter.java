package com.example.roomdatabase;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<MydataView> {
    private Context context;
    private List<UserModel> list;
    private ViewModel viewModel;
    private boolean isEnable = false;
    private boolean isSelectAll = false;
    private ArrayList<UserModel> selectList = new ArrayList<>();
    private FragmentActivity activity; // Use FragmentActivity instead of Activity

    public Myadapter(FragmentActivity activity, Context context, List<UserModel> list) {
        this.context = context;
        this.list = list;
        this.activity = activity; // Initialize activity
        this.viewModel = new ViewModelProvider(activity).get(ViewModel.class);
    }

    @NonNull
    @Override
    public MydataView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_design, parent, false);
        return new MydataView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MydataView holder, int position) {
        UserModel model = list.get(position);

        holder.txtname.setText(model.getName());
        holder.txtage.setText(model.getAge());
        holder.txtcity.setText(model.getCity());
        holder.txt_phone_number.setText(model.getPhone_number());
        holder.txtemail.setText(model.getEmail());
        holder.txtpassword.setText(model.getPassword());

        // Set the checkbox drawable resource
        try {
            int drawableId = model.getCheckbox();
            if (drawableId != 0) {
                holder.checkbox.setImageResource(drawableId);
            } else {
                holder.checkbox.setVisibility(View.GONE); // Hide if no valid drawable
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            holder.checkbox.setVisibility(View.GONE); // Hide if resource not found
        }

        holder.itemView.setOnClickListener(view -> {
            if (isEnable) {
                toggleSelection(holder, model);
            } else {
                // Show Dialog for updating data
                DialogPlus dialogPlus = DialogPlus.newDialog(holder.itemView.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_design))
                        .setExpanded(true, ViewGroup.LayoutParams.WRAP_CONTENT)
                        .create();

                View myview = dialogPlus.getHolderView();
                TextInputEditText edt_name = myview.findViewById(R.id.edt_u_name);
                TextInputEditText edt_age = myview.findViewById(R.id.edt_u_age);
                TextInputEditText edt_city = myview.findViewById(R.id.edt_u_city);
                TextInputEditText edt_phone_number = myview.findViewById(R.id.edt_u_phone);
                TextInputEditText edt_email = myview.findViewById(R.id.edt_u_email);
                TextInputEditText edt_password = myview.findViewById(R.id.edt_u_password);
                AppCompatButton update_btn = myview.findViewById(R.id.update_btn);

                edt_name.setText(model.getName());
                edt_age.setText(model.getAge());
                edt_city.setText(model.getCity());
                edt_phone_number.setText(model.getPhone_number());
                edt_email.setText(model.getEmail());
                edt_password.setText(model.getPassword());

                update_btn.setOnClickListener(v -> {
                    String name = edt_name.getText().toString();
                    String age = edt_age.getText().toString();
                    String city = edt_city.getText().toString();
                    String phone_number = edt_phone_number.getText().toString();
                    String email = edt_email.getText().toString();
                    String password = edt_password.getText().toString();

                    UserModel updatedetails = new UserModel(model.getId(), model.getCheckbox(), name, age, city, phone_number, email, password);
                    viewModel.update(updatedetails);
                    dialogPlus.dismiss();
                });
                dialogPlus.show();
            }
        });

        holder.itemView.setOnLongClickListener(view -> {
            if (!isEnable) {
                startActionMode(holder, model);
                toggleSelection(holder, model);
                return true;
            } else {
                toggleSelection(holder, model);
                return true;
            }
        });

        // Update the UI based on selection state
        if (selectList.contains(model)) {
            holder.checkbox.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundColor(Color.RED);
        } else {
            holder.checkbox.setVisibility(View.GONE);
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setDetails(List<UserModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void ClickItem(MydataView holder, UserModel model) {
        if (selectList.contains(model)) {
            selectList.remove(model);
            holder.checkbox.setVisibility(View.GONE);
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        } else {
            selectList.add(model);
            holder.checkbox.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundColor(Color.RED);
        }
    }

    private void startActionMode(MydataView holder, UserModel model) {
        ActionMode.Callback callback = new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                MenuInflater menuInflater = actionMode.getMenuInflater();
                menuInflater.inflate(R.menu.select_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                isEnable = true;
                toggleSelection(holder, model);
                viewModel.getText().observe((LifecycleOwner) activity, s -> actionMode.setTitle(String.format("%s Selected", s)));
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.menu_delete) {
                    deleteSelecteditems();
                    actionMode.finish();
                    return true;
                } else if (id == R.id.menu_select_all) {
                    SelectAllitems();
                    return true;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
                isEnable = false;
                isSelectAll = false;
                selectList.clear();
                notifyDataSetChanged();
            }
        };

        if (activity != null) {
            activity.startActionMode(callback);
        }
    }

    private void toggleSelection(MydataView holder, UserModel model) {
        if (selectList.contains(model)) {
            selectList.remove(model);
            holder.checkbox.setVisibility(View.GONE);
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        } else {
            selectList.add(model);
            holder.checkbox.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundColor(Color.RED);
        }
        viewModel.setText(String.valueOf(selectList.size()));
    }

    public void deleteSelecteditems() {
        for (UserModel userModel : selectList) {
            viewModel.delete(userModel);
            list.remove(userModel);
        }
        selectList.clear();
        notifyDataSetChanged();
    }

    public void SelectAllitems() {
        if (!isSelectAll) {
            selectList.clear();
            selectList.addAll(list);
        } else {
            selectList.clear();
        }
        isSelectAll = !isSelectAll;
        viewModel.setText(String.valueOf(selectList.size()));
        notifyDataSetChanged();
    }
}

class MydataView extends RecyclerView.ViewHolder {
    TextView txtname, txtage, txtcity, txt_phone_number, txtemail, txtpassword;
    ImageView checkbox;

    public MydataView(@NonNull View itemView) {
        super(itemView);

        txtname = itemView.findViewById(R.id.txtname);
        txtage = itemView.findViewById(R.id.txtage);
        txtcity = itemView.findViewById(R.id.txtcity);
        txt_phone_number = itemView.findViewById(R.id.txtphone);
        txtemail = itemView.findViewById(R.id.txtemail);
        txtpassword = itemView.findViewById(R.id.txtpassword);
        checkbox = itemView.findViewById(R.id.check_box);
    }
}
