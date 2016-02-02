package com.nexters.taigerapp.ui.destination;

import android.os.Bundle;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.ToolbarActivity;

public class DestinationActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,
                R.layout.activity_destination,
                getResources().getString(R.string.title_activity_destination));
    }
}
