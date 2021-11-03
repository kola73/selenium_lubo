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
    public ContactPage addMember(String account, String name,String phone) {
        driver.findElement(By.linkText("添加成员")).click();
        driver.findElement(By.name("username")).sendKeys(name);
        driver.findElement(By.name("acctid")).sendKeys(account);
        driver.findElement(By.name("mobile")).sendKeys(phone);
        driver.findElement(By.linkText("保存")).click();
        return this;

    }

    // 导入功能
    public ContactPage export(String path) {
        return this;
    }

    // 获得当前用户列表
    public List<String> getCurrentMember() {
        List<String> users = new ArrayList<>();
        driver.findElements(By.cssSelector("#member_list td:nth-child(2) > span")).forEach(e->{
            users.add(e.getText());
        });

        return users;
    }

}
