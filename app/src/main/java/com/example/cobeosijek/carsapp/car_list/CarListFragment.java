package com.example.cobeosijek.carsapp.car_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cobeosijek.carsapp.R;
import com.example.cobeosijek.carsapp.car_details.CarDetailsActivity;
import com.example.cobeosijek.carsapp.car_list.utils.CarUtils;
import com.example.cobeosijek.carsapp.constants.Constants;
import com.example.cobeosijek.carsapp.interfaces.CarClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarListFragment extends Fragment implements CarClickListener {

    public static final String CARS_TYPE = "carType";

    RecyclerView carRecycler;
    CarListAdapter carListAdapter;

    List<Car> carList = new ArrayList<>();

    public static CarListFragment newInstance(int carsType) {
        Bundle args = new Bundle();
        args.putInt(CARS_TYPE, carsType);

        CarListFragment fragment = new CarListFragment();
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

        carListAdapter = new CarListAdapter();
        carListAdapter.setCarClickListener(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);

        carRecycler.addItemDecoration(itemDecoration);
        carRecycler.setLayoutManager(layoutManager);
        carRecycler.setAdapter(carListAdapter);
    }

    private void getExtras() {

        if (getArguments().getInt(CARS_TYPE) == Constants.ALL_CARS) {
            carList.addAll(CarUtils.generateCars());
            carListAdapter.setCarList(carList);
        } else if (getArguments().getInt(CARS_TYPE) == Constants.FAVORITE_CARS) {
            for (Car car : CarUtils.generateCars())
                if (car.getAge() > 2010) {
                    carList.add(car);
                }
            carListAdapter.setCarList(carList);
        }
    }

    @Override
    public void onCarSelected(int position) {
        startActivity(CarDetailsActivity.getLaunchIntent(getActivity(), carList.get(position)));
    }
}