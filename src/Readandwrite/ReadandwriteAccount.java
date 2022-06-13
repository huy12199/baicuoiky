package Readandwrite;

import models.Account;
import models.Hotel;

import java.io.*;
import java.util.ArrayList;

public class ReadandwriteAccount {
        public  void writer(ArrayList<Account> accounts) {
            File file = new File("C:\\java\\baitapcodegym\\oop\\Baicuoiky\\account.txt");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(accounts);
                objectOutputStream.close();
                fileOutputStream.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public ArrayList<Account> readr() {
            try {
                FileInputStream fileInputStream = new FileInputStream("C:\\java\\baitapcodegym\\oop\\Baicuoiky\\account.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                return  (ArrayList<Account>) objectInputStream.readObject();
            } catch (IOException e) {
                System.out.print("");
            } catch (ClassNotFoundException e) {
                System.out.print("");
            }
            return new ArrayList<>();
        }
    }

