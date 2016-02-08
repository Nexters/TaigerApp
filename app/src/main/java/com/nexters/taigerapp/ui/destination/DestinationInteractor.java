package com.nexters.taigerapp.ui.destination;

import android.content.Context;

import com.google.android.gms.location.places.Place;
import com.google.gson.Gson;
import com.nexters.taigerapp.persistance.UserManager;

public class DestinationInteractor {
    private UserManager userManager;

    public DestinationInteractor(Context context) {
        this.userManager = UserManager.getInstance(context);
    }

    public void saveDestination(Place place) {
        Gson gson = new Gson();
        String placeStr = gson.toJson(place);

        userManager.putString(UserManager.PLACE.getName(), placeStr);
    }
}
