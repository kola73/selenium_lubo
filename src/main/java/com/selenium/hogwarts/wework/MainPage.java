package com.selenium.hogwarts.wework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

// 首页
public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    // 获取消息
    List<String> getMsgs() {
        List<String> messages = new ArrayList<>();
        messages.add("1");
        return messages;
    }

    // 跳到通讯录
    ContactPage goToContact() {
        driver.findElement(By.linkText("通讯录")).click();
        return new ContactPage(driver);


    }
}
