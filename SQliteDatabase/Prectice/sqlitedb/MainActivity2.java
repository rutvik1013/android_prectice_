package com.example.sqlitedb;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sqlitedb.databinding.ActivityMain2Binding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    List<Model>list;
    ArrayList<HashMap<String,String>>arrayList=new ArrayList<>();
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        dbHelper=new DbHelper(this);

        list=new ArrayList<>();
        list=dbHelper.viewContancts();

        for (Model model:list){
            HashMap<String,String>hashMap=new HashMap<>();
            hashMap.put("NAME",model.getName());
            hashMap.put("PHONE_NUMBER",model.getPhone_number());
            arrayList.add(hashMap);

        }
        String[] from={"NAME","PHONE_NUMBER"};
        int[] to={R.id.txt1,R.id.txt2};


        SimpleAdapter adapter=new SimpleAdapter(getApplicationContext(),arrayList,R.layout.design,from,to);
        binding.listview.setAdapter(adapter);

        registerForContextMenu(binding.listview);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuItem m1=menu.add(0,1,0,"Update");
        MenuItem m2=menu.add(0,2,0,"Delete");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo acm=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id=acm.position;
        Model m=list.get(id);
        switch (item.getItemId()){
            case 1:
                Intent i=new Intent(getApplicationContext(), UpdateActivity.class);
                i.putExtra("id",m.getId());
                i.putExtra("name",m.getName());
                i.putExtra("phone_number",m.getPhone_number());
                startActivity(i);
                return true;

            case 2:
                AlertDialog.Builder alert=new AlertDialog.Builder(this);
                alert.setTitle("Are You Sure You Want to delete this Contancts?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbHelper.DeleteContacts(m.getId());
                        Intent intent=new Intent(getApplicationContext(), MainActivity2.class);
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                });
                alert.show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void finish() {
        super.finish();
    }
}