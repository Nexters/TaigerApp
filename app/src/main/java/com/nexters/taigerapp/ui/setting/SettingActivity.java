package com.nexters.taigerapp.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.ToolbarActivity;
import com.nexters.taigerapp.ui.login.LoginActivity;


public class SettingActivity extends ToolbarActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private SettingPresenter presenter;

    private Switch swApplyAlarm;
    private Switch swCommentAlarm;
    private Switch swCloseAlarm;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_setting, getString(R.string.title_setting));
        presenter = new SettingPresenter(this);

        swApplyAlarm = (Switch) findViewById(R.id.sw_apply_alarm);
        swCommentAlarm = (Switch) findViewById(R.id.sw_comment_alarm);
        swCloseAlarm = (Switch) findViewById(R.id.sw_close_alarm);
        btnLogout = (Button) findViewById(R.id.btn_logout);

        swApplyAlarm.setOnCheckedChangeListener(this);
        swCommentAlarm.setOnCheckedChangeListener(this);
        swCloseAlarm.setOnCheckedChangeListener(this);
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_logout :
                presenter.logout();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.sw_apply_alarm :
                // TODO
                break;
            case R.id.sw_comment_alarm :
                // TODO
                break;
            case R.id.sw_close_alarm :
                // TODO
                break;
        }
    }

    public void showLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
