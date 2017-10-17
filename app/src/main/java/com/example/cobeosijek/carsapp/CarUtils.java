package com.example.cobeosijek.carsapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarUtils {

    public static List<Car> generateCars() {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("0", "Audi A4", "DJ-2000-TT", 2005, 185, "blabla"));
        carList.add(new Car("1", "BMW M3", "VK-2521-FA", 2014, 220, "blabla"));
        carList.add(new Car("2", "Lada Niva", "DJ-1233-LE", 1995, 140, "blabla"));
        carList.add(new Car("3", "Renault Clio", "OS-654-T", 2008, 165, "blabla"));
        carList.add(new Car("4", "Porsche Cayenne", "OS-231-EU", 2012, 270, "blabla"));
        carList.add(new Car("5", "Audi A3", "BM-202-P", 2008, 205, "blabla"));
        carList.add(new Car("6", "Mercedes E220", "VK-130-FO", 2012, 230, "blabla"));
        carList.add(new Car("7", "Ford Focus", "DJ-313-EL", 2003, 180, "blabla"));
        carList.add(new Car("8", "Ford Mustang", "OS-1234-BK", 2009, 195, "blabla"));
        carList.add(new Car("9", "Toyota Yaris", "OS-666-HH", 2011, 170, "blabla"));

        return carList;
    }
}
