package com.selenium.hogwarts.wework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }


    // 前往通讯录
    ContactPage toContactPage() {
        driver.findElement(By.linkText("通讯录")).click();
        return new ContactPage(driver);
    }
}
