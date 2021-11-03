package com.selenium.hogwarts.wework;

import org.junit.jupiter.api.AfterAll;
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
        List<String> user = contactPage.addMember("23444", "林俊杰", "18911111111").getCurrentMember();
        assertThat(user, hasItem("18911111111"));
    }

}
