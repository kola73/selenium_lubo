package com.selenium.hogwarts.originDemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class SearchTest {
    public static WebDriver driver;

    @BeforeAll
    public static void openDriver() {
        driver = new ChromeDriver();
        // 隐式等待：设置一个等待时间，轮询查找元素是否出现，超时未出现就报异常
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void openBaidu() {
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        String text = driver.findElement(By.xpath("//b[@class=\"cur-tab\"]")).getText();
    }

    @AfterAll
    static void close() {
        driver.quit();
    }
}
