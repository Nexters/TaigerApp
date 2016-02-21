package com.nexters.taigerapp.ui.meeting.detail.popup;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.nexters.taigerapp.R;

public class MeetingDetailMapFragment extends Fragment {
    public final static String TAG = "MeetingDetailMapFragment";

    public final static String DEPART = "depart";
    public final static String DEST = "dest";

    private MeetingDetailPopupMapActivity activity;
    private MeetingDetailMapPresenter presenter;

    private TextView tvLocationName;
    private TextView tvLocation;
    private GoogleMap googleMap;

    private String type;

    public static MeetingDetailMapFragment newInstance(MeetingDetailPopupMapActivity activity, String type) {
        MeetingDetailMapFragment fragment = new MeetingDetailMapFragment();
        fragment.activity = activity;
        fragment.type = type;

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new MeetingDetailMapPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting_detail_popup_map, container, false);

        tvLocationName = (TextView) view.findViewById(R.id.tv_location_name);
        tvLocation = (TextView) view.findViewById(R.id.tv_location);

        if(type.equals(DEST)) {
            presenter.refreshDestMapFragment();
        } else {
            presenter.refreshDepartMapFragment();
        }
        return view;
    }

    public void refreshMapFragment(MeetingDetailMap meetingDetailMap) {
        tvLocation.setText(meetingDetailMap.getLocation());
        tvLocationName.setText(meetingDetailMap.getName());
    }
}
