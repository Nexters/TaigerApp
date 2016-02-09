package com.nexters.taigerapp.ui.setting;

import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

public class SettingInteractor {
    private OnSettingListener onSettingListener;

    public SettingInteractor(OnSettingListener onSettingListener) {
        this.onSettingListener = onSettingListener;
    }

    public void logout() {
        UserManagement.requestLogout(new LogoutResponseCallback() {
            @Override
            public void onCompleteLogout() {
                onSettingListener.redirectLogin();
            }
        });
    }
}
