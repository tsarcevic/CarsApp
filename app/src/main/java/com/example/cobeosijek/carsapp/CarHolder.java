package com.example.cobeosijek.carsapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by cobeosijek on 17/10/2017.
 */

class CarHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView carImage;
    TextView carModelText;
    TextView carYearText;

    private CarClickListener carListener;

    public CarHolder(View itemView, CarClickListener carListener) {
        super(itemView);

        carImage = itemView.findViewById(R.id.image_car);
        carModelText = itemView.findViewById(R.id.car_name);
        carYearText = itemView.findViewById(R.id.car_year);

        this.carListener = carListener;

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(carListener != null) {
            carListener.selectedCar(getAdapterPosition());
        }
    }

    public void setCarInfo(Car car) {
        String imageUrl = "https://auto.ndtvimg.com/car-images/medium/hyundai/verna/hyundai-verna.jpg?v=18";

        if (car != null) {
            Picasso.with(itemView.getContext()).load(imageUrl).into(carImage);
            carModelText.setText(car.getModel());
            carYearText.setText("Year of release: " + car.getAge());
        }
    }
}