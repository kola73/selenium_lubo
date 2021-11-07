package com.selenium.hogwarts.wework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DelUserTest {
    private static MainPage mainPage;
    private static ContactPage contactPage;

    @BeforeAll
    static void before() {
        mainPage = new Wework().defaultPage();
        contactPage = mainPage.goToContact();
    }

    @Test
    void delUser() throws InterruptedException {
        contactPage.delMember("周杰伦");
    }
}
