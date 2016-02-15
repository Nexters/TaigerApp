package com.nexters.taigerapp.ui.meeting.list;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.common.collect.Lists;
import com.nexters.taigerapp.R;
import com.nexters.taigerapp.ui.meeting.Meeting;
import com.nexters.taigerapp.ui.meeting.MeetingLocation;

import java.util.List;

public class MeetingFragment extends Fragment {
    private MeetingPresenter presenter;

    private RecyclerView rvMeetingContent;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    private List<Meeting> meetings;
    private MeetingItemAdapter meetingItemAdapter;

    public MeetingFragment(MeetingPresenter presenter) {
        this.presenter = presenter;
    }

    public static MeetingFragment newInstance(MeetingPresenter presenter) {
        return new MeetingFragment(presenter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting, container, false);

        rvMeetingContent = (RecyclerView) view.findViewById(R.id.rv_meeting_content);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvMeetingContent.setLayoutManager(staggeredGridLayoutManager);

        meetings = getMeetings();
        meetingItemAdapter = new MeetingItemAdapter(view.getContext(), meetings, presenter);
        rvMeetingContent.setAdapter(meetingItemAdapter);

        return view;
    }

    public List<Meeting> getMeetings() {
        List<Meeting> meetings = Lists.newArrayList();

        for (int i = 0; i < 13; i++) {
            MeetingLocation location = new MeetingLocation();
            Meeting meeting = new Meeting("test", location);
            meetings.add(meeting);
        }
        return meetings;
    }
}
