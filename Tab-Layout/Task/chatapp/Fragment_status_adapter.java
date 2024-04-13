package com.example.chatapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.siyamed.shapeimageview.CircularImageView;

import java.util.ArrayList;

public class Fragment_status_adapter extends RecyclerView.Adapter<Statusfragmentview>
{
    private Context context;
    private ArrayList<Fragment_status_Model>statuslist;

    public Fragment_status_adapter(Context context,ArrayList<Fragment_status_Model>statuslist){
        this.context=context;
        this.statuslist=statuslist;
    }

    @NonNull
    @Override
    public Statusfragmentview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.status_design,parent,false);
        Statusfragmentview statusfragmentview=new Statusfragmentview(view);

        return statusfragmentview;
    }

    @Override
    public void onBindViewHolder(@NonNull Statusfragmentview holder, @SuppressLint("RecyclerView") int position) {
        Fragment_status_Model model=statuslist.get(position);

        holder.imgstatusfragment.setImageResource(model.getStatus_image());
        holder.status_txt_name.setText(model.getStatus_name());
        holder.status_txt_time.setText(model.getStatus_time());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context)
                        .setTitle("Mute Status Updates?")
                        .setMessage("New Status Updates From ... won't appear under recent updates anymore.")

                        .setPositiveButton("Mute", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                statuslist.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
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
        return statuslist.size();
    }
}
class Statusfragmentview extends RecyclerView.ViewHolder{

    CircularImageView imgstatusfragment;
    TextView status_txt_name;
    TextView status_txt_time;


    public Statusfragmentview(@NonNull View itemView) {
        super(itemView);

        imgstatusfragment=itemView.findViewById(R.id.status_frag_img);
        status_txt_name=itemView.findViewById(R.id.txt_status_frag_name);
        status_txt_time=itemView.findViewById(R.id.txt_status_frag_time);



    }
}

