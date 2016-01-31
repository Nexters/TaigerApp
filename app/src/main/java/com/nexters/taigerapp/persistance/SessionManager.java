package com.nexters.taigerapp.persistance;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * Created by BoBinLee on 2016. 1. 13..
 */
public class SessionManager {
    public static final String AUTH_TOKEN = "AUTH_TOKEN";

    private static SessionManager authManager;
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;
    private Context mContext;

    // Shared pref mode
    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "auth_manager";

    public SessionManager(Context context) {
        this.mContext = context;
        mPref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mPref.edit();
    }

    public static SessionManager getInstance(Context context) {
        if (authManager == null) {
            authManager = new SessionManager(context);
        }
        return authManager;
    }

    public void putString(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public void putBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    public void putInt(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    public void putSetString(String key, Set<String> value) {
        mEditor.putStringSet(key, value);
        mEditor.commit();
    }

    public Set<String> getSetString(String key) {
        return mPref.getStringSet(key, null);
    }

    public String getString(String key) {
        return mPref.getString(key, null);
    }

    public boolean getBoolean(String key) {
        return mPref.getBoolean(key, false);
    }
}
