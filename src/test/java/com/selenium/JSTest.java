package com.selenium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSTest {
    public static WebDriver driver;

    @BeforeAll
    static void openBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    void printDate() throws InterruptedException {
        driver.get("https://www.12306.cn/index/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        js.executeScript("document.getElementById(\"train_date\").value=\"2021-12-31\"");
        Thread.sleep(25000);
        System.out.println(js.executeScript("return document.getElementById(\"train_date\").value"));
        driver.quit();
    }
}
