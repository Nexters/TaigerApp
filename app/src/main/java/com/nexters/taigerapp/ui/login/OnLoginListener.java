package com.nexters.taigerapp.ui.login;

public interface OnLoginListener {
    void onUsernameError();
    void onPasswordError();

    void redirectSignupActivity();
    void refreshActivity();
    void redirectDepartureActivity();
}
