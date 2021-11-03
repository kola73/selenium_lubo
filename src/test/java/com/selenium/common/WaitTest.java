package com.selenium.common;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * 显示等待：在代码中定义等待条件，当条件发生时才继续执行代码
 */
public class WaitTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void openDriver() {
        driver = new ChromeDriver();
        // 隐式等待：设置一个等待时间，轮询查找元素是否出现，超时未出现就报异常
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 1);


    }

    @Test
    public void openBaidu() throws InterruptedException {
        driver.get("https://www.baidu.com");
//        driver.findElement(By.id("s-top-loginbtn")).click();
        // 两种写法：
        // 方法1，
        // 看到登录按钮就点击
//        WebElement loginEle = wait.until(new ExpectedCondition<WebElement>() {
//            public WebElement apply(WebDriver webDriver) {
//                return driver.findElement(By.id("s-top-loginbtn"));
//            }
//        });
//        loginEle.click();
        // 方法2
        WebElement loginbtn=wait.until(ExpectedConditions.elementToBeClickable(By.id("s-top-loginbtn")));
        loginbtn.click();
    }

}
