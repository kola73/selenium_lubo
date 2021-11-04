package com.selenium.hogwarts.wework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //todo: 当出现异常的时候，解决异常，然后重新回归到当前步骤继续执行
    //todo: 递归设计，对递归深度做限制
    public WebElement find(By by) {
        WebElement element = null;
        try {
            element = driver.findElement(by);
        } catch (Exception e) {
            e.printStackTrace();
            element = this.find(by);
        }
        return element;
    }

    public void click() {

    }

    public void sendKeys() {

    }

}
