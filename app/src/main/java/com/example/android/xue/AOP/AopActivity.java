package com.example.android.xue.AOP;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.android.xue.R;

import java.lang.reflect.Proxy;

public class AopActivity extends AppCompatActivity implements ILogin, View.OnClickListener {
    ILogin proxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aop);
        //通过这个api产生一个代理对象
        proxy = (ILogin) Proxy.newProxyInstance(AopActivity.this.getClassLoader(), new Class[]{ILogin.class}, new MyHandler(this));
        findViewById(R.id.text).setOnClickListener(this);
    }

    @Override
    public void isLogin() {
        Intent intent = new Intent().setClass(this, MemberActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text:
                proxy.isLogin();
                break;
            default:
                break;
        }
    }
}
