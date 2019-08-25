package com.example.android.xue.seekbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

@SuppressLint("AppCompatCustomView")
public class MySeekbar extends SeekBar {
    public MySeekbar(Context context) {
        super(context,null);
    }

    public MySeekbar(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public MySeekbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
