package com.example.android.xue.AOP;

import android.content.Context;
import android.content.Intent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
    private Context mContext;
    private Object target;

    public MyHandler(Object target) {
        this.mContext = (Context) target;
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object invoke = null;
        if (Contents.isLogin) {
            invoke = method.invoke(target, objects);
        } else {
            Intent intent = new Intent().setClass(mContext, LoginActivity.class);
            mContext.startActivity(intent);
        }
        return invoke;
    }
}
