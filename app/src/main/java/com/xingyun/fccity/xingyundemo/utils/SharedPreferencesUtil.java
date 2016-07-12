package com.xingyun.fccity.xingyundemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by fccity on 16/7/12.
 */

public class SharedPreferencesUtil {
    private static final String sharedPreferencesFileName = "xingyun";

    public static String getData(Context context, String key,
                                 String defaultValue) {
        try {

            return context.getSharedPreferences(sharedPreferencesFileName,
                    Context.MODE_PRIVATE).getString(key, defaultValue);
        } catch (NullPointerException e) {
            return defaultValue;
        }
    }

    public static boolean saveData(Context context, String key, String value) {
        try {
            SharedPreferences.Editor editor = context.getSharedPreferences(
                    sharedPreferencesFileName, Context.MODE_PRIVATE)
                    .edit();
            editor.putString(key, value);
            return editor.commit();
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static int getData(Context context, String key, int defaultValue) {
        try {
            return context.getSharedPreferences(sharedPreferencesFileName,
                    Context.MODE_PRIVATE).getInt(key, defaultValue);
        } catch (NullPointerException e) {
            return defaultValue;
        }
    }

    public static boolean saveData(Context context, String key, int value) {
        try {
            SharedPreferences.Editor editor = context.getSharedPreferences(
                    sharedPreferencesFileName, Context.MODE_PRIVATE)
                    .edit();
            editor.putInt(key, value);
            return editor.commit();
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static boolean getData(Context context, String key,
                                  boolean defaultValue) {
        try {
            return context.getSharedPreferences(sharedPreferencesFileName,
                    Context.MODE_PRIVATE).getBoolean(key, defaultValue);
        } catch (NullPointerException e) {
            return defaultValue;
        }
    }

    public static boolean saveData(Context context, String key, boolean value) {
        try {
            SharedPreferences.Editor editor = context.getSharedPreferences(
                    sharedPreferencesFileName, Context.MODE_PRIVATE)
                    .edit();
            editor.putBoolean(key, value);
            return editor.commit();
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static float getData(Context context, String key, float defaultVaule) {
        return context.getSharedPreferences(sharedPreferencesFileName,
                Context.MODE_PRIVATE).getFloat(key, defaultVaule);
    }

    public static boolean saveData(Context context, String key, float value) {
        try {
            SharedPreferences.Editor editor = context.getSharedPreferences(
                    sharedPreferencesFileName, Context.MODE_PRIVATE)
                    .edit();
            editor.putFloat(key, value);
            return editor.commit();
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static void clear(Context context) {
        context.getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE).edit().clear().commit();
    }
}