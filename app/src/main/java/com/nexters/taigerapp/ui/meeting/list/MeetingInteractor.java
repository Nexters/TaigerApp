package com.nexters.taigerapp.ui.meeting.list;

import android.content.Context;

import com.google.gson.Gson;
import com.kakao.usermgmt.response.model.UserProfile;
import com.nexters.taigerapp.persistance.UserManager;

public class MeetingInteractor {

    private UserManager userManager;
    private Gson gson;


    public MeetingInteractor(Context context){
        userManager = UserManager.getInstance(context);
        gson = new Gson();
    }

    public UserProfile getUserProfile() {
        UserProfile userProfile = gson.fromJson(userManager.getString(UserManager.USER_PROFILE.getName()),
                UserProfile.class);
        return userProfile;
    }
}
