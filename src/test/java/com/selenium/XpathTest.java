package com.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * xpath定位
 * 缺点：速度慢，因为是从头到尾一点点找的
 * nodename：选取此节点的所有子节点
 * /代表从根节点获取
 * //代表从匹配选择的当前节点选择文档中的节点，而不考虑它的位置
 * . 选取当前节点
 * @ 选取属性
 * 在chrome网页进行调试：$x('contents')
 * 比如：$x('//*[@data-index="1"]/a/span[2]')
 */
public class XpathTest {
    public static WebDriver driver=new ChromeDriver();
    @Test
    void XpathTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@data-index=\"1\"]/a/span[2]")).click();
    }
}
