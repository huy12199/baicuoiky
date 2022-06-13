package sort;

import models.Hotel;

import java.util.Comparator;

public class Sort implements Comparator<Hotel> {


    @Override
    public int compare(Hotel o1, Hotel o2) {
        if (o1.getRoomRates()>o2.getRoomRates()){
            return 1;
        }else return -1;
    }
}
