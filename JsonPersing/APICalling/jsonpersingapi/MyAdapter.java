package com.example.jsonpersingapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<JsonModel> list;

    public MyAdapter(Context context, List<JsonModel> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.design_file, parent, false);


            ImageView imagemovie = view.findViewById(R.id.imagemovie);
            TextView txtname = view.findViewById(R.id.txtname);
            TextView txtrealname = view.findViewById(R.id.txtrealname);
            TextView txt_team = view.findViewById(R.id.txt_team);
            TextView txtfirstapperence = view.findViewById(R.id.txt_firstapperence);
            TextView createdby = view.findViewById(R.id.txt_createdby);
            TextView publisher = view.findViewById(R.id.txt_publisher);
            TextView txtbio = view.findViewById(R.id.txt_bio);


            JsonModel model = list.get(position);

            txtname.setText(model.getName());
            txtrealname.setText(model.getRealname());
            txt_team.setText(model.getTeam());
            txtfirstapperence.setText(model.getFirstappearance());
            createdby.setText(model.getCreatedby());
            publisher.setText(model.getPublisher());
            txtbio.setText(model.getBio());

            // Picasso to get image from server api
            Picasso.get().load(model.getImageurl()).into(imagemovie);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, FullScreenactivity.class);
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
        return view;
    }
}
