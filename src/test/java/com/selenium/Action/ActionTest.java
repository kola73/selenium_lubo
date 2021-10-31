package com.selenium.Action;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

// 注意！！谷歌实现不了复制黏贴，只能用火狐！！
public class ActionTest {
    public static WebDriver driver;
    public static Actions actions;

    @BeforeAll
    static void openBrowser() {
        driver = new ChromeDriver();
        actions = new Actions(driver);
    }

    // 实现复制黏贴操作
    @Test
    void testKeyboard() {
        driver.get("http://sahitest.com/demo/label.htm");
        WebElement userName = driver.findElement(By.xpath("//input[@type=\"textbox\"][1]"));
        userName.sendKeys("12343");
        // 按control+a全选，contrl+c复制，control+v黏贴
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        actions.keyUp(userName, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
    }

    // 百度搜索xxx，然后滑动到底部，点击下一页
    @Test
    void scrollTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("好多可乐");
//        TouchActions actions = new TouchActions(driver);
//        actions.click(driver.findElement(By.id("su")));
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        actions.click(driver.findElement(By.id("su")));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".n")).click();

    }
}
