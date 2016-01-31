package com.nexters.taigerapp.ui.login;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

public class LoginInteractor {
    private SessionCallback callback;

    public void create(OnLoginListener listener){
        callback = new SessionCallback(listener);
        Session.getCurrentSession().addCallback(callback);
        if (!Session.getCurrentSession().checkAndImplicitOpen()) {
           listener.onCreate();
        }
    }

    public void destroy() {
        Session.getCurrentSession().removeCallback(callback);
    }

    private boolean isLogin(String token){
        // TODO

        return false;
    }

    /**
     * 카카오 로그인 세션
     */
    private class SessionCallback implements ISessionCallback {
        private OnLoginListener listener;

        public SessionCallback(OnLoginListener listener){
            this.listener = listener;
        }

        @Override
        public void onSessionOpened() {
            String token = Session.getCurrentSession().getAccessToken();

            if(isLogin(token)) {
                listener.redirectDepartureActivity();
            } else {
                listener.redirectSignupActivity();
            }
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if(exception != null) {
                Logger.e(exception);
            }
            listener.refreshActivity();
        }
    }
}
