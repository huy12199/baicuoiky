package Manager;

import Login.LoginAccount;
import validate.ValidateAccount;

import java.util.Scanner;

public class ManagerAdmin {
    ManagerHotel managerHotel = new ManagerHotel();
    ManagerStaff managerStaff = new ManagerStaff();
    Scanner scanner = new Scanner(System.in);
    LoginAccount loginAccount = new LoginAccount();
    ManagerBookroom managerBookroom = new ManagerBookroom();
    public void menuAdmin(){
        System.out.println("<== XIN CHÀO ADMIN ==>");
        System.out.println("==MENUADMIN==");
        System.out.println("1. quản lý nhân viên");
        System.out.println("2. quản lý hotel ");
        System.out.println("3. quản lý đặt phòng của khách hàng");
        System.out.println("4. thoat ra ngoai dang nhap");
        switch (Integer.parseInt(ValidateAccount.Choice())){
            case 1:
                managerStaff.menuStaff();
                break;
            case 2:
                managerHotel.menuHotel();
                break;
            case 3:
                managerBookroom.showBookroom();
                break;
            case 4:
                loginAccount.menulogin();
                break;
            default:
                System.out.println("không tìm thấy chức năng bạn muốn");
                System.out.println("Mời bạn nhập đúng theo chức năng của menu");
                System.out.println("Cảm ơn bạn");
        }
    }
}
