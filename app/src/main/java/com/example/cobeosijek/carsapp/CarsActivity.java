package com.example.cobeosijek.carsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarsActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_MAIL_CARS_ACTIVITY = "mail";

    TextView eMailText;
    TextView toolbarText;
    ImageView backButtonImage;
    ImageView launcherImage;

    private String userMail;

    public static Intent getLaunchIntent(Context from, String mail) {
        Intent intent = new Intent(from, CarsActivity.class);
        intent.putExtra(KEY_MAIL_CARS_ACTIVITY, mail);

        return intent;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        getExtras();
        setUI();
        setText();
    }

    private void setText() {
        eMailText.setText(userMail);
    }

    private void setUI() {
        eMailText = findViewById(R.id.mail_text);
        toolbarText = findViewById(R.id.toolbar_text);
        backButtonImage = findViewById(R.id.back_button);
        launcherImage = findViewById(R.id.small_picture);

        backButtonImage.setOnClickListener(this);
    }

    private void getExtras() {
        userMail = getIntent().getStringExtra(KEY_MAIL_CARS_ACTIVITY);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            onBackPressed();
        }
    }
}
