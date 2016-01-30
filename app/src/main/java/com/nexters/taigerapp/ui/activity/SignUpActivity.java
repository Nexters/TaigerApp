package com.nexters.taigerapp.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kakao.kakaotalk.callback.TalkResponseCallback;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.response.model.UserProfile;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.BaseActivity;
import com.nexters.taigerapp.common.widget.KakaoToast;
import com.nexters.taigerapp.network.request.user.UserInfoRequest;
import com.nexters.taigerapp.network.response.ResponseBody;
import com.nexters.taigerapp.network.response.model.User;

import cz.msebera.android.httpclient.Header;

public class SignupActivity extends BaseActivity {

    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignup = (Button) findViewById(R.id.btn_sign_up);

        initializeButtons();
    }

    private void initializeButtons(){
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSignup();
            }
        });
    }

    private void onClickSignup() {
        UserProfile userProfile = UserProfile.loadFromCache();
        AsyncHttpResponseHandler responseHandler = new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                User user = null;
                try {
                    user = new User(new ResponseBody(statusCode, responseBody));
                } catch (ResponseBody.ResponseBodyException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        };

        UserInfoRequest request = new UserInfoRequest(String.valueOf(userProfile.getId()), responseHandler);
        long id = userProfile.getId();


        request.request();
    }

    public abstract class KakaoTalkResponseCallback<T> extends TalkResponseCallback<T> {

        @Override
        public void onNotKakaoTalkUser() {
            KakaoToast.makeToast(self, "not a KakaoTalk user", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure(ErrorResult errorResult) {
            KakaoToast.makeToast(self, "failure : " + errorResult, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onSessionClosed(ErrorResult errorResult) {
            redirectLoginActivity();
        }

        @Override
        public void onNotSignedUp() {
            redirectLoginActivity();
        }

        @Override
        public void onDidStart() {
            showWaitingDialog();
        }

        @Override
        public void onDidEnd() {
            cancelWaitingDialog();
        }
    }
}
