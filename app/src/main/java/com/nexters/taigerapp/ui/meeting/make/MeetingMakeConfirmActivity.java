package com.nexters.taigerapp.ui.meeting.make;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.BaseActivity;

public class MeetingMakeConfirmActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_make_confirm);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }
}
