package com.nexters.taigerapp.ui.meeting.list;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.common.collect.Lists;
import com.kakao.usermgmt.response.model.UserProfile;
import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.ToolbarActivity;
import com.nexters.taigerapp.ui.meeting.make.MeetingMakeIntroActivity;
import com.nexters.taigerapp.ui.meeting.detail.MeetingDetailActivity;
import com.nexters.taigerapp.ui.setting.SettingActivity;
import com.nexters.taigerapp.ui.user.UserHistory;
import com.nexters.taigerapp.ui.user.UserHistoryItemAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MeetingActivity extends ToolbarActivity implements View.OnClickListener {

    private MeetingPresenter presenter;

    private DrawerLayout dlMeetingContent;
    private ActionBarDrawerToggle navToggle;

    // user
    private ImageView ivUserProfile;
    private TextView tvUserNickName;
    private ImageView ivUserSetting;

    private RecyclerView rvUserHistory;
    private LinearLayoutManager linearLayoutManager;
    private UserHistoryItemAdapter userItemAdapter;

    private List<UserHistory> userHistories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_meeting, getString(R.string.title_activity_meeting));
        presenter = new MeetingPresenter(this);
        setFragment(MeetingFragment.newInstance(presenter));

        dlMeetingContent = (DrawerLayout) findViewById(R.id.dl_meeting_content);
        dlMeetingContent.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        navToggle = new ActionBarDrawerToggle(this, dlMeetingContent, toolbar, R.string.drawer_open, R.string.drawer_close);
        dlMeetingContent.setDrawerListener(navToggle);

        // profile
        ivUserProfile = (ImageView) findViewById(R.id.iv_user_profile);
        tvUserNickName = (TextView) findViewById(R.id.tv_user_nickname);

        // userhistories
        rvUserHistory = (RecyclerView) findViewById(R.id.rv_user_history);
        linearLayoutManager = new LinearLayoutManager(this);
        rvUserHistory.setLayoutManager(linearLayoutManager);

        userHistories = getUserHistories();
        userItemAdapter = new UserHistoryItemAdapter(this, userHistories);
        rvUserHistory.setAdapter(userItemAdapter);

        // settings
        ivUserSetting = (ImageView) findViewById(R.id.iv_user_setting);
        ivUserSetting.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_meeting_create);
        fab.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.refreshUserProfile();
    }

    public void refreshUserProfile(UserProfile userProfile) {
        if (userProfile.getProfileImagePath() != null) {
            Picasso.with(this).load(userProfile.getProfileImagePath()).into(ivUserProfile);
        }
        tvUserNickName.setText(userProfile.getNickname());
    }

    public void refreshUserHistories(List<UserHistory> userHistories) {

    }

    @Override
    protected void setupActionBar(String title) {
        super.setupActionBar(title);
//        toolbar = (Toolbar) findViewById(R.id.tool_bar);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu32);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_meeting, menu);
        return true;
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_content, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_meeting_create:
                showMeetingMakeMap();
                break;
            case R.id.iv_user_setting:
                showSetting();
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

        switch (item.getItemId()) {
            case R.id.action_filter_all:

                break;
            case R.id.action_filter_depart:

                break;
            case R.id.action_filter_sex:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSetting() {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }

    public void showMeetingDetail(long id) {
        Intent intent = new Intent(this, MeetingDetailActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void showMeetingMakeMap() {
        Intent intent = new Intent(this, MeetingMakeIntroActivity.class);
        startActivity(intent);
    }

    public List<UserHistory> getUserHistories() {
        List<UserHistory> userHistories = Lists.newArrayList();

        UserHistory userHistory1 = new UserHistory("test1", 3);
        userHistories.add(userHistory1);
        UserHistory userHistory2 = new UserHistory("test2", 2);
        userHistories.add(userHistory2);
        UserHistory userHistory3 = new UserHistory("test3", 5);
        userHistories.add(userHistory3);

        return userHistories;
    }
}
