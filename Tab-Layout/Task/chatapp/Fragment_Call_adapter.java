package com.example.chatapp;

import android.content.Context;
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
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.github.siyamed.shapeimageview.CircularImageView;

import java.util.ArrayList;

public class Fragment_Call_adapter extends RecyclerView.Adapter<Callfragmentview>
{
    private Context context;
    private ArrayList<Fragment_Call_Model>call_list;
    TextView tvempty;
    MainViewmodel mainViewmodel;
    ArrayList<String> callList=new ArrayList<>();
    boolean isEnabled=false;
    boolean isSelectall=false;
    ArrayList<String>call_List;


    public Fragment_Call_adapter(Context context,ArrayList<Fragment_Call_Model>call_list,TextView tvempty){
        this.context=context;
        this.call_list=call_list;
        this.tvempty=tvempty;

    }

    @NonNull
    @Override
    public Callfragmentview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.call_design,parent,false);
        Callfragmentview callfragmentview=new Callfragmentview(view);

        return callfragmentview;
    }

    @Override
    public void onBindViewHolder(@NonNull Callfragmentview holder, int position) {
        Fragment_Call_Model fragment_call_model = call_list.get(position);

        holder.imgcallfragment.setImageResource(fragment_call_model.getCall_image());
        holder.txt_call_frag_name.setText(fragment_call_model.getCall_name());
        holder.txt_call_frag_date.setText(fragment_call_model.getCall_date());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!isEnabled) {
                    ActionMode.Callback callback = new ActionMode.Callback() {
                        @Override
                        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                            MenuInflater menuInflater = mode.getMenuInflater();
                            menuInflater.inflate(R.menu.deletemenu, menu);

                            return true;
                        }

                        @Override
                        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                            isEnabled = true;
                            ClickItem(holder);
                               mainViewmodel.getText().observe((LifecycleOwner) context, new Observer<String>() {
                                   @Override
                                   public void onChanged(String s) {
                                       mode.setTitle(String.format("%s Selected",s));
                                   }
                               });
                            return true;
                        }

                        @Override
                        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                            int id = item.getItemId();

                            if (id == R.id.delete_menu) {
                                for (String s : callList) {
                                    call_list.remove(s);
                                }
                                if (call_list.size() == 0) {
                                    tvempty.setVisibility(View.VISIBLE);

                                }
                                mode.finish();

                            }
                            if (id == R.id.selectall_menu) {
                                if (callList.size() == call_list.size()) {
                                    isSelectall = false;
                                    callList.clear();
                                } else {
                                    isSelectall = true;
                                    callList.clear();
                                    callList.addAll(call_List);


                                }
                                mainViewmodel.setText(String.valueOf(callList.size()));
                                notifyDataSetChanged();
                            }
                            return true;
                        }

                        @Override
                        public void onDestroyActionMode(ActionMode mode) {
                            isEnabled = false;
                            isSelectall = false;
                            callList.clear();
                            notifyDataSetChanged();
                        }
                    };
                    ((AppCompatActivity) v.getContext()).startActionMode(callback);

                } else {
                    ClickItem(holder);
                }
                return true;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEnabled) {
                    ClickItem(holder);
                } else {
                    Toast.makeText(context, "You Have Clicked" + call_List.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (isSelectall) {
            holder.check_box.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.check_box.setVisibility(View.GONE);
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }

    }
   private void ClickItem(Callfragmentview holder){
        String s=call_List.get(holder.getAdapterPosition());
        if (holder.check_box.getVisibility()==View.GONE){
            holder.check_box.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundColor(Color.LTGRAY);
            callList.add(s);
        }
        else
        {
            holder.check_box.setVisibility(View.GONE);
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
            callList.remove(s);
        }
        mainViewmodel.setText(String.valueOf(callList.size()));
   }





        @Override
    public int getItemCount() {
        return call_list.size();
    }
}
class Callfragmentview extends RecyclerView.ViewHolder{
    CircularImageView imgcallfragment;
    TextView txt_call_frag_name;
    TextView txt_call_frag_date;
    TextView txt_select;
    ImageView check_box;


    public Callfragmentview(@NonNull View itemView) {
        super(itemView);

        imgcallfragment=itemView.findViewById(R.id.call_frag_img);
        txt_call_frag_name=itemView.findViewById(R.id.txt_call_frag_name);
        txt_call_frag_date=itemView.findViewById(R.id.txt_call_frag_date);
        txt_select=itemView.findViewById(R.id.text_view);
        check_box=itemView.findViewById(R.id.chack_box);
    }

}
