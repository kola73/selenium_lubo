package com.selenium.hogwarts.wework2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private static MainPage mainPage;
    private static ContactPage contactPage;

    @BeforeAll
    static void beforeAll() {
        contactPage = new WeWork().defaultPage().toContactPage();
    }

    @Test
    void addUser() {
        contactPage.addMember("koal", "1234", "18966666666");
    }
}
