package models;

import java.io.Serializable;

public class Hotel implements Serializable {
    private String roomnumber;
    private String numberofpeoplein;
    private double roomRates;
    private boolean stust ;

    public Hotel() {
    }

    public Hotel(String roomnumber, String numberofpeoplein, double roomRates, boolean stust) {
        this.roomnumber = roomnumber;
        this.numberofpeoplein = numberofpeoplein;
        this.roomRates = roomRates;
        this.stust = stust;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getNumberofpeoplein() {
        return numberofpeoplein;
    }

    public void setNumberofpeoplein(String numberofpeoplein) {
        this.numberofpeoplein = numberofpeoplein;
    }

    public double getRoomRates() {
        return roomRates;
    }

    public void setRoomRates(double roomRates) {
        this.roomRates = roomRates;
    }

    public boolean getStust() {
        return stust;
    }

    public void setStust(boolean stust) {
        this.stust = stust;
    }

    @Override
    public String toString() {
        return
                "roomnumber :" + roomnumber  +
                ", numberofpeoplein :" + numberofpeoplein +
                ", roomRates :" + roomRates +
                ", stust :" + stust ;
    }
}
