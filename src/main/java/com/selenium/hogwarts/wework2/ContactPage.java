package com.selenium.hogwarts.wework2;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    // 添加联系人
    public ContactPage addMember(String name, String account, String phone) {
        return this;
    }

    // 展示用户列表
    public List<String> userList() {
        List<String> users = new ArrayList<>();
        users.add("111");
        return users;
    }
}
