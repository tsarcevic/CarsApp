package com.example.cobeosijek.carsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarFragment extends Fragment implements CarClickListener {

    public static final String CARS_TYPE = "carType";

    RecyclerView carRecycler;
    CarAdapter carAdapter;

    List<Car> carList = new ArrayList<>();

    public static CarFragment newInstance(int carsType) {
        Bundle args = new Bundle();
        args.putInt(CARS_TYPE, carsType);
        CarFragment fragment = new CarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUI(view);
        getExtras();
    }

    private void setUI(View view) {
        carRecycler = view.findViewById(R.id.recycler_fragment);

        carAdapter = new CarAdapter();
        carAdapter.setCarClickListener(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);

        carRecycler.addItemDecoration(itemDecoration);
        carRecycler.setLayoutManager(layoutManager);
        carRecycler.setAdapter(carAdapter);
    }

    private void getExtras() {
        int carType = getArguments().getInt(CARS_TYPE);

        if (carType == Constants.ALL_CARS) {
            carList.addAll(CarUtils.generateCars());
            carAdapter.setCarList(carList);
        } else if (carType == Constants.FAVORITE_CARS) {
            for (Car car : CarUtils.generateCars())
                if (car.getAge() > 2010) {
                    carList.add(car);
                }
            carAdapter.setCarList(carList);
        }
    }

    @Override
    public void selectedCar(int position) {
        startActivity(CarDetailsActivity.getLaunchIntent(getActivity(), carList.get(position)));
    }
}