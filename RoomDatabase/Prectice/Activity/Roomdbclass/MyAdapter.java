package com.example.roomdbexam.Activity.Roomdbclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdbexam.R;
import com.google.android.material.textfield.TextInputEditText;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyView> {

    Context context;
    private List<UserModel>list=new ArrayList<>();
    private ViewModel viewModel;

    public MyAdapter(ViewModelStoreOwner owner,Context context,List<UserModel>list){
        this.context=context;
        this.list=list;
        this.viewModel = new ViewModelProvider(owner).get(ViewModel.class);

    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.design,parent,false);
        MyView myView=new MyView(view);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        UserModel model=list.get(position);

        holder.txtname.setText(model.getName());
        holder.txtage.setText(model.getAge());
        holder.txtemail.setText(model.getEmail());
        holder.txtpassword.setText(model.getPassword());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               DialogPlus dialogPlus=DialogPlus.newDialog(holder.itemView.getContext())
                       .setContentHolder(new ViewHolder(R.layout.update_design))
                       .setExpanded(true,ViewGroup.LayoutParams.WRAP_CONTENT)
                       .create();

                View myview = dialogPlus.getHolderView();

                TextInputEditText edtname=myview.findViewById(R.id.u_edtname);
                TextInputEditText edtage=myview.findViewById(R.id.u_edtage);
                TextInputEditText edtemail=myview.findViewById(R.id.u_edtemail);
                TextInputEditText edtpassword=myview.findViewById(R.id.u_edtpass);
                AppCompatButton btnupdate=myview.findViewById(R.id.btnupdate);


                edtname.setText(model.getName());
                edtage.setText(model.getAge());
                edtemail.setText(model.getEmail());
                edtpassword.setText(model.getPassword());

                btnupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name=edtname.getText().toString();
                        String age=edtage.getText().toString();
                        String email=edtemail.getText().toString();
                        String password=edtpassword.getText().toString();


                        UserModel updateuser=new UserModel(model.getId(),name,age,email,password);
                        viewModel.update(updateuser);
                        dialogPlus.dismiss();
                    }
                });
                dialogPlus.show();




            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setList(List<UserModel>list){
        this.list=list;
        notifyDataSetChanged();
    }
    public UserModel getUserAt(int position){
        return list.get(position);
    }
}
 class MyView extends RecyclerView.ViewHolder{

    TextView txtname,txtage,txtemail,txtpassword;
    public MyView(@NonNull View itemView) {
        super(itemView);

        txtname=itemView.findViewById(R.id.txtname);
        txtage=itemView.findViewById(R.id.txtage);
        txtemail=itemView.findViewById(R.id.txtemail);
        txtpassword=itemView.findViewById(R.id.txtpassword);



    }
}
