package com.nexters.taigerapp.ui.meeting.detail.popup;

import com.google.android.gms.maps.model.LatLng;

import lombok.Data;

@Data
public class MeetingDetailMap {
    private LatLng target;
    private String locationName;
    private String location;
}
