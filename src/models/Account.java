package models;

import java.io.Serializable;

public class Account implements Serializable {
private String name;
private String sex;
private String age;
private String id;
private String address;
private String email;
private String phonenumber;
private String account;
private String password;
private String rose;

    public Account() {
    }

    public Account(String name, String sex, String age, String id, String address, String email, String phonenumber, String account, String password, String rose) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.id = id;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
        this.account = account;
        this.password = password;
        this.rose = rose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRose() {
        return rose;
    }

    public void setRose(String rose) {
        this.rose = rose;
    }

    @Override
    public String toString() {
        return
                "nam: " + name +
                ", sex :" + sex +
                ", age :" + age +
                ", id :" + id +
                ", address :" + address +
                ", email :" + email +
                ", phonenumber :" + phonenumber +
                ", account :" + account +
                ", password :" + password +
                ", rose :" + rose
               ;
    }
}
