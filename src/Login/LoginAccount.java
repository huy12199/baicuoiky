package Login;

import Readandwrite.ReadandwriteAccount;
import models.Account;
import validate.ValidateAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginAccount {
    ReadandwriteAccount readandwriteAccount = new ReadandwriteAccount();

    Scanner scanner = new Scanner(System.in);
    ArrayList<Account> accounts = readandwriteAccount.readr();
    public static Account account;

    {
        if (accounts.size() == 0) {
            accounts.add(new Account("admin", "admin", "admin", "admin", "admin", "admin", "admin", "admin", "admin", "admin"));
        }
    }

    public void menulogin() {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("3. Lấy lại mật khẩu");
        switch (Integer.parseInt(ValidateAccount.Choice())) {
            case 1:
                login();
                break;
            case 3:
                layMk();
                break;
            default:
                System.out.println("chỉ admin mới có quyền đăng ký tài khoản");
                menulogin();
        }
    }

    public boolean login() {
        System.out.println("Nhập userName :");
        String user = scanner.nextLine();
        System.out.println("Nhập passWord :");
        String pass = scanner.nextLine();
        for (Account acc : accounts) {
            if (acc.getAccount().equals(user) && acc.getPassword().equals(pass)) {
                LoginAccount.account = acc;
                return true;
            }
        }
        return false;
    }

    public Account register() {
        System.out.println("nhập tên");
        String name = ValidateAccount.nameaccount();
        System.out.println("mời bạn chọn giới tính của mình");
        String sex = ValidateAccount.sex();
        System.out.println("nhập tuổi của bạn");
        String age = ValidateAccount.age();
        System.out.println("nhập số chứng minh thư");
        String id = ValidateAccount.validateID(accounts);
        System.out.println("nhâp số điện thoại");
        String phonenumber = ValidateAccount.validatePhone(accounts);
        System.out.println("nhập email ");
        String mail = ValidateAccount.validateMail(accounts);
        System.out.println("nhập địa chỉ nhà");
        String address = ValidateAccount.address();
        System.out.println("nhập account");
        String account = ValidateAccount.validatepAccount(accounts);
        System.out.println("nhập password");
        String pass = ValidateAccount.validatepPass();
        return new Account(name, sex, age, id, address, mail, phonenumber, account, pass, "staff");
    }

    public void addregister() {
        accounts.add(register());
        readandwriteAccount.writer(accounts);
    }

    public void showStaff() {
        for (int i = 1; i < accounts.size(); i++) {
            System.out.println(accounts.get(i));
        }
    }

    public void edit() {
        System.out.println("nhập account nhân viên bạn muốn sửa");
        String account = scanner.nextLine();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccount().equals(account)) {
                accounts.set(i, register());
            }
        }
    }

    public void delete() {
        System.out.println("nhập account nhân viên bị đuổi việc");
        String account = scanner.nextLine();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccount().equals(account)) {
                accounts.remove(i);
            }
        }
    }

    public void layMk() {
        String maill = null ;
        while (true){
            System.out.println("nhập email bạn muốn lấy lại mật khẩu");
            maill = scanner.nextLine();
            if (maill.matches("[A-Za-z0-9]+@[a-z]+.[a-z]+")){
                break;
            }
        }

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getEmail().equals(maill)){
                System.out.println("account của bạn là:" + accounts.get(i).getAccount());
                System.out.println("password của bạn là: " + accounts.get(i).getPassword());
            }
        }
    }
}

