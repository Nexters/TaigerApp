package com.nexters.taigerapp.common;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.nexters.taigerapp.R;

public class ToolbarActivity extends BaseActivity {
    protected Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState, int layout, String title) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        setupActionBar(title);
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    private void setupActionBar(String title) {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(title);
            actionBar.setHomeButtonEnabled(true);
//            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu32);
        }
    }
}
