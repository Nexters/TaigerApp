package com.nexters.taigerapp.ui.departure;

import android.content.Context;

import com.google.gson.Gson;
import com.nexters.taigerapp.persistance.UserManager;

public class DepartureInteractor {
    private UserManager userManager;
    private Gson gson;

    public DepartureInteractor(Context context) {
        userManager = UserManager.getInstance(context);
        gson = new Gson();
    }

    public void saveDeparture(Departure departure) {
        String departureStr = gson.toJson(departure);
        userManager.putString(UserManager.DEPARTURE.getName(), departureStr);
    }

    public void saveUser(){
        userManager.getString(UserManager.DESTINATION.getName());

    }
}
