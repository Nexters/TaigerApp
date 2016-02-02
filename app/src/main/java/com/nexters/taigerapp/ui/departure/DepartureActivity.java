package com.nexters.taigerapp.ui.departure;

import android.os.Bundle;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.ToolbarActivity;

public class DepartureActivity extends ToolbarActivity {
    String TAG = "DepartureActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,
                R.layout.activity_departure,
                getResources().getString(R.string.title_activity_departure));
    }

}
