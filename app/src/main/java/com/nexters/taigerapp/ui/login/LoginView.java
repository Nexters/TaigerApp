package com.nexters.taigerapp.ui.login;

public interface LoginView {
    void setUsernameError();
    void setPasswordError();

    void redirectSignupActivity();
    void refreshActivity();
}
