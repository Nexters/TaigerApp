package com.nexters.taigerapp.ui.signup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kakao.auth.Session;
import com.kakao.usermgmt.response.model.UserProfile;
import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.BaseActivity;
import com.nexters.taigerapp.network.request.TagierRestAdapter;
import com.nexters.taigerapp.network.request.UserRequest;
import com.nexters.taigerapp.network.request.condition.UserCondition;
import com.nexters.taigerapp.network.response.model.AuthResult;


public class SignupActivity extends BaseActivity {

    private UserRequest request = TagierRestAdapter.restTemplate.create(UserRequest.class);
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

        long kakaoId = userProfile.getId();
        String kakaoToken = Session.getCurrentSession().getAccessToken();
        String name = userProfile.getNickname();
        int age = 0;
        int gender = 0;

        UserCondition condition = new UserCondition(String.valueOf(kakaoId), kakaoToken, name, age, gender);
        AuthResult result = request.register(condition);


    }



}
