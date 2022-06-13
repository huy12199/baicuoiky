package Manager;

import Login.LoginAccount;
import Readandwrite.ReadandwriteBookroom;
import Readandwrite.ReadandwriteHotel;
import models.Bookroom;
import models.Hotel;
import validate.ValidateAccount;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ManagerBookroom {
    Scanner scanner = new Scanner(System.in);
    ReadandwriteHotel readandwriteHotel = new ReadandwriteHotel();
    ReadandwriteBookroom readandwriteBookroom = new ReadandwriteBookroom();
    ArrayList<Bookroom> bookrooms = readandwriteBookroom.readr();
    ManagerHotel managerHotel = new ManagerHotel();
    LoginAccount loginAccount = new LoginAccount();
    ArrayList<Hotel> hotels = readandwriteHotel.readr();

    public void menuBookromm() {
        System.out.println("xin chào" + LoginAccount.account.getName());
        System.out.println("chúc bạn một ngày làm việc thật hiệu quả");
        System.out.println("mời bạn chọn chứ năng cho chương trình");
        System.out.println("<== MENU ==>");
        System.out.println("1. Đặt phòng cho khách hàng");
        System.out.println("2. Tìm kiến thông tin khách hàng theo tên ");
        System.out.println("3. Xóa thông tin khách hàng khi khách trả phòng");
        System.out.println("4. Sửa thông tin khách hàng ");
        System.out.println("5. Hiển thị khách hàng");
        System.out.println("6. Hiển thị bill khách hàng");
        System.out.println("7. Đăng xuất");
        switch (Integer.parseInt(ValidateAccount.Choice())) {
            case 1:
                addBooroom();
                break;
            case 2:
                sreach();
                break;
            case 3:
                delete();
                readandwriteBookroom.writer(bookrooms);
                break;
            case 4:
                edit();
                readandwriteBookroom.writer(bookrooms);
                break;
            case 5:
                showBookroom();
                break;
            case 6:
                showBill();
                break;
            case 7:
                loginAccount.menulogin();
            default:
                System.out.println("không tìm thấy chức năng");
        }

    }

    public Bookroom creatBookroom() {
        System.out.println("nhập tên khách hành");
        String name;
        while (true) {
            name = scanner.nextLine();
            if (name.matches("[A-Z][A-Za-z]+")) {
                break;
            }
            System.out.println("Nhập sai định dạng nhâp lại :");
        }
        System.out.println("nhập số chứng minh thư của khách hàng");
        String id;
        while (true) {
            id = scanner.nextLine();
            if (id.matches("[0-9]{12}")) {
                break;
            }
            System.out.println("Nhập sai định dạng nhâp lại :");
        }
        System.out.println("nhập tuổi của khách hàng");
        String age;
        while (true) {
            age = scanner.nextLine();
            if (age.matches("[0-9]{2}")) {
                break;
            }
            System.out.println("Nhập sai định dạng nhâp lại :");
        }
        managerHotel.showHotel();
        System.out.println("mời bạn đặp phòng cho khách");
        Hotel hotel = null;
        while (true) {
            int choice = Integer.parseInt(ValidateAccount.Choice());
            if (managerHotel.hotels.get(choice-1).getStust() == true) {
                hotel = managerHotel.hotels.get(choice - 1);
                managerHotel.hotels.get(choice - 1).setStust(false);
                readandwriteHotel.writer(managerHotel.hotels);
                break;
            }else {
                System.out.println("phòng này đã có người đặt rồi");
            }
        }
        System.out.println("nhập ngày khách đặt phòng");
        Date day1;
        while (true) {
            try {
                String day = scanner.nextLine();
                day1 = new SimpleDateFormat("dd/MM/yy").parse(day);
                break;
            } catch (Exception e) {
                System.out.println(" bạn nhập sai kiểu dữ liệu ");
                continue;
            }
        }
        System.out.println(" nhập ngày trả phòng ");
        Date day2;
        while (true) {
            try {
                String day = scanner.nextLine();
                day2 = new SimpleDateFormat("dd/MM/yy").parse(day);
                break;
            } catch (Exception e) {
                System.out.println(" bạn nhập sai kiểu dữ liệu ");
                continue;
            }
        }
        return new Bookroom(name, id, age, hotel, day1, day2);
    }

    public void addBooroom() {
        bookrooms.add(creatBookroom());
        readandwriteBookroom.writer(bookrooms);
        System.out.println("bạn đã đặt phòng thành công cho khách");
    }

    public void showBill() {
        boolean check = false;
        System.out.println("nhập số chứng minh thư khách hàng");
        String id;
        int index = -1;
        while (true) {
            id = scanner.nextLine();
            if (id.matches("[0-9]{12}")) {
                break;
            }
            System.out.println("Nhập sai định dạng nhâp lại :");
        }
        for (int i = 0; i < bookrooms.size(); i++) {
            if (bookrooms.get(i).getId().equals(id)) {
                check = true;
                index = i;
                break;
            }
        }
        if (check) {
            System.out.println(bookrooms.get(index));
            double day = Integer.parseInt(String.valueOf(bookrooms.get(index).getDay2().getTime() - bookrooms.get(index).getDay1().getTime()));
            double sum = day / 840000 * managerHotel.hotels.get(index).getRoomRates();
            System.out.println(sum);
        }
    }

    public void showBookroom() {
        for (Bookroom br : bookrooms) {
            System.out.println(br);
        }
    }

    public void edit() {
        System.out.println("nhập tên khách hàng bạn muốn sửa");
        String name;
        while (true) {
            name = scanner.nextLine();
            if (name.matches("[A-Z][A-Za-z]+")) {
                break;
            }
            System.out.println("Nhập sai định dạng nhâp lại :");
        }
        for (int i = 0; i < bookrooms.size(); i++) {
            if (bookrooms.get(i).getName().equals(name)) {
                String nameHotel = bookrooms.get(i).getHotel().getRoomnumber();
                for (int j = 0; j < managerHotel.hotels.size(); j++) {
                    if (managerHotel.hotels.get(i).getRoomnumber().equals(nameHotel)) {
                        managerHotel.hotels.get(i).setStust(true);
                        readandwriteHotel.writer(managerHotel.hotels);
                    }
                }
                bookrooms.set(i, creatBookroom());
            }
        }
    }

    public void delete() {
        System.out.println("nhập tên khách hàng bạn muốn xóa");
        String name;
        while (true) {
            name = scanner.nextLine();
            if (name.matches("[A-Z][A-Za-z]+")) {
                break;
            }
            System.out.println("Nhập sai định dạng nhâp lại :");
        }
        for (int i = 0; i < bookrooms.size(); i++) {
            if (bookrooms.get(i).getName().equals(name)) {
                String nameHotel = bookrooms.get(i).getHotel().getRoomnumber();
                for (int j = 0; j < managerHotel.hotels.size(); j++) {
                    if (managerHotel.hotels.get(i).getRoomnumber().equals(nameHotel)) {
                        managerHotel.hotels.get(i).setStust(true);
                        readandwriteHotel.writer(managerHotel.hotels);
                    }
                }
                bookrooms.remove(i);
            }
        }
    }

    public void sreach() {
        System.out.println("nhập tên khách hàng bạn muốn tìm kiếm");
        String name;
        while (true) {
            name = scanner.nextLine();
            if (name.matches("[A-Z][A-Za-z]+")) {
                break;
            }
            System.out.println("Nhập sai định dạng nhâp lại :");
        }
        for (int i = 0; i < bookrooms.size(); i++) {
            if (bookrooms.get(i).getName().equals(name)) {
                System.out.println(bookrooms.get(i));
            }
        }
    }
}
