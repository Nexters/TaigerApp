package com.nexters.taigerapp.ui.meeting.make;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.BaseActivity;

public class MeetingMakeIntroActivity extends BaseActivity implements View.OnClickListener {

    private Button btnMakeNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_make_intro);

        btnMakeNext = (Button) findViewById(R.id.btn_make_next);

        btnMakeNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_make_next :
                Intent intent = new Intent(this, MeetingMakeDepartureActivity.class);
                startActivity(intent);
                break;
        }
    }
}
