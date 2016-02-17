package com.nexters.taigerapp.ui.user;

import android.os.Bundle;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.ToolbarActivity;

public class UserProfileActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_user_profile, getString(R.string.title_user_profile));


    }
}
