package com.nexters.taigerapp.ui.meeting;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

import lombok.Data;

@Data
public class MeetingLocation {
    private LatLng latLng;
    private String name;
    private Date date;
}
