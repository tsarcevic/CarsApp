package com.example.cobeosijek.carsapp.car_list;

import com.example.cobeosijek.carsapp.car_list.utils.BaseModel;

import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class Car extends BaseModel {

    private int id;
    private String model;
    private String registration;
    private int age;
    private int speed;
    private List<String> images;

    public Car(int id, String model, String registration, int age, int speed, List<String> images) {
        this.id = id;
        this.model = model;
        this.registration = registration;
        this.age = age;
        this.speed = speed;
        this.images = images;
    }

    public int getId() {
        return id;
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

    public List<String> getImages() {
        return images;
    }
}
