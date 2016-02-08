package com.nexters.taigerapp.ui.destination;

import android.content.Context;

import com.google.android.gms.location.places.Place;
import com.google.gson.Gson;
import com.nexters.taigerapp.persistance.UserManager;

public class DestinationInteractor {
    private UserManager userManager;
    private Gson gson;
    public DestinationInteractor(Context context) {
        this.userManager = UserManager.getInstance(context);
        gson = new Gson();
    }

    public void saveDestination(Place place) {
        Destination destination = new Destination(place);
        String destinationStr = gson.toJson(destination);

        userManager.putString(UserManager.DESTINATION.getName(), destinationStr);
    }
}
