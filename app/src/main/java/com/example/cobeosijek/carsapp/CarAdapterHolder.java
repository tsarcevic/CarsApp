package com.example.cobeosijek.carsapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by cobeosijek on 17/10/2017.
 */

class CarAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView carImage;
    TextView carModelText;
    TextView carYearText;

    public CarAdapterHolder(View itemView) {
        super(itemView);

        carImage = itemView.findViewById(R.id.image_car);
        carModelText = itemView.findViewById(R.id.car_name);
        carYearText = itemView.findViewById(R.id.car_year);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), getAdapterPosition() + " hehe", Toast.LENGTH_SHORT).show();
    }

    public void setCarInfo(Car car) {
        if(car != null) {
            carModelText.setText(car.getModel());
            carYearText.setText("Year of release: " + car.getAge());
        }
    }
}
