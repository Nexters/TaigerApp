package com.nexters.taigerapp.ui.signup;

import com.kakao.auth.Session;
import com.kakao.usermgmt.response.model.UserProfile;
import com.nexters.taigerapp.network.service.UserService;
import com.nexters.taigerapp.network.service.condition.UserCondition;
import com.nexters.taigerapp.network.response.model.AuthResult;

public class SignupInteractor {
    private UserService request = UserService.Factory.create();
    private OnSignupListener listener;

    public SignupInteractor(OnSignupListener listener) {
        this.listener = listener;
    }

    public void signup(String name, String age, String gender) {
        UserProfile userProfile = UserProfile.loadFromCache();
        long kakaoId = userProfile.getId();
        String kakaoToken = Session.getCurrentSession().getAccessToken();
        String nickname = userProfile.getNickname();

        UserCondition condition = new UserCondition(String.valueOf(kakaoId), kakaoToken, name, 0, 0);
        AuthResult result = request.register(condition);

        // TODO accessToken 등록
    }
}
