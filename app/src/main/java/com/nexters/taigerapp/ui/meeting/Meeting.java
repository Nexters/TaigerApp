package com.nexters.taigerapp.ui.meeting;

import com.google.android.gms.maps.model.LatLng;
import com.nexters.taigerapp.network.response.model.User;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Meeting {
    private String title;
    private Date departureDate;
    private LatLng departureLatLng;
    private Date destinationDate;
    private LatLng destinationLatLng;
    private List<User> users;
    private int backgroundDrawableId;
    private Date createdAt;

    public Meeting(String title, Date departureDate){
        this.title = title;
        this.departureDate = departureDate;
    }
}
