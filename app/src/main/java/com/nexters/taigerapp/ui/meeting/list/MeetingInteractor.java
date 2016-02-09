package com.nexters.taigerapp.ui.meeting.list;

import com.kakao.usermgmt.response.model.UserProfile;

public class MeetingInteractor {

    public String getUserProfilePath() {
        UserProfile userProfile = UserProfile.loadFromCache();
        return userProfile.getProfileImagePath();
    }
}
