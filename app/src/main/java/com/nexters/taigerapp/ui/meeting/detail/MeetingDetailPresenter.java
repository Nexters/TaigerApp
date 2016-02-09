package com.nexters.taigerapp.ui.meeting.detail;

public class MeetingDetailPresenter {
    private MeetingDetailActivity meetingDetailActivity;
    private MeetingDetailInteractor meetingDetailInteractor;

    public MeetingDetailPresenter(MeetingDetailActivity meetingDetailActivity) {
        this.meetingDetailActivity = meetingDetailActivity;
        this.meetingDetailInteractor = new MeetingDetailInteractor();
    }


}
