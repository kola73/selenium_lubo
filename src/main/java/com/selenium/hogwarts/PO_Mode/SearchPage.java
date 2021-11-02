package com.selenium.hogwarts.PO_Mode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstTitle() {
        String text = driver.findElement(By.xpath("//b[@class=\"cur-tab\"]")).getText();
        return text;
    }
}
