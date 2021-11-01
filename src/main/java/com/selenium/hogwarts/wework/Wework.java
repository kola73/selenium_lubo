package com.selenium.hogwarts.wework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Wework {
    void start(){
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx?from=myhome_openApi");
    }
}
