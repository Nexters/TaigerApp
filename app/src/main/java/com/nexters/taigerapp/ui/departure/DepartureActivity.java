package com.nexters.taigerapp.ui.departure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

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

    @NonNull
    private List<Departure> getDepartures() {
        List<Departure> departures = Lists.newArrayList();

        Departure departure1 = new Departure("사당", 1, 2, null);
        departures.add(departure1);
        Departure departure2 = new Departure("강남", 2, 3, null);
        departures.add(departure2);
        Departure departure3 = new Departure("홍대", 3, 4, null);
        departures.add(departure3);
        Departure departure4 = new Departure("신촌", 1, 2, null);
        departures.add(departure4);
        Departure departure5 = new Departure("건대", 2, 3, null);
        departures.add(departure5);
        Departure departure6 = new Departure("사당역?", 3, 4, null);
        departures.add(departure6);

        return departures;
    }

    public void showMeeting() {
        Intent intent = new Intent(this, MeetingActivity.class);
        startActivity(intent);
    }
}
