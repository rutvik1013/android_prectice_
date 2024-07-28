package com.example.sqlitedbtask;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<MyDetailsView> {
    private Context context;
    private List<detailsModel> list;
    private DatabaseHelper databaseHelper;

    public DetailsAdapter(Context context, ArrayList<detailsModel> list, DatabaseHelper databaseHelper) {
        this.context = context;
        this.list = list;
        this.databaseHelper = databaseHelper;
    }

    @NonNull
    @Override
    public MyDetailsView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sqlitedesign, parent, false);
        return new MyDetailsView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDetailsView holder, int position) {
        detailsModel model = list.get(position); // Correctly get the model from the list

        holder.txtdate.setText(model.getDate());
        holder.txtname.setText(model.getName());
        holder.txtphone_number.setText(model.getPhone_number());
        holder.txtemail.setText(model.getEmail());
        holder.txtadress.setText(model.getAdress());

        holder.imgupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogPlus dialogPlus = DialogPlus.newDialog(holder.imgupdate.getContext())
                        .setContentHolder(new ViewHolder(R.layout.updatedesign))
                        .setExpanded(true,ViewGroup.LayoutParams.WRAP_CONTENT)
                        .create();

                View myview = dialogPlus.getHolderView();
                TextInputEditText date = myview.findViewById(R.id.edt_u_date);
                TextInputEditText name = myview.findViewById(R.id.edt_u_name);
                TextInputEditText phone_number = myview.findViewById(R.id.edt_u_phone);
                TextInputEditText email = myview.findViewById(R.id.edt_u_email);
                TextInputEditText adress = myview.findViewById(R.id.edt_u_adress);
                AppCompatButton btnupdate = myview.findViewById(R.id.btnupdate);

                // Populate the dialog with the current data
                date.setText(model.getDate());
                name.setText(model.getName());
                phone_number.setText(model.getPhone_number());
                email.setText(model.getEmail());
                adress.setText(model.getAdress());

                dialogPlus.show();

                btnupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        model.setDate(date.getText().toString());
                        model.setName(name.getText().toString());
                        model.setPhone_number(phone_number.getText().toString());
                        model.setEmail(email.getText().toString());
                        model.setAdress(adress.getText().toString());
                        databaseHelper.UpdateDetails(model);
                        notifyItemChanged(position);
                        dialogPlus.dismiss();
                    }
                });
            }
        });

        holder.imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(holder.imgdelete.getContext());
                alert.setTitle("DELETE?");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        databaseHelper.Deletedetails(model.getId());
                        list.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, list.size());
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                alert.show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MyDetailsView extends RecyclerView.ViewHolder {
    TextView txtdate, txtname, txtphone_number, txtemail, txtadress;
    ImageView imgupdate, imgdelete;

    public MyDetailsView(@NonNull View itemView) {
        super(itemView);

        txtdate = itemView.findViewById(R.id.txtdate);
        txtname = itemView.findViewById(R.id.txtname);
        txtphone_number = itemView.findViewById(R.id.txtnumber);
        txtemail = itemView.findViewById(R.id.txtemail);
        txtadress = itemView.findViewById(R.id.txtadress);
        imgupdate = itemView.findViewById(R.id.imgupdate);
        imgdelete = itemView.findViewById(R.id.imgdelete);
    }
}
