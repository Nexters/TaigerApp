package com.nexters.taigerapp.ui.meeting.detail.popup;

import android.content.Context;

public class MeetingDetailMapInteractor {

    private Context context;

    public MeetingDetailMapInteractor(Context context) {
        this.context = context;
    }

    public MeetingDetailMap getMeetingDetailDestMap() {
        return new MeetingDetailMap();
    }

    public MeetingDetailMap getMeetingDetailDepartMap() {
        return new MeetingDetailMap();
    }
}
