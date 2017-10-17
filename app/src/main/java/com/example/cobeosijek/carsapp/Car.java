package com.example.cobeosijek.carsapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class Car {

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
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getRegistration() {
        return registration;
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
