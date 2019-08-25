package com.example.android.xue.Notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action.equals("com.example.android.xue.click")) {
            //处理点击事件
            System.out.println("click");
        }

        if (action.equals("com.example.android.xue.cancel")) {
            //处理滑动清除和点击删除事件
            System.out.println("cancel");
        }
    }
}
