package com.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OpenBaidu {
    public static WebDriver driver;

    @BeforeAll
    public static void openDriver() {
        driver = new ChromeDriver();
        // 隐式等待：设置一个等待时间，轮询查找元素是否出现，超时未出现就报异常
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void openBaidu() throws InterruptedException {
        driver.get("https://www.baidu.com");
    }
    @AfterAll
    static void close(){
        driver.quit();
    }
}
