package com.example.datepicker_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

public class Progressbar extends AppCompatActivity {

//    TextView txtprogress;
//    ProgressBar loadingpb;
//    Button btnshowprogress;
//    boolean isprogressvisible=false;

        RatingBar ratingBar;
        Button btnrate;
        TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);

//        txtprogress=findViewById(R.id.txtprogress);
//        btnshowprogress=findViewById(R.id.showprogressbarbtn);
//        loadingpb=findViewById(R.id.idPBLoading);
//
//        btnshowprogress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isprogressvisible){
//                    btnshowprogress.setText("Show Progress Bar");
//                    loadingpb.setVisibility(View.GONE);
//                    isprogressvisible=false;
//                }
//                else
//                {
//                    isprogressvisible=true;
//                    btnshowprogress.setText("Hide Progress Bar");
//                    loadingpb.setVisibility(View.VISIBLE);
//                }
//            }
//        });
        ratingBar=findViewById(R.id.ratingbar);
        btnrate=findViewById(R.id.btnratesubmit);
        textView2=findViewById(R.id.text2);

        btnrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayerDrawable stars=(LayerDrawable)ratingBar.getProgressDrawable();
                stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
                textView2.setText("You Rated :"+String.valueOf(ratingBar.getRating()));

            }
        });


    }
}
