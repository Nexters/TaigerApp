package com.nexters.taigerapp.ui.meeting.list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.BaseActivity;
import com.nexters.taigerapp.ui.meeting.Meeting;

import java.util.List;

public class MeetingActivity extends BaseActivity implements View.OnClickListener {

    private MeetingPresenter presenter;

    private RecyclerView rvMeetingContent;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    private List<Meeting> meetings;
    private MeetingItemAdapter meetingItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);
        presenter = new MeetingPresenter(this);

//        rvMeetingContent = (RecyclerView) findViewById(R.id.rv_)


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_meeting_create);
        fab.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_meeting_create :
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
        }
    }
}
