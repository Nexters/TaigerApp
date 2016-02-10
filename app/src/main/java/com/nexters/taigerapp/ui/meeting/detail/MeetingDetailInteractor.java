package com.nexters.taigerapp.ui.meeting.detail;

import android.content.Context;

import com.google.gson.Gson;
import com.kakao.usermgmt.response.model.UserProfile;
import com.nexters.taigerapp.persistance.UserManager;
import com.nexters.taigerapp.ui.comment.Comment;

import java.util.Date;

public class MeetingDetailInteractor {
    private UserManager userManager;
    private Gson gson;

    public MeetingDetailInteractor(Context context) {
        this.userManager = UserManager.getInstance(context);
        gson = new Gson();
    }

    public Comment saveComment(String commentStr) {
        UserProfile userProfile = gson.fromJson(userManager.getString(UserManager.USER_PROFILE.getName()),
                UserProfile.class);

        Comment comment = new Comment(userProfile.getNickname(), commentStr,
                userProfile.getProfileImagePath(), new Date());

        return comment;
    }
}
