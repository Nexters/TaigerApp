package com.nexters.taigerapp.ui.meeting.detail.popup;

public class MeetingDetailMapPresenter {
    MeetingDetailMapFragment meetingDetailMapFragment;
    MeetingDetailMapInteractor meetingDetailMapInteractor;

    public MeetingDetailMapPresenter(MeetingDetailMapFragment meetingDetailMapFragment) {
        this.meetingDetailMapFragment = meetingDetailMapFragment;
        meetingDetailMapInteractor = new MeetingDetailMapInteractor(meetingDetailMapFragment.getActivity());
    }

    public void refreshDestMapFragment() {
        MeetingDetailMap meetingDetailMap = meetingDetailMapInteractor.getMeetingDetailDestMap();
        meetingDetailMapFragment.refreshMapFragment(meetingDetailMap);
    }

    public void refreshDepartMapFragment() {
        MeetingDetailMap meetingDetailMap = meetingDetailMapInteractor.getMeetingDetailDepartMap();
        meetingDetailMapFragment.refreshMapFragment(meetingDetailMap);
    }
}
