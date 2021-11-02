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
        driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx?from=myhome_openApi");
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        Set<Cookie> cookie = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        Thread.sleep(15000);
        mapper.writeValue(new File("cookies.yaml"), cookie);
        // 读取cookies
        TypeReference typeReference = new TypeReference<List<HashMap<String, Object>>>() {
        };
        List<HashMap<String, Object>> cookies = mapper.readValue(new File("/cookies.yaml"), typeReference);
        System.out.println(cookies);
        cookies.forEach(cookieMap -> {
            driver.manage().addCookie
                    (new Cookie(cookieMap.get("name").toString(), cookieMap.get("value").toString()));
        });
        driver.navigate().refresh();
    }

    @AfterAll
    static void close() {
        driver.quit();
    }
}
