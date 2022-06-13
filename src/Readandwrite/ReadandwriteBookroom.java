package Readandwrite;

import models.Account;
import models.Bookroom;

import java.io.*;
import java.util.ArrayList;

public class ReadandwriteBookroom {
    public  void writer(ArrayList<Bookroom> bookrooms) {
        File file = new File("C:\\java\\baitapcodegym\\oop\\Baicuoiky\\bookroom.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(bookrooms);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Bookroom> readr() {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\java\\baitapcodegym\\oop\\Baicuoiky\\bookroom.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return  (ArrayList<Bookroom>) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.print("");
        } catch (ClassNotFoundException e) {
            System.out.print("");
        }
        return new ArrayList<>();
    }
}
