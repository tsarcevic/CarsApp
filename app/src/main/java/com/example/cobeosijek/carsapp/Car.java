package com.example.cobeosijek.carsapp;

import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class Car extends BaseModel {

    private String id;
    private String model;
    private String registration;
    private int age;
    private int speed;
    private String images;

    public Car(String id, String model, String registration, int age, int speed, String images) {
        this.id = id;
        this.model = model;
        this.registration = registration;
        this.age = age;
        this.speed = speed;
        this.images = images;
    }

    public String getId() {
        return getValueOrEmpty(id);
    }

    public String getModel() {
        return getValueOrEmpty(model);
    }

    public String getRegistration() {
        return getValueOrEmpty(registration);
    }

    public int getAge() {
        return age;
    }

    public int getSpeed() {
        return speed;
    }

    public String getImages() {
        return images;
    }
}
