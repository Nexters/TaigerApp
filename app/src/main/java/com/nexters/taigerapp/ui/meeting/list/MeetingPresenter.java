package com.nexters.taigerapp.ui.meeting.list;

public class MeetingPresenter {
    private MeetingActivity meetingActivity;
    private MeetingInteractor meetingInteractor;

    public MeetingPresenter(MeetingActivity meetingActivity) {
        this.meetingActivity = meetingActivity;
        this.meetingInteractor = new MeetingInteractor();
    }


}
