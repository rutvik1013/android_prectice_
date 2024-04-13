package com.example.chatapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class ChatsFragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<Fragment_chat_Model>chatlist;
    private Fragment_Chat_Adapter chat_adapter;
    private Context context;

    public ChatsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_chats, container, false);

        recyclerView=view.findViewById(R.id.chatrecyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        ArrayList<Fragment_chat_Model>chatlist=new ArrayList<>();

        chatlist.add(new Fragment_chat_Model(R.drawable.img1,"Name: Babariya Rutvik","Phone-Number: 6351202084","Adress: Ahmedabad"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image2,"Name: Babariya Dhaval","Phone-Number: 9898765656","Adress: Rajkot"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image3,"Name: Babariya Jayraj","Phone-Number: 63512020644","Adress: Junagadh"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image4,"Name: Babariya Bhavesh","Phone-Number: 9898674567","Adress: Junagadh"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image5,"Name: Babariya Bhavin","Phone-Number: 6351202665","Adress: Ahmedabad"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image6,"Name: Babariya Mahipat","Phone-Number: 6355408385","Adress: Manavadar"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image7,"Name: Babariya Alpesh","Phone-Number: 9356798989","Adress: Manavadar"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image8,"Name: Babariya Parikshit","Phone-Number: 9367548989","Adress: Manavadar"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image9,"Name: Babariya Yuvraj","Phone-Number: 9355643231","Adress: Junagadh"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image10,"Name: Babariya Nayan","Phone-Number: 2156798989","Adress: Kolkata"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image11,"Name: Dayatar Vishal","Phone-Number: 1234567812","Adress: Vadodara"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image12,"Name: Dholakiya Ronak","Phone-Number: 7854564532","Adress: Rajkot"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image13,"Name: Jadeja Ruturaj","Phone-Number: 7854534345","Adress: Surendranagar"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image14,"Name: Karmata Raju","Phone-Number: 9564532456","Adress: Dhoraji"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image15,"Name: Shah Dhairya","Phone-Number: 9312346765","Adress: Upleta"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image16,"Name: Rajkotiya Pratik","Phone-Number: 2356788998","Adress: Ahmedabad"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image17,"Name: Ratanpara Utsav","Phone-Number: 9356564589","Adress: Ahmedabad"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image18,"Name: Dayatar Vivek","Phone-Number: 6756437890","Adress: Maliya"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image19,"Name: Babariya Haresh","Phone-Number: 9358998989","Adress: Thaniyana"));
        chatlist.add(new Fragment_chat_Model(R.drawable.image20,"Name: Babariya Jaydip","Phone-Number: 6767546789","Adress: Manavadar"));

         chat_adapter=new Fragment_Chat_Adapter(getActivity(),chatlist);
        recyclerView.setAdapter(chat_adapter);


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Fragment_chat_Model chatModeldelete=chatlist.get(viewHolder.getAdapterPosition());
                int position=viewHolder.getAdapterPosition();
                chatlist.remove(viewHolder.getAdapterPosition());
                chat_adapter.notifyItemRemoved(viewHolder.getAdapterPosition());


                Snackbar.make(recyclerView,chatModeldelete.getChat_fragment_name(),Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chatlist.add(position,chatModeldelete);

                        chat_adapter.notifyItemInserted(position);
                    }
                }).show();

            }
        }).attachToRecyclerView(recyclerView);

        return view;
    }


}
