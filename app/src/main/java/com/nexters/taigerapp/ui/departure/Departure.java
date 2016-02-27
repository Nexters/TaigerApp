package com.nexters.taigerapp.ui.departure;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Departure {
    private String departName;
    private int departMeetingCount;
    private int departDestUserCount;
    private int departBackground;
}
