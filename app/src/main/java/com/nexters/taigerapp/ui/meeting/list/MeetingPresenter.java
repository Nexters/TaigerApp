package com.nexters.taigerapp.ui.meeting.list;

import com.kakao.usermgmt.response.model.UserProfile;

public class MeetingPresenter {
    private MeetingActivity meetingActivity;
    private MeetingInteractor meetingInteractor;

    public MeetingPresenter(MeetingActivity meetingActivity) {
        this.meetingActivity = meetingActivity;
        this.meetingInteractor = new MeetingInteractor(meetingActivity.getApplicationContext());
    }

    public void showMeetingDetail(long id) {
        meetingActivity.showMeetingDetail(id);
    }

    public void refreshUserProfile() {
       UserProfile userProfile = meetingInteractor.getUserProfile();
        meetingActivity.refreshUserProfile(userProfile);
    }
}
