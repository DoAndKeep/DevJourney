package com.doandkeep.devjourney.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具类
 * Created by zhangtao on 2016/12/15.
 */

public class ToastUtils {
    public static void showSuccessToase(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showErrorToase(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
