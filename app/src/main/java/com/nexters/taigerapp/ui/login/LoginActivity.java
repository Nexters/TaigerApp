package com.nexters.taigerapp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.kakao.auth.Session;
import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.BaseActivity;
import com.nexters.taigerapp.ui.destination.DestinationActivity;
import com.nexters.taigerapp.ui.signup.SignupActivity;

public class LoginActivity extends BaseActivity {
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new LoginPresenter(this);
        presenter.onCreate();
    }

    public void create() {
        setContentView(R.layout.activity_login);
    }

    public void refreshActivity(){
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void setUsernameError() {
        Toast.makeText(this, LoginException.USER_NAME_ERROR, Toast.LENGTH_LONG).show();
    }

    public void setPasswordError() {
        Toast.makeText(this, LoginException.PASSWORD_ERROR, Toast.LENGTH_LONG).show();
    }

    public void redirectSignupActivity() {
        final Intent intent = new Intent(this, SignupActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }

    public void redirectDepartureActivity() {
        final Intent intent = new Intent(this, DestinationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }
}
