package com.nexters.taigerapp.ui.meeting;

import com.google.android.gms.maps.model.LatLng;
import com.nexters.taigerapp.ui.user.User;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Meeting {
    private long id;
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
