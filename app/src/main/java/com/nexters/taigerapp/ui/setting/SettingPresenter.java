package com.nexters.taigerapp.ui.setting;

public class SettingPresenter implements OnSettingListener {
    private SettingActivity settingActivity;
    private SettingInteractor settingInteractor;

    public SettingPresenter(SettingActivity settingActivity) {
        this.settingActivity = settingActivity;
        this.settingInteractor = new SettingInteractor(this);
    }

    public void logout() {
        settingInteractor.logout();
    }

    @Override
    public void redirectLogin() {
        settingActivity.showLogin();
    }
}
