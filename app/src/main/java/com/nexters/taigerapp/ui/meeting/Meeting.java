package com.nexters.taigerapp.ui.meeting;

import com.google.common.collect.Lists;
import com.nexters.taigerapp.ui.user.User;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Meeting {
    private long id;
    private String title;
    private MeetingLocation departure = new MeetingLocation();
    private MeetingLocation destination = new MeetingLocation();
    private List<User> users = Lists.newArrayList();
    private int backgroundDrawableId;
    private Date createdAt;

    public Meeting(String title, MeetingLocation departure){
        this.title = title;
        this.departure = departure;
    }
}
