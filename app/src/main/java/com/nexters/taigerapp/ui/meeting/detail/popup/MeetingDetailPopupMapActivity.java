package com.nexters.taigerapp.ui.meeting.detail.popup;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

        meetingDetailMapDestFragment = MeetingDetailMapFragment.newInstance(this, MeetingDetailMapFragment.DEST);
        setFragment(R.layout.fragment_meeting_detail_popup_map, meetingDetailMapDestFragment);

        meetingDetailMapDepartFragment = MeetingDetailMapFragment.newInstance(this, MeetingDetailMapFragment.DEPART);
        setFragment(R.layout.fragment_meeting_detail_popup_map, meetingDetailMapDepartFragment);
    }

    private void setFragment(int layout, Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(layout, fragment);
        fragmentTransaction.commit();
    }
}
