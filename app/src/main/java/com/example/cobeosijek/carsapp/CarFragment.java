package com.example.cobeosijek.carsapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarFragment extends Fragment {
    public static final String PAGE_NUMBER = "pageNumber";

    private int mPage;
    RecyclerView carRecycler;

    public static CarFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(PAGE_NUMBER, page);
        CarFragment fragment = new CarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(PAGE_NUMBER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car, container, false);

        carRecycler = view.findViewById(R.id.recycler_fragment);
        CarAdapter carAdapter = new CarAdapter();
        carAdapter.setCarList(CarUtils.generateCars());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(container.getContext(), DividerItemDecoration.VERTICAL);

        carRecycler.addItemDecoration(itemDecoration);
        carRecycler.setLayoutManager(layoutManager);
        carRecycler.setAdapter(carAdapter);

        return view;
    }
}