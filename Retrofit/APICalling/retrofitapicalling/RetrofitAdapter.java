package com.example.retrofitapicalling;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RetrofitAdapter extends RecyclerView.Adapter<MyView>
{
    private Context context;
    private List<RetrofitModel>list;

    public RetrofitAdapter(Context context,List<RetrofitModel>list){
        this.context=context;
        this.list=list;

    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.design,parent,false);
        MyView myView=new MyView(view);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        RetrofitModel model=list.get(position);
        holder.txtname.setText(model.getName());
        holder.txtrealname.setText(model.getRealname());
        holder.txt_team.setText(model.getTeam());
        holder.txt_firstapperence.setText(model.getFirstappearance());
        holder.txtcreatedby.setText(model.getCreatedby());
        holder.txtpublisher.setText(model.getPublisher());
        holder.txtbio.setText(model.getBio());

        Picasso.get().load(model.getImageurl()).into(holder.imgmovie);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, FullScreen.class);
                i.putExtra("name", model.getName());
                i.putExtra("realname", model.getRealname());
                i.putExtra("team", model.getTeam());
                i.putExtra("firstappearance", model.getFirstappearance());
                i.putExtra("createdby", model.getCreatedby());
                i.putExtra("publisher", model.getPublisher());
                i.putExtra("bio", model.getBio());
                i.putExtra("imageurl", model.getImageurl());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class MyView extends RecyclerView.ViewHolder{

    ImageView imgmovie;
    TextView txtname,txtrealname,txt_team,txt_firstapperence,txtcreatedby,txtpublisher,txtbio;
    public MyView(@NonNull View itemView) {
        super(itemView);

        imgmovie=itemView.findViewById(R.id.imgmovie);
        txtname=itemView.findViewById(R.id.txtname);
        txtrealname=itemView.findViewById(R.id.txtrealname);
        txt_team=itemView.findViewById(R.id.txt_team);
        txt_firstapperence=itemView.findViewById(R.id.txtfirstapperence);
        txtcreatedby=itemView.findViewById(R.id.txtcreatedby);
        txtpublisher=itemView.findViewById(R.id.txtpublisher);
        txtbio=itemView.findViewById(R.id.txtbio);
    }
}
