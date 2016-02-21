package com.nexters.taigerapp.ui.meeting.detail.popup;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nexters.taigerapp.R;

public class MeetingDetailMapFragment extends Fragment {
    public final static String TAG = "MainFragment";

    private Activity activity;

    public static MeetingDetailMapFragment newInstance(Activity activity) {
        MeetingDetailMapFragment fragment = new MeetingDetailMapFragment();
        fragment.activity = activity;

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting_detail_popup_map, container, false);

        return view;
    }
}
