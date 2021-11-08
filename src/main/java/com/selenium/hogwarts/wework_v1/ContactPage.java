package com.selenium.hogwarts.wework_v1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

// 通讯录页面
public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    // 添加联系人
    public ContactPage addMember(String account, String name, String phone) {
        driver.findElement(By.linkText("添加成员")).click();
        driver.findElement(By.name("username")).sendKeys(name);
        driver.findElement(By.name("acctid")).sendKeys(account);
        driver.findElement(By.name("mobile")).sendKeys(phone);
        driver.findElement(By.linkText("保存")).click();
        return this;

    }

    // 删除联系人
    public ContactPage delMember(String name) throws InterruptedException {
        driver.findElement(By.id("memberSearchInput")).sendKeys(name);
        Thread.sleep(3000);
        driver.findElement(By.linkText("删除")).click();
        driver.findElement(By.linkText("确认")).click();
        return this;
    }

    // 导入功能
    public ContactPage export(String path) throws InterruptedException {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("批量导入/导出")).click();
        driver.findElement(By.cssSelector("div.ww_btnWithMenu.js_btnWithMenu.js_import_other_wrap.ww_btnWithMenu_Open > div > ul > li:nth-child(1) > a")).click();
        // 点击上传文件按钮
        driver.findElement(By.xpath("//a[@class='qui_btn ww_btn ww_fileImporter_fileContainer_upload']/input[@type='file']")).sendKeys(path);
        driver.findElement(By.linkText("导入")).click();
        driver.findElement(By.linkText("完成")).click();
        return this;
    }

    // 获得当前用户列表
    //todo: 自动化过程
    public List<String> getCurrentMember() {
        List<String> users = new ArrayList<>();
        driver.findElements(By.cssSelector("#member_list td:nth-child(2) > span")).forEach(e -> {
            users.add(e.getText());
        });

        return users;
    }

}
