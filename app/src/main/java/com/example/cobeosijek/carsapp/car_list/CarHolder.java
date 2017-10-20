package com.example.cobeosijek.carsapp.car_list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.carsapp.R;
import com.example.cobeosijek.carsapp.car_list.Car;
import com.example.cobeosijek.carsapp.interfaces.CarClickListener;
import com.squareup.picasso.Picasso;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
        if (carListener != null) {
            carListener.onCarSelected(getAdapterPosition());
        }
    }

    public void setCarInfo(Car car) {
        if (car != null) {
            if (car.getImages() != null && !car.getImages().isEmpty()) {
                Picasso.with(carImage.getContext()).load(car.getImages().get(0)).into(carImage);
            }
            carModelText.setText(car.getModel());
            carYearText.setText(String.format(itemView.getContext().getString(R.string.year_of_release), car.getAge()));
        }
    }
}