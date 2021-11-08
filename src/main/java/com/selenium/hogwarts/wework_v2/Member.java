package com.selenium.hogwarts.wework_v2;

public class Member {
    private String account;
    private String name;
    private String phone;

    public Member(String account, String name, String phone) {
        this.account = account;
        this.name = name;
        this.phone = phone;
    }

    public Member() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
