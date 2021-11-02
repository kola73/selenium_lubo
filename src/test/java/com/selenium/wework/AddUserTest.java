package com.selenium.wework;

import com.selenium.hogwarts.wework.ContactPage;
import com.selenium.hogwarts.wework.MainPage;
import com.selenium.hogwarts.wework.Wework;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class AddUserTest {
    private static MainPage mainPage;
    private static ContactPage contactPage;

    @BeforeAll
    static void before() {
        mainPage = new Wework().defaultPage();
        contactPage = mainPage.goToContact();
    }


    @Test
    void addUserTest() {
        List<String> user = contactPage.addMember("李宇春", "18911111111", "32453").getCurrentMember();
        assertThat(user, hasItem("122"));
    }
}
