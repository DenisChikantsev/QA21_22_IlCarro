package manager;

import models.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CarDataProvider {

    public Iterator<Object[]> CarPositiveAllFields() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Car.builder()
                        .location("Tel Aviv, Israel")
                        .manufacture("Mazda")
                        .model("M3")
                        .year("2022")
                        .fuel("Petrol")
                        .seats(4)
                        .carClass("C")
                        .carRegNumber("678-900-99991")
                        .price(50)
                        .about("Very nice car")
                        .build()
        });
        list.add(new Object[]{
                Car.builder()
                        .location("Tel Aviv, Israel")
                        .manufacture("BMW")
                        .model("M5")
                        .year("2017")
                        .fuel("Petrol")
                        .seats(4)
                        .carClass("C")
                        .carRegNumber("678-900-98991")
                        .price(75)
                        .about("Very nice car")
                        .build()
        });

        return list.iterator();
    }
}
