package com.selenium.hogwarts.wework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

// 通讯录页面
public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    // 添加联系人
    public ContactPage addMember(String name, String phone, String account) {
        driver.findElement(By.linkText("添加成员")).click();
        driver.findElement(By.name("username")).sendKeys(name);
        driver.findElement(By.name("acctid")).sendKeys(account);
        driver.findElement(By.name("mobile")).sendKeys(phone);
        driver.findElement(By.linkText("保存")).click();
        return this;

    }

    // 导入功能
    public ContactPage export() {
        return this;
    }

    // 获得当前用户列表
    public List<String> getCurrentMember() {
        List<String> user = new ArrayList<>();
        user.add("xxx");
        return user;
    }

}
