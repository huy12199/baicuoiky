package Readandwrite;

import models.Hotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadandwriteHotel {
    public  void writer(ArrayList<Hotel> hotels) {
        File file = new File("C:\\java\\baitapcodegym\\oop\\Baicuoiky\\hotel.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hotels);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Hotel> readr() {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\java\\baitapcodegym\\oop\\Baicuoiky\\hotel.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return  (ArrayList<Hotel>) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.print("");
        } catch (ClassNotFoundException e) {
            System.out.print("");
        }
        return new ArrayList<>();
    }
}

