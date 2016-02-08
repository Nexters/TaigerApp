package com.nexters.taigerapp.ui.destination;

import com.google.android.gms.location.places.Place;

public class DestinationPresenter implements OnDestinationListener {
    private DestinationActivity destinationActivity;
    private DestinationInteractor destinationInteractor;

    public DestinationPresenter(DestinationActivity destinationActivity) {
        this.destinationActivity = destinationActivity;
        this.destinationInteractor = new DestinationInteractor(destinationActivity);
    }

    public void refreshDestination(Place place) {
        destinationInteractor.saveDestination(place);
        destinationActivity.refreshDestName(String.valueOf(place.getName()));
    }
}
