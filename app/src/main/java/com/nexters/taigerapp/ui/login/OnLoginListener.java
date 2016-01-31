package com.nexters.taigerapp.ui.login;

public interface OnLoginListener {
    void onCreate();
    void onDestroy();

    void onUsernameError();
    void onPasswordError();

    void redirectSignupActivity();
    void refreshActivity();
    void redirectDepartureActivity();
}
