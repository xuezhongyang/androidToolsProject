package com.example.android.xue.util;

import android.text.TextUtils;

public class ConvertUtils {
    /**
     * 转换字符串为int
     *
     * @param str
     * @return
     */
    public static int toInt(String str) {
        return toInt(str, 0);
    }

    /**
     * 转换字符串为int
     *
     * @param str
     * @param def
     * @return
     */
    public static int toInt(String str, int def) {
        if (TextUtils.isEmpty(str)) {
            return def;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return def;
        }
    }
}
