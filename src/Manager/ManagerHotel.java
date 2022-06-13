package Manager;

import Login.LoginAccount;
import Readandwrite.ReadandwriteHotel;
import models.Hotel;
import sort.Sort;
import validate.ValidateAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerHotel {
    Scanner scanner = new Scanner(System.in);
    ReadandwriteHotel readandwriteHotel = new ReadandwriteHotel();
    ArrayList<Hotel> hotels = readandwriteHotel.readr();

    public ManagerHotel() {
        readandwriteHotel.readr();
    }

    public void menuHotel() {
        boolean check = true;
        while (check) {
            System.out.println("==Menu==");
            System.out.println("1. hiển thị tất cả các phòng");
            System.out.println("2. thêm phòng của khách sạn");
            System.out.println("3. xóa ");
            System.out.println("4. tìm phòng ");
            switch (Integer.parseInt(ValidateAccount.Choice())) {
                case 1:
                    showHotel();
                    hotels.sort(new Sort());
                    break;
                case 2:
                    addHotel();
                    break;
                case 3:
                    detedel();
                    readandwriteHotel.writer(hotels);
                    break;
                case 4:
                    edit();
                    readandwriteHotel.writer(hotels);
                    break;
                case 5:
                    check = false;
                    break;
                default:
                    System.out.println("không tìm thấy chức năng vui lòng nhập đúng số");
            }
        }
    }

    public Hotel creatHotel() {
        String roomnumber;
        while (true) {
            System.out.println("Nhập địa chỉ phòng");
            roomnumber = scanner.nextLine();
            if (roomnumber.matches("[A-Za-z0-9]+")) {
                break;
            } else {
                System.out.println("bạn nhập không đúng kiểu [A-Za-z0-9]");
            }
        }


        String numberofpeoplein;
        while (true) {
            System.out.println("Nhập số người");
            numberofpeoplein = scanner.nextLine();
            if (numberofpeoplein.matches("[0-9]")) {
                break;
            } else {
                System.out.println("bạn nhập không đúng kiểu [0-9]");
            }
        }

        double roomRates = 0.0;
        while (true) {
            try {
                System.out.println("nhập giá phòng");
                roomRates = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("mời bạn nhập đúng kiểu là số thực");
            }
        }
        return new Hotel(roomnumber, numberofpeoplein, roomRates, true);
    }

    public void addHotel() {
        hotels.add(creatHotel());
        readandwriteHotel.writer(hotels);
    }

    public void showHotel() {
        for (int i = 0; i < hotels.size(); i++) {
            System.out.println("stt" + "  " + (i + 1) + "  " + hotels.get(i));
        }
    }

    public void detedel() {
        String roomnumberdetele;
        while (true) {
            System.out.println("Nhập địa chỉ phòng cần xóa");
            roomnumberdetele = scanner.nextLine();
            if (roomnumberdetele.matches("[A-Za-z0-9]+")) {
                break;
            } else {
                System.out.println("bạn nhập không đúng kiểu [A-Za-z0-9]");
            }
        }
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getRoomnumber().equals(roomnumberdetele)) {
                hotels.remove(i);
            }
        }
    }

    public void edit() {
        String roomnumberedit;
        while (true) {
            System.out.println("Nhập địa chỉ phòng sửa ");
            roomnumberedit = scanner.nextLine();
            if (roomnumberedit.matches("[A-Za-z0-9]+")) {
                break;
            } else {
                System.out.println("bạn nhập không đúng kiểu [A-Za-z0-9]");
            }
        }
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getRoomnumber().equals(roomnumberedit)) {
                hotels.set(i, creatHotel());
            }
        }
    }
}
