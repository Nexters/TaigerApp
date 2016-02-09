package com.nexters.taigerapp.ui.meeting.list;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.ToolbarActivity;
import com.nexters.taigerapp.ui.meeting.create.MeetingMakeMapActivity;
import com.nexters.taigerapp.ui.meeting.detail.MeetingDetailActivity;

public class MeetingActivity extends ToolbarActivity implements View.OnClickListener {

    private MeetingPresenter presenter;

    private DrawerLayout dlMeetingContent;
    private ActionBarDrawerToggle navToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_meeting, getString(R.string.title_activity_meeting));
        setupActionBar();
        presenter = new MeetingPresenter(this);
        setFragment(MeetingFragment.newInstance(presenter));

        dlMeetingContent = (DrawerLayout) findViewById(R.id.dl_meeting_content);
        dlMeetingContent.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        navToggle = new ActionBarDrawerToggle(this, dlMeetingContent, toolbar, R.string.drawer_open, R.string.drawer_close);
        dlMeetingContent.setDrawerListener(navToggle);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_meeting_create);
        fab.setOnClickListener(this);
    }

    private void setupActionBar() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu32);
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_content, fragment);
        fragmentTransaction.commit();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (navToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showMeetingDetail(long id) {
        Intent intent = new Intent(this, MeetingDetailActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void showMeetingMakeMap(){
        Intent intent = new Intent(this, MeetingMakeMapActivity.class);
        startActivity(intent);
    }
}
