package com.nexters.taigerapp.ui.login;

public class LoginPresenter implements OnLoginListener {
    private LoginActivity loginActivity;
    private LoginInteractor loginInteractor;

    public LoginPresenter(LoginActivity loginActivity){
        this.loginActivity = loginActivity;
        this.loginInteractor = new LoginInteractor(this);
    }

    public void onCreate() {
        loginInteractor.create();
        loginActivity.create();
    }

    public void onDestroy() {
        loginInteractor.destroy();
    }

    @Override
    public void onUsernameError() {
        loginActivity.setUsernameError();
    }

    @Override
    public void onPasswordError() {
        loginActivity.setPasswordError();;
    }

    @Override
    public void redirectSignupActivity() {
        loginActivity.redirectSignupActivity();
    }

    @Override
    public void refreshActivity() {
        loginActivity.refreshActivity();
    }

    @Override
    public void redirectDepartureActivity() {
        loginActivity.redirectDepartureActivity();
    }
}
