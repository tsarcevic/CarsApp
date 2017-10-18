package com.example.cobeosijek.carsapp.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarUtils {

    public static List<Car> generateCars() {
        List<Car> carList = new ArrayList<>();
        List<String> pictureList = new ArrayList<>();

        pictureList.add("https://i.ytimg.com/vi/JBrUblpul50/maxresdefault.jpg");
        pictureList.add("https://preview.netcarshow.com/Audi-A4_2.0T-2005-1600-0e.jpg");
        pictureList.add("https://s1.cdn.autoevolution.com/images/gallery/AUDI-A4-1589_28.jpg");
        carList.add(new Car(0, "Audi A4", "DJ-2000-TT", 2005, 185, pictureList));
        pictureList = new ArrayList<>();
        pictureList.add("https://i.ytimg.com/vi/C_tMVDz8jmY/maxresdefault.jpg");
        carList.add(new Car(1, "BMW M3", "VK-2521-FA", 2014, 220, pictureList));
        pictureList = new ArrayList<>();
        pictureList.add("http://partsopen.com/images/1995-lada-niva-1.jpg");
        pictureList.add("https://c1.staticflickr.com/5/4020/4654505466_d7a97538e5_b.jpg");
        carList.add(new Car(2, "Lada Niva", "DJ-1233-LE", 1995, 140, pictureList));
        pictureList = new ArrayList<>();
        pictureList.add("http://starmoz.com/images/renault-clio-2008-13.jpg");
        carList.add(new Car(3, "Renault Clio", "OS-654-T", 2008, 165, pictureList));
        pictureList = new ArrayList<>();
        pictureList.add("http://trueautosite.com/wp-content/uploads/images/2012_Porsche_Cayenne_2835.jpg");
        pictureList.add("http://st.motortrend.com/uploads/sites/10/2015/09/2012-Porsche-Cayenne-Diesel-interior.jpg");
        pictureList.add("http://zombdrive.com/images/2012-porsche-cayenne-12.jpg");
        carList.add(new Car(4, "Porsche Cayenne", "OS-231-EU", 2012, 270, pictureList));
        pictureList = new ArrayList<>();
        pictureList.add("https://s1.cdn.autoevolution.com/images/gallery/AUDI-A3-3738_39.jpg");
        carList.add(new Car(5, "Audi A3", "BM-202-P", 2008, 205, pictureList));
        pictureList = new ArrayList<>();
        pictureList.add("https://images.carshop.co.uk/AF/62/AF62ZYK/AF62ZYK-used-MERCEDES-BENZ-E-CLASS-SALOON-SPECIAL-EDITION-E220-CDI-BlueEFFICIENCY-Executive-SE-4dr-Diesel-Manual-SILVER-2012-XC-L-10.jpg");
        pictureList.add("https://i.ytimg.com/vi/opHJiTmzmdM/maxresdefault.jpg");
        carList.add(new Car(6, "Mercedes E220", "VK-130-FO", 2012, 230, pictureList));
        pictureList = new ArrayList<>();
        pictureList.add("http://images.parkers.bauercdn.com/pagefiles/197414/driving-moving-exterior/073525200_1237889176.jpg");
        pictureList.add("https://preview.netcarshow.com/Ford-Focus_CMax-2003-1600-10.jpg");
        carList.add(new Car(7, "Ford Focus", "DJ-313-EL", 2003, 180, pictureList));
        pictureList = new ArrayList<>();
        pictureList.add("https://static.cargurus.com/images/site/2013/11/30/12/03/2009_ford_mustang_gt_premium-pic-2270367342948455522.jpeg");
        pictureList.add("https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/images/08q4/267373/2009-ford-mustang-and-mustang-convertible-photo-243609-s-original.jpg");
        carList.add(new Car(8, "Ford Mustang", "OS-1234-BK", 2009, 195, pictureList));
        pictureList = new ArrayList<>();
        pictureList.add("https://s1.cdn.autoevolution.com/images/gallery/TOYOTA-Yaris-5-Doors-4430_26.jpg");
        carList.add(new Car(9, "Toyota Yaris", "OS-666-HH", 2011, 170, pictureList));

        return carList;
    }
}
