package Manager;

import Login.LoginAccount;
import Readandwrite.ReadandwriteAccount;
import models.Account;
import validate.ValidateAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerStaff {
    LoginAccount loginAccount = new LoginAccount();
    ReadandwriteAccount readandwriteAccount = new ReadandwriteAccount();
   ArrayList<Account> accounts = readandwriteAccount.readr();
    Scanner scanner = new Scanner(System.in);


    public void menuStaff() {
        boolean check = true;
        while (check) {
            System.out.println("1. Thêm tài khoản nhân viên ");
            System.out.println("2. Xóa tài khoản nhân viên");
            System.out.println("3. sửa tài khoản nhân viên ");
            System.out.println("4. Hiển thị tài khoản nhân viên");
            System.out.println("5. Thoát khỏi menu");
            switch (Integer.parseInt(ValidateAccount.Choice())) {
                case 1:
                    loginAccount.addregister();
                    break;
                case 2:
                    loginAccount.delete();
                    readandwriteAccount.writer(accounts);
                    break;
                case 3:
                    loginAccount.edit();
                    readandwriteAccount.writer(accounts);
                    break;
                case 4:
                    loginAccount.showStaff();
                    break;
                case 5:
                    check = false;
                    break;
                default:
                    System.out.println("không tìm thấy chức năng trong menu");

            }
        }
    }



//    public void show(){
//        for (Account ac: accounts) {
//
//        }
//    }
}
