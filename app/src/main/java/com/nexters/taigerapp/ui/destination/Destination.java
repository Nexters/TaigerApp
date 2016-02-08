package com.nexters.taigerapp.ui.destination;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Destination {
    private LatLng latLng;
    private String destName;

    public Destination(Place place) {
        this.latLng = place.getLatLng();
        this.destName = String.valueOf(place.getName());
    }
}
