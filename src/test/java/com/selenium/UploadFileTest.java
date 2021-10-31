package com.selenium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileTest {
    public static WebDriver driver;

    @BeforeAll
    static void openBrowser() {
        driver = new ChromeDriver();
    }

    // 上传文件测试
    @Test
    void upload() throws InterruptedException {
        driver.get("https://www.baidu.com");
        driver.findElement(By.xpath("//span[@class='soutu-btn']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class='upload-pic']"))
                .sendKeys("D:\\selenium_lubo\\src\\main\\resources\\屏幕截图 2021-10-29 000439.png");
    }
}
