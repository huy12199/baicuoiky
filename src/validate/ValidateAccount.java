package validate;

import models.Account;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount {
    public static final String regexname = "[A-Z][A-Za-z]+";
    public static final String regexAccount = "[A-Za-z0-9]{6,10}";
    public static final String regexpassword = "[A-Za-z0-9]+";
    public static final String regexemail = "[A-Za-z0-9]+@[a-z]+.[a-z]+";
    public static final String regexTelephone = "^0[0-9]{9}";
    public static final String regexaddress = "[A-Za-z0-9]+";
    public static final String regexage = "[0-9][0-9]";
    public static final String regexid = "[0-9]{12}";
    public static final String regexchoice = "[0-9]+";
    static Scanner scanner = new Scanner(System.in);

    public static String nameaccount(){
        while (true) {
            String name = scanner.nextLine();
            if (name.matches(regexname)) {
                return name;
            }
            System.out.println("Nhập sai định dạng nhâp lại :");
        }
    }

    //sex
    public static String sex() {
        System.out.println("-------------");
        System.out.println("1: Nam");
        System.out.println("2: Nữ ");
        System.out.println("-------------");
        System.out.println("Nhập lựa chọn của bạn: ");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                return "nam";
            case 2:
                return "nữ";
            default:
                return "bd";
        }
    }

    //id
    public static String validateID(List<Account> accounts) {
        while (true) {
            String id = scanner.nextLine();
            if (id.matches(regexid)) {
                try {
                    if (getIndexId(id, accounts) != -1) {
                        throw new Exception();
                    }
                    return id;
                } catch (Exception e) {
                    System.out.println("số chứng minh thư này đã tồn tại");
                }
            }
        }
    }

    public static int getIndexId(String id, List<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    //address
    public static String address() {
        while (true) {
            String address = scanner.nextLine();
            if (address.matches(regexaddress)) {
                return address;
            }
            System.out.println("Địa chỉ không được thêm kí tự đặc biệt");
        }
    }

    //age
    public static String age() {
        while (true) {
            String age = scanner.nextLine();
            if (age.matches(regexage)) {
                return age;
            }
            System.out.println("Nhập sai kiểu dữ liệu");
        }
    }

    //    mail
    public static String validateMail(List<Account> accounts) {
        while (true) {
            String mail = scanner.nextLine();
            if (mail.matches(regexemail)) {
                try {
                    if (getMail(mail, accounts) != -1) {
                        throw new Exception();
                    }
                    return mail;
                } catch (Exception e) {
                    System.out.println("email này đã tồn tại");
                }
            }
        }
    }

    public static int getMail(String mail, List<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getEmail().equals(mail)) {
                return i;
            }
        }
        return -1;
    }

    //        validatePhone
    public static String validatePhone(List<Account> accounts) {
        while (true) {
            String phone = scanner.nextLine();
            if (phone.matches(regexTelephone)) {
                try {
                    if (getPhone(phone, accounts) != -1) {
                        throw new Exception();
                    }
                    return phone;
                } catch (Exception e) {
                    System.out.println("số điện thoại này đã tồn tại");
                }
            }
        }
    }

    public static int getPhone(String phone, List<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getPhonenumber().equals(phone)) {
                return i;
            }
        }
        return -1;
    }

    //account
    public static String validatepAccount(List<Account> accounts) {
        while (true) {
            String account = scanner.nextLine();
            if (account.matches(regexAccount)) {
                try {
                    if (getPass(account, accounts) != -1) {
                        throw new Exception();
                    }
                    return account;
                } catch (Exception e) {
                    System.out.println("tài khoản này đã tồn tại");
                }
            }
        }
    }

    public static int getPass(String phone, List<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccount().equals(phone)) {
                return i;
            }
        }
        return -1;
    }

    public static String validatepPass() {
        while (true) {
            String pass = scanner.nextLine();
            if (pass.matches(regexpassword)) {
                return pass;
            }else {
                System.out.println("bạn nhập đúng dữ liệu");
            }
        }
    }
    public static String Choice() {
        while (true) {
            String choice = scanner.nextLine();
            if (choice.matches(regexchoice)) {
                return choice;
            } else System.out.println("Chỉ nhập kí tự là số ");
        }
    }
}


