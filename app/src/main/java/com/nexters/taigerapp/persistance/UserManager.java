package com.nexters.taigerapp.persistance;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.gms.location.places.Place;
import com.nexters.taigerapp.ui.departure.Departure;

import java.util.Set;

public class UserManager {
    public static final Class AUTH = String.class;
    public static final Class DESTINATION = Place.class;
    public static final Class DEPARTURE = Departure.class;

    private static UserManager userManager;
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;
    private Context mContext;

    // Shared pref mode
    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "user_manager";

    public UserManager(Context context) {
        this.mContext = context;
        mPref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mPref.edit();
    }

    public static UserManager getInstance(Context context) {
        if (userManager == null) {
            userManager = new UserManager(context);
        }
        return userManager;
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
