package com.example.recyclerview_crud;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myview> {
    private Context context;
    private ArrayList<Model> list;
    int lsdtposition=-1;

    public Myadapter(Context context, ArrayList<Model> list) {
        this.context = context;
        this.list = list;
    }

    private void setAnimation(View viewToAnimate, int position){

            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(slideIn);
    }

    @NonNull
    @Override
    public Myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.design, parent, false);
        Myview myview = new Myview(view);

        return myview;

    }

    @Override
    public void onBindViewHolder(@NonNull Myview holder, int position) {
        Model model = list.get(position);

        holder.imgfriend.setImageResource(model.getImage());
        holder.txt_name.setText(model.getName());
        holder.txt_age.setText(model.getAge());
        holder.txt_adress.setText(model.getAdress());
        setAnimation(holder.itemView,position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.layout_design);

                EditText edtname = dialog.findViewById(R.id.edt_name);
                EditText edtage = dialog.findViewById(R.id.edt_age);
                EditText edtadress = dialog.findViewById(R.id.edt_adress);
                Button btnsubmit = dialog.findViewById(R.id.btnsubmit);
                TextView txtadd=dialog.findViewById(R.id.txt_add_details);


                btnsubmit.setText("Update");
                txtadd.setText("Update Details");
                edtname.setText(list.get(position).getName());
                edtage.setText(list.get(position).getAge());
                edtadress.setText(list.get(position).getAdress());

                btnsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = edtname.getText().toString();
                        String age = edtage.getText().toString();
                        String adress = edtadress.getText().toString();
                        list.set(position, new Model(list.get(position).getImage(), name, age, adress));
                        notifyItemChanged(position);

                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
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
}

class Myview extends RecyclerView.ViewHolder {


    ImageView imgfriend;
    TextView txt_name;
    TextView txt_age;
    TextView txt_adress;
    LinearLayout linearLayout;

    public Myview(@NonNull View itemView) {
        super(itemView);

        imgfriend = itemView.findViewById(R.id.img_sample);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_age = itemView.findViewById(R.id.txt_age);
        txt_adress = itemView.findViewById(R.id.txt_adress);
        linearLayout = itemView.findViewById(R.id.linearlayout);


    }



}
