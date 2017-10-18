package com.example.cobeosijek.carsapp.adapter;

import android.content.Context;
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

    Context context;

    LayoutInflater layoutInflater;

    private List<String> imageList = new ArrayList<>();

    public CarPictureAdapter(Context context, List<String> data) {
        this.context = context;
        imageList.addAll(data);
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
        layoutInflater = LayoutInflater.from(container.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_pager_picture, container, false);

        ImageView imageView = itemView.findViewById(R.id.pager_image);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Picasso.with(context).load(imageList.get(position)).into(imageView);

        container.addView(itemView, 0);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        container.removeView((View) obj);
    }
}
