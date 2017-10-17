package com.example.cobeosijek.carsapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapterHolder> {

    private List<Car> carList = new ArrayList<>();

    public void setCarList(List<Car> data) {
        carList.clear();
        carList.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public CarAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View carView = layoutInflater.inflate(R.layout.item_car, parent, false);
        return new CarAdapterHolder(carView);
    }

    @Override
    public void onBindViewHolder(CarAdapterHolder holder, int position) {
        Car car = carList.get(position);

        holder.setCarInfo(car);
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }
}
