package com.jilani.e_medicine;

public class userdata {

  String uid,email,namel,address,mobilenumber,password;

    public userdata(String uid, String email, String namel, String address, String mobilenumber, String password) {
        this.uid = uid;
        this.email = email;
        this.namel = namel;
        this.address = address;
        this.mobilenumber = mobilenumber;
        this.password = password;
    }

    public userdata() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamel() {
        return namel;
    }

    public void setNamel(String namel) {
        this.namel = namel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
