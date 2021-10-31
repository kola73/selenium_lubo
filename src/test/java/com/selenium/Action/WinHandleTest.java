package com.selenium.Action;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

/**
 * 多窗口处理
 */
public class WinHandleTest {
    public static WebDriver driver;
    public static Actions actions;

    @BeforeAll
    static void openBrowser() {
        driver = new ChromeDriver();
        actions = new Actions(driver);
    }

    @Test
    void registerAndLogin() throws InterruptedException {
        driver.get("https://www.baidu.com");
        driver.manage().window().maximize();
        // 点击登录按钮
        driver.findElement(By.id("s-top-loginbtn")).click();
        Thread.sleep(2000);
        // 点击登录页面注册按钮
        driver.findElement(By.xpath("//*[@class=\"pass-reglink pass-link\"]")).click();
        // 获取当前句柄（注册页面）
        String baiduWin = driver.getWindowHandle();
        // 获取所有句柄
        Set<String> allHandle = driver.getWindowHandles();
        // 循环遍历，如果不是当前句柄，会进行跳转（到注册页面）
        for (String win : allHandle) {
            if (!win.equals(baiduWin)){
                driver.switchTo().window(win);
                // 输入用户名密码
                driver.findElement(By.xpath("//input[@id=\"TANGRAM__PSP_4__userName\"]")).sendKeys("kde3322");
                driver.findElement(By.xpath("//input[@id=\"TANGRAM__PSP_4__password\"]")).sendKeys("11qe4r3111");
                Thread.sleep(2000);
                driver.switchTo().window(baiduWin);
            }
        }

    }
}
