import Login.LoginAccount;
import Manager.ManagerAdmin;
import Manager.ManagerBookroom;
import Manager.ManagerHotel;

public class Main {
    public static void main(String[] args) {
        LoginAccount loginAccount = new LoginAccount();
        ManagerAdmin managerAdmin = new ManagerAdmin();
        ManagerBookroom managerBookroom = new ManagerBookroom();
        while (true){
            if (LoginAccount.account==null){
                loginAccount.menulogin();
                System.out.println("không tìm thấy tài khoản này");
            }else {
                if (LoginAccount.account.getRose().equals("admin")){
                    managerAdmin.menuAdmin();
                }else {
                    managerBookroom.menuBookromm();
                }
            }
        }
    }
}
