package com.example.cobeosijek.carsapp.car_details;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cobeosijek.carsapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 18/10/2017.
 */

public class CarPictureAdapter extends PagerAdapter {

    private List<String> imageList = new ArrayList<>();

    public void addImages (List<String> data) {
        imageList.clear();
        imageList.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(container.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_pager_picture, container, false);
        if (imageList != null && !imageList.isEmpty()) {
            ImageView imageView = itemView.findViewById(R.id.pager_image);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Picasso.with(imageView.getContext()).load(imageList.get(position)).into(imageView);
        }

        container.addView(itemView, 0);

        return itemView;
    }

}