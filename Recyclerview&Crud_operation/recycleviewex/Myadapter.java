package com.example.recycleviewex;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.viewholder> {
    private Context context;
    private ArrayList<Model> list;

    public Myadapter(Context context, ArrayList<Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_design, parent, false);
        viewholder viewHolder = new viewholder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Model model = list.get(position);

        holder.imagemobile.setImageResource(model.getImage());
        holder.txtname.setText(model.getName());
        holder.txtprice.setText(model.getPrice());

        holder.l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.update_design);

                EditText edt_m_name = dialog.findViewById(R.id.edt_edit_name);
                EditText edt_m_price = dialog.findViewById(R.id.edt_edit_price);
                Button btnaction = dialog.findViewById(R.id.btnadd);

                btnaction.setText("Update");

                edt_m_name.setText(list.get(position).getName());
                edt_m_price.setText(list.get(position).getPrice());

                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String m_name = edt_m_name.getText().toString();
                        String m_price = edt_m_price.getText().toString();

                        list.set(position, new Model(list.get(position).getImage(), m_name, m_price));
                        notifyItemChanged(position);

                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

        holder.l1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Title!");
                builder.setMessage("Are You Sure You Want to delete this?");
                builder.setIcon(R.drawable.baseline_delete_24);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        notifyItemRemoved(position);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView imagemobile;
        TextView txtname;
        TextView txtprice;
        LinearLayout l1;

        public viewholder(View itemView) {
            super(itemView);
            imagemobile = itemView.findViewById(R.id.img_mobile);
            txtname = itemView.findViewById(R.id.txt_name);
            txtprice = itemView.findViewById(R.id.txt_price);
            l1 = itemView.findViewById(R.id.l1);
        }
    }
}
