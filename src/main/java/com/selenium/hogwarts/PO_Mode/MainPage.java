package com.selenium.hogwarts.PO_Mode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {
    private WebDriver driver;
    private By clickBtn = By.id("su");
    private By inputBox = By.id("kw");

    public MainPage start() {
        driver = new ChromeDriver();
        // 隐式等待：设置一个等待时间，轮询查找元素是否出现，超时未出现就报异常
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.baidu.com");
        // 返回自己，以便进行链式调用
        return this;
    }

    public SearchPage search(String keyword) {
        driver.findElement(inputBox).sendKeys(keyword);
        driver.findElement(clickBtn).click();
        return new SearchPage(driver);
    }
}
