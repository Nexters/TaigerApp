package com.nexters.taigerapp.ui.destination;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.ToolbarActivity;

public class DestinationActivity extends ToolbarActivity implements View.OnClickListener {
    private static final int REQUEST_PLACE_PICKER = 1;

    private DestinationPresenter presenter;

    private TextView tvDestName;
    private ImageView ivDestSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,
                R.layout.activity_destination,
                getResources().getString(R.string.title_activity_destination));

        tvDestName = (TextView) findViewById(R.id.tv_dest_name);
        ivDestSearch = (ImageView) findViewById(R.id.iv_dest_search);
        ivDestSearch.setOnClickListener(this);

        presenter = new DestinationPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_dest_search :
                sendPlacePicker();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode != Activity.RESULT_OK){
            return ;
        }

        switch (requestCode){
            case REQUEST_PLACE_PICKER :
                presenter.refreshDestination(PlacePicker.getPlace(this, data));
                break;
        }
    }


    private void sendPlacePicker(){
        // BEGIN_INCLUDE(intent)
            /* Use the PlacePicker Builder to construct an Intent.
            Note: This sample demonstrates a basic use case.
            The PlacePicker Builder supports additional properties such as search bounds.
             */
        try {
            PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
            Intent intent = intentBuilder.build(this);
            // Start the Intent by requesting a result, identified by a request code.
            startActivityForResult(intent, REQUEST_PLACE_PICKER);
        } catch (GooglePlayServicesRepairableException e) {
            GooglePlayServicesUtil
                    .getErrorDialog(e.getConnectionStatusCode(), this, 0);
        } catch (GooglePlayServicesNotAvailableException e) {
            Toast.makeText(this, "Google Play Services is not available.",
                    Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void refreshDestName(String name){
        tvDestName.setText(name);
    }
}
