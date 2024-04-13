package com.example.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment_Chat_Adapter extends RecyclerView.Adapter<Chatfragmentview>
{
    private Context context;
    private ArrayList<Fragment_chat_Model>chatlist;

    public Fragment_Chat_Adapter(Context context,ArrayList<Fragment_chat_Model>chatlist){
        this.context=context;
        this.chatlist=chatlist;

    }

    private void setAnimation(View animation,int position){
        Animation slideIn= AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        animation.startAnimation(slideIn);
    }

    @NonNull
    @Override
    public Chatfragmentview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.chatfragmentdesign,parent,false);
        Chatfragmentview chatfragmentview=new Chatfragmentview(view);

        return chatfragmentview;
    }

    @Override
    public void onBindViewHolder(@NonNull Chatfragmentview holder, int position) {
            Fragment_chat_Model chatModel=chatlist.get(position);

            holder.imgchatfragment.setImageResource(chatModel.getChat_fragment_image());
            holder.chat_txt_name.setText(chatModel.getChat_fragment_name());
            holder.chat_txt_phone_number.setText(chatModel.getChat_fragment_phone_number());
            holder.chat_txt_adress.setText(chatModel.getChat_fragment_adress());
            setAnimation(holder.itemView,position);
    }

    @Override
    public int getItemCount() {
        return chatlist.size();
    }
}
class Chatfragmentview extends RecyclerView.ViewHolder{

    ImageView imgchatfragment;
    TextView chat_txt_name;
    TextView chat_txt_phone_number;
    TextView chat_txt_adress;
    public Chatfragmentview(@NonNull View itemView) {
        super(itemView);

        imgchatfragment=itemView.findViewById(R.id.imgfragmentchat);
        chat_txt_name=itemView.findViewById(R.id.fragment_chat_txt_name);
        chat_txt_phone_number=itemView.findViewById(R.id.fragment_chat_txt_phone_number);
        chat_txt_adress=itemView.findViewById(R.id.fragment_chat_txt_adress);


    }
}
