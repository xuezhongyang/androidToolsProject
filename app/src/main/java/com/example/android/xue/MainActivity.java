package com.example.android.xue;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;

import com.example.android.xue.Notification.JumpActivity;
import com.example.android.xue.Notification.NotificationActivity;
import com.example.android.xue.util.ConvertUtils;

import java.text.DecimalFormat;

import static com.example.android.xue.Base.Content.NOTIFICATION_ID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_notification).setOnClickListener(this);
        findViewById(R.id.bt_num).setOnClickListener(this);
        textView = findViewById(R.id.tv_num);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_notification) {
            sendNotification();
            return;
        }

        if (view.getId() == R.id.bt_num) {
            javaNumTool("11001");
            return;
        }
    }

    private void javaNumTool(String num) {
        int n = ConvertUtils.toInt(num);
        if (n >= 10000) {
            String s = String .format("%.1f",n/10000.0);
            textView.setText(s + "w");
            return;
        }
        textView.setText(num);
    }

    /**
     * 手动发送一个通知
     */
    private void sendNotification() {
        //设置点击通知跳转的activity
        Intent resultIntent = new Intent(this, JumpActivity.class);
//        resultIntent.putExtra("friendId", srcUin);

        Intent mIntent = new Intent(this, MainActivity.class);//点击返回的界面
        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        Intent[] intents = new Intent[]{mIntent, resultIntent};


        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, MainActivity.class);
//            PendingIntent pendingIntent = PendingIntent.getActivity(this, 100, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 100, intents, PendingIntent.FLAG_UPDATE_CURRENT);

        if (Build.VERSION.SDK_INT >= 26) {
            //当sdk版本大于26
            String id = "channel_1";
            String description = "143";
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel channel = new NotificationChannel(id, description, importance);
//                     channel.enableLights(true);
//                     channel.enableVibration(true);//
            manager.createNotificationChannel(channel);
            Notification notification = new Notification.Builder(MainActivity.this, id)
                    .setCategory(Notification.CATEGORY_MESSAGE)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("This is a content title")
                    .setContentText("This is a content text")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build();
            manager.notify(1, notification);
        } else {
            //当sdk版本小于26
            Notification notification = new NotificationCompat.Builder(MainActivity.this)
                    .setContentTitle("This is content title")
                    .setContentText("This is content text")
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .build();
            manager.notify(1, notification);
        }

    }

}
