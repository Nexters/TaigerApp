package com.nexters.taigerapp.ui.departure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.google.common.collect.Lists;
import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.ToolbarActivity;
import com.nexters.taigerapp.ui.meeting.list.MeetingActivity;

import java.util.List;

public class DepartureActivity extends ToolbarActivity {

    private DeparturePresenter presenter;

    private RecyclerView rvDepartureContent;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    private List<Departure> departures;
    private DepartureItemAdapter departureItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,
                R.layout.activity_departure,
                getString(R.string.title_activity_departure));
        presenter = new DeparturePresenter(this);

        rvDepartureContent = (RecyclerView) findViewById(R.id.rv_departure_content);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvDepartureContent.setLayoutManager(staggeredGridLayoutManager);

        departures = getDepartures();
        departureItemAdapter = new DepartureItemAdapter(this, departures, presenter);
        rvDepartureContent.setAdapter(departureItemAdapter);
    }

    @Override
    protected void setupActionBar(String title) {
        super.setupActionBar(title);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        ImageView ivActionTitle = (ImageView) toolbar.findViewById(R.id.iv_action_title);
        ivActionTitle.setVisibility(View.VISIBLE);
    }

    @NonNull
    private List<Departure> getDepartures() {
        List<Departure> departures = Lists.newArrayList();

        Departure departure1 = new Departure("사당", 1, 2, R.drawable.departure_sadang);
        departures.add(departure1);
        Departure departure2 = new Departure("강남", 2, 3, R.drawable.departure_gangnam);
        departures.add(departure2);
        Departure departure3 = new Departure("홍대", 3, 4, R.drawable.departure_hongdae);
        departures.add(departure3);
        Departure departure4 = new Departure("신촌", 1, 2, R.drawable.departure_sincheon);
        departures.add(departure4);
        Departure departure5 = new Departure("서울역", 2, 3, R.drawable.departure_seoulstation);
        departures.add(departure5);
        Departure departure6 = new Departure("건대", 3, 4, R.drawable.departure_kunkok);
        departures.add(departure6);

        return departures;
    }

    public void showMeeting() {
        Intent intent = new Intent(this, MeetingActivity.class);
        startActivity(intent);
    }
}
