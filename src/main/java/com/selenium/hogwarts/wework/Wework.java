package com.selenium.hogwarts.wework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Wework {

    // 不建议使用static，会引起多线程的问题
    private WebDriver driver;

    void start() {
        driver = new ChromeDriver();
        loadCookie();
        System.out.println("cookie------");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    public MainPage defaultPage() {
        start();
        return new MainPage(driver);
    }

    // 加载cookie
    void loadCookie() {
//        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {
        };
        List<HashMap<String, Object>> cookies = null;
        try {
//            System.out.println(objectMapper);
            System.out.println(this.getClass().getResource("/cookie.yaml").getPath());
            cookies = objectMapper.readValue(
                    this.getClass().getResource("/cookie.yaml"),
                    typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        cookies.forEach(cookie -> {
            driver.manage().addCookie(new Cookie(cookie.get("name").toString(), cookie.get("value").toString()));
            System.out.println(cookie.get("name").toString());
            System.out.println(cookie.get("value").toString());
        });
        System.out.println("-----------");
        System.out.println(driver.manage().getCookies());
        driver.navigate().refresh();

    }


//        driver.navigate().refresh();


}
