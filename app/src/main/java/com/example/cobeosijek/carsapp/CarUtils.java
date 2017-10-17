package com.example.cobeosijek.carsapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarUtils {

    public static List<Car> generateCars() {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("0", "Audi A4", "DJ-2000-TT", 2005, 300, "blabla"));
        carList.add(new Car("0", "Audi A4", "DJ-2000-TT", 2005, 300, "blabla"));
        carList.add(new Car("0", "Audi A4", "DJ-2000-TT", 2005, 300, "blabla"));
        carList.add(new Car("0", "Audi A4", "DJ-2000-TT", 2005, 300, "blabla"));
        carList.add(new Car("0", "Audi A4", "DJ-2000-TT", 2005, 300, "blabla"));
        carList.add(new Car("0", "Audi A4", "DJ-2000-TT", 2005, 300, "blabla"));
        carList.add(new Car("0", "Audi A4", "DJ-2000-TT", 2005, 300, "blabla"));

        return carList;
    }
}
