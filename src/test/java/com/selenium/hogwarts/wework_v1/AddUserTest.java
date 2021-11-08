package com.selenium.hogwarts.wework_v1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class AddUserTest {
    private static MainPage mainPage;
    private static ContactPage contactPage;

    @BeforeAll
    // todo：清数据（不建议在teardown清理数据，因为测试执行一旦有问题，这个是不执行的）
    static void before() {
        mainPage = new Wework().defaultPage();
        contactPage = mainPage.goToContact();
    }


    @Test
    void addUserTest() {
        List<String> user = contactPage.addMember("234944", "周杰伦", "18911111112").getCurrentMember();
        assertThat(user, hasItem("18911111111"));
    }

}
