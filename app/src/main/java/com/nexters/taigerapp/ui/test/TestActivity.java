package com.nexters.taigerapp.ui.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.ui.meeting.detail.popup.MeetingDetailPopupMapActivity;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button btn = (Button) findViewById(R.id.btn_test_1);
        btn.setOnClickListener(this);

        Button btn1 = (Button) findViewById(R.id.btn_test_2);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test_1:
                startActivity(new Intent(this, MeetingDetailPopupMapActivity.class));
                break;
            case R.id.btn_test_2:

                break;
        }
    }
}
