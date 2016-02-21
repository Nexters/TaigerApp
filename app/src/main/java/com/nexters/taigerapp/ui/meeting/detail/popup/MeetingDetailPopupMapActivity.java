package com.nexters.taigerapp.ui.meeting.detail.popup;

import android.app.Fragment;
import android.os.Bundle;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.BaseActivity;

public class MeetingDetailPopupMapActivity extends BaseActivity {

    private Fragment meetingDetailMapDestFragment;
    private Fragment meetingDetailMapDepartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_detail_popup_map);

        meetingDetailMapDepartFragment = MeetingDetailMapFragment.newInstance(this);

    }
}
