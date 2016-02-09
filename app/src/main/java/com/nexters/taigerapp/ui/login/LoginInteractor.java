package com.nexters.taigerapp.ui.login;

import android.content.Context;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;
import com.nexters.taigerapp.persistance.UserManager;

public class LoginInteractor {
    private SessionCallback callback;
    private OnLoginListener listener;
    private UserManager userManager;

    public LoginInteractor(OnLoginListener listener, Context context) {
        this.listener = listener;
        this.userManager = UserManager.getInstance(context);
    }

    public void setup() {
        callback = new SessionCallback(listener);
        Session.getCurrentSession().addCallback(callback);
        if (Session.getCurrentSession().checkAndImplicitOpen()) {
            if (isLogin()) {
                saveUserManage();
                listener.redirectDepartureActivity();
            } else {
                throw new LoginException(LoginException.CONNECT_ERROR);
            }
        }
    }

    private void saveUserManage(){
        // TODO
        UserProfile userProfile = UserProfile.loadFromCache();
//        User user = new User();
    }

    public void destroy() {
        Session.getCurrentSession().removeCallback(callback);
    }

    private boolean isLogin() {
        String token = Session.getCurrentSession().getAccessToken();
        // TODO
        return true;
    }

    /**
     * 카카오 로그인 세션
     */
    private class SessionCallback implements ISessionCallback {
        private OnLoginListener listener;

        public SessionCallback(OnLoginListener listener) {
            this.listener = listener;
        }

        @Override
        public void onSessionOpened() {
            if (isLogin()) {
                saveUserManage();
                listener.redirectDepartureActivity();
            } else {
                listener.redirectSignupActivity();
            }
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if (exception != null) {
                Logger.e(exception);
            }
            listener.refreshActivity();
        }
    }
}
