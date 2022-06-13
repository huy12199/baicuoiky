package models;

import java.io.Serializable;
import java.util.Date;

public class Bookroom implements Serializable {
    private String name;
    private String id;
    private String age;
    private Hotel hotel;
    private Date day1;
    private Date day2;

    public Bookroom() {
    }

    public Bookroom(String name, String id, String age, Hotel hotel, Date day1, Date day2) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hotel = hotel;
        this.day1 = day1;
        this.day2 = day2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getDay1() {
        return day1;
    }

    public void setDay1(Date day1) {
        this.day1 = day1;
    }

    public Date getDay2() {
        return day2;
    }

    public void setDay2(Date day2) {
        this.day2 = day2;
    }



    @Override
    public String toString() {
        return
                "name:" + name +
                ", id:" + id +
                ", age:" + age +
                ", hotel:" + hotel +
                ", day1:" + day1 +
                ", day2:" + day2 ;
    }
}
