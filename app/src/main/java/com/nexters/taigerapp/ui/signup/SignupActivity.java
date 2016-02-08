package com.nexters.taigerapp.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.common.BaseActivity;
import com.nexters.taigerapp.ui.departure.DepartureActivity;


public class SignupActivity extends BaseActivity implements View.OnClickListener {
    private SignupPresenter presenter;
    private Button btnSignup;
    private EditText etName;
    private EditText etAge;
    private EditText etGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignup = (Button) findViewById(R.id.btn_sign_up);
        btnSignup.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.et_name);
        etAge = (EditText) findViewById(R.id.et_age);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sign_up :
                presenter.onSignup(etName.getText().toString(), etAge.getText().toString(), "");
                break;
        }
    }

    public void redirectDepartureActivity() {
        final Intent intent = new Intent(this, DepartureActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }
}
