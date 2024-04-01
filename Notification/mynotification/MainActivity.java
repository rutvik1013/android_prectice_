package com.example.mynotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private static final String CHENNAL_ID="My Chennal";
private static final int NOTIFICATION_ID=100;
private static final int REQUEST_CODE=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable= ResourcesCompat.getDrawable(getResources(),R.drawable.notification_,null);
        BitmapDrawable bitmapDrawable=(BitmapDrawable) drawable;
        Bitmap largeIcon=bitmapDrawable.getBitmap();

        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Intent i=new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent=PendingIntent.getActivity(this,REQUEST_CODE,i,PendingIntent.FLAG_UPDATE_CURRENT);

        // Big Picture

        Bitmap bigPictureBitmap = ((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.bmwx1, null)).getBitmap();
       NotificationCompat.BigPictureStyle bigPictureStyle=new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(bigPictureBitmap);
        bigPictureStyle .setBigContentTitle("Image Sent by Babariya Rutvik");
        bigPictureStyle.setSummaryText("Message Text");

        // inbox Style
        NotificationCompat.InboxStyle inboxStyle=new NotificationCompat.InboxStyle();
        inboxStyle.addLine("Hello My Name is Rutvik Babariya I am doing Android Developent At Ahmedabad");

        inboxStyle.setBigContentTitle("Full Details");
        inboxStyle.setSummaryText("Babariya Rutvik");

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setLargeIcon(largeIcon);
        builder.setSmallIcon(R.drawable.notification_);
        builder.setContentTitle("First Massege");
        builder.setContentText("New Massege from Babariya Rutvik");
        builder.setStyle(bigPictureStyle);
        builder.setOngoing(true);
        //builder.setStyle(inboxStyle);
        builder.setChannelId(CHENNAL_ID);
        builder.setContentIntent(pendingIntent);
        builder.build();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(new NotificationChannel(CHENNAL_ID,"My Chennal",NotificationManager.IMPORTANCE_HIGH));
        }
        notificationManager.notify(NOTIFICATION_ID,builder.build());


    }

}