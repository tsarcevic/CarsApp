package com.example.cobeosijek.carsapp.car_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cobeosijek.carsapp.car_list.Car;
import com.example.cobeosijek.carsapp.interfaces.CarClickListener;
import com.example.cobeosijek.carsapp.car_list.CarHolder;
import com.example.cobeosijek.carsapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarHolder> {

    private List<Car> carList = new ArrayList<>();

    private CarClickListener carListener;

    public void setCarList(List<Car> data) {
        carList.clear();
        carList.addAll(data);
        notifyDataSetChanged();
    }

    public void setCarClickListener (CarClickListener itemCLickListener) {
        this.carListener = itemCLickListener;
    }

    @Override
    public CarHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View carView = layoutInflater.inflate(R.layout.item_car, parent, false);
        return new CarHolder(carView, carListener);
    }

    @Override
    public void onBindViewHolder(CarHolder holder, int position) {
        Car car = carList.get(position);

        holder.setCarInfo(car);
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }
}
