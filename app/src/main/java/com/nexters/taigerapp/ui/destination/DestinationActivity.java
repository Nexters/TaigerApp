package com.nexters.taigerapp.ui.destination;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.BaseActivity;
import com.nexters.taigerapp.ui.departure.DepartureActivity;

public class DestinationActivity extends BaseActivity implements View.OnClickListener, OnMapReadyCallback {
    private static final int REQUEST_PLACE_PICKER = 1;
    private static final double DEFAULT_RADIUS = 100;

    private DestinationPresenter presenter;

    private ViewSwitcher vsDestSwitcher;
    boolean isFirst = true;

    private GoogleMap googleMap;

    private TextView tvDestName;
    private ImageView ivDestSearch;
    private Button btnDestNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        vsDestSwitcher = (ViewSwitcher) findViewById(R.id.vs_dest_switcher);

        tvDestName = (TextView) findViewById(R.id.tv_dest_name);
        ivDestSearch = (ImageView) findViewById(R.id.iv_dest_search);
        ivDestSearch.setOnClickListener(this);
        btnDestNext = (Button) findViewById(R.id.btn_dest_next);
        btnDestNext.setOnClickListener(this);

        SupportMapFragment fgDestMap = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fg_dest_map);
        fgDestMap.getMapAsync(this);

        presenter = new DestinationPresenter(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_dest_search:
                sendPlacePicker();
                break;
            case R.id.btn_dest_next:
                sendDeparture();
                break;
        }
    }

    private void sendDeparture() {
        Intent intent = new Intent(this, DepartureActivity.class);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        switch (requestCode) {
            case REQUEST_PLACE_PICKER:
                Place place = PlacePicker.getPlace(this, data);

                if (place != null) {
                    presenter.refreshDestination(place);
                }
                break;
        }
    }

    private void sendPlacePicker() {
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

    public void focusDestMap(Place place) {
        LatLng latLng = place.getLatLng();

        CameraPosition position = new CameraPosition.Builder().target(latLng)
                .zoom(15.5f)
                .tilt(10)
                .build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(position));

        CircleOptions circleOptions = new CircleOptions()
                .center(latLng)
                .radius(DEFAULT_RADIUS)
                .fillColor(ContextCompat.getColor(this, R.color.red))
                .strokeWidth(0);
        googleMap.addCircle(circleOptions);
    }

    public void refreshDestName(String name) {
        tvDestName.setText(name);
    }

    public void setNextButtonName() {
        btnDestNext.setText(R.string.btn_next_dest);
    }

    public void enableDestMap() {
        if(isFirst) {
            vsDestSwitcher.showNext();
            isFirst = false;
        }
    }
}
