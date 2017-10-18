package com.example.cobeosijek.carsapp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.carsapp.classes.Car;
import com.example.cobeosijek.carsapp.adapter.CarPictureAdapter;
import com.example.cobeosijek.carsapp.R;

public class CarDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_POSITION_DETAILS = "position";

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
        intent.putExtra(KEY_POSITION_DETAILS, car);

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
        carPictureAdapter = new CarPictureAdapter(this, car.getImages());
        picturePager.setAdapter(carPictureAdapter);
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
        if (getIntent().hasExtra(KEY_POSITION_DETAILS)) {
            car = (Car) getIntent().getSerializableExtra(KEY_POSITION_DETAILS);
        }
    }

    private void setText() {
        carName.setText(car.getModel() + "");
        carSpeed.setText("Speed: " + car.getSpeed());
        carRegistration.setText("Registration: " + car.getRegistration());
        carYear.setText("Age: " + car.getAge());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            this.onBackPressed();
        }
    }
}
