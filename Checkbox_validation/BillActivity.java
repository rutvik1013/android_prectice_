package com.example.checkbox_form;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BillActivity extends AppCompatActivity {

    TextView textView;
    private Context context=this;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        textView = findViewById(R.id.txtview);

        Intent i = getIntent();

        textView.setText(i.getStringExtra("Bill: "));

    }

//    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder builder=new AlertDialog.Builder(BillActivity.this);
//        builder.setMessage("Would You Like to Close this app?");
//
//        builder.setCancelable(false);
//
//
//        builder.setPositiveButton("Yes",(DialogInterface.OnClickListener) (dialog,which)->{
//            finishAffinity();
//        });
//        builder.setNegativeButton("No",(DialogInterface.OnClickListener) (dialog,which)->{
//            builder.create();
//        });
//        AlertDialog alertDialog=builder.create();
//        alertDialog.show();


    @Override
    public void onBackPressed() {
        Dialog dialog=new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog);

        Button button=dialog.findViewById(R.id.dialogButtonOK);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(context, "Dismiss!!", Toast.LENGTH_SHORT).show();
                finishAffinity();
            }
        });
        dialog.show();
    }
}
