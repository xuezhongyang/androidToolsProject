package com.example.android.xue.seekbar;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;

import com.example.android.xue.Notification.JumpActivity;
import com.example.android.xue.R;
import com.example.android.xue.util.ConvertUtils;

public class SeekbarActivity extends AppCompatActivity{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
