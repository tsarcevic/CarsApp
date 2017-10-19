package com.example.cobeosijek.carsapp.car_details;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.carsapp.car_list.Car;
import com.example.cobeosijek.carsapp.R;

import me.relex.circleindicator.CircleIndicator;

public class CarDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_CARLIST_DETAILS = "car_list";

    TextView carName;
    TextView carYear;
    TextView carSpeed;
    TextView carDetails;
    TextView carRegistration;
    ViewPager picturePager;
    ImageView backButton;

    CarPictureAdapter carPictureAdapter;

    Car car;

    public static Intent getLaunchIntent(Context from, Car car) {
        Intent intent = new Intent(from, CarDetailsActivity.class);
        intent.putExtra(KEY_CARLIST_DETAILS, car);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        setUI();
        getExtras();
        setAdapter();
        setText();
    }

    private void setAdapter() {
        // TODO: 19/10/2017 setimages method insted of constructor
        carPictureAdapter = new CarPictureAdapter(car.getImages());
        CircleIndicator circleIndicator = findViewById(R.id.indicator);
        picturePager.setAdapter(carPictureAdapter);
        if (carPictureAdapter.getCount() > 1) {
            circleIndicator.setViewPager(picturePager);
        }
    }

    private void setUI() {
        carName = findViewById(R.id.car_name);
        carYear = findViewById(R.id.car_year);
        carSpeed = findViewById(R.id.car_speed);
        carDetails = findViewById(R.id.toolbar_text);
        carRegistration = findViewById(R.id.car_registration);
        picturePager = findViewById(R.id.image_pager);
        backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(this);
    }

    private void getExtras() {
        if (getIntent().hasExtra(KEY_CARLIST_DETAILS)) {
            car = (Car) getIntent().getSerializableExtra(KEY_CARLIST_DETAILS);
        }
    }

    private void setText() {
        if (car != null) {
            carName.setText(car.getModel());
            carSpeed.setText(String.format((getString(R.string.car_speed)), car.getSpeed()));
            carRegistration.setText(String.format((getString(R.string.car_registration)), car.getRegistration()));
            carYear.setText(String.format((getString(R.string.car_year)), car.getAge()));
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            onBackPressed();
        }
    }
}
