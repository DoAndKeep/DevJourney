package com.doandkeep.devjourney.util;

import android.util.Log;

/**
 * Created by zhangtao on 16/7/21.
 */
public class DebugLog {

    private static final boolean IS_DEBUG = true;
    private static final int ERROR = 1;
    private static final int WARN = 2;
    private static final int INFO = 3;
    private static final int DEBUG = 4;
    private static final int VERBOSE = 5;
    private static final int LOG_LEVEL = VERBOSE;

    public static void v(String tag, String msg) {
        if (IS_DEBUG && LOG_LEVEL >= VERBOSE && msg != null) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (IS_DEBUG && LOG_LEVEL >= DEBUG && msg != null) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (IS_DEBUG && LOG_LEVEL >= INFO && msg != null) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (IS_DEBUG && LOG_LEVEL >= WARN && msg != null) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (IS_DEBUG && LOG_LEVEL >= ERROR && msg != null) {
            Log.e(tag, msg);
        }
    }
}
