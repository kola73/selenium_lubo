package com.selenium;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class WechatTest {
    public static WebDriver driver;

    @BeforeAll
    static void openChrome() {
        driver = new ChromeDriver();
    }

    @Test
    /**
     * 登录网页获取cookie，并存到yaml文件里
     */
    void getCookies() throws IOException, InterruptedException {
        // 录网页获取cookie，并存到yaml文件里
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        Thread.sleep(20000);
        Set<Cookie> cookies = driver.manage().getCookies();
        driver.navigate().refresh();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        Thread.sleep(15000);
        mapper.writeValue(new File("cookie.yaml"), cookies);
        // 读取cookies
       cookies.forEach(cookie -> {
           System.out.println(cookie.getName());
           System.out.println(cookie.getValue());
       });
        driver.navigate().refresh();
    }

    @AfterAll
    static void close() {
        driver.quit();
    }
}
