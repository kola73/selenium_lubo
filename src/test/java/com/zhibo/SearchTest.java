package com.zhibo;

import com.selenium.hogwarts.PO_Mode.MainPage;
import com.selenium.hogwarts.PO_Mode.SearchPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static com.selenium.hogwarts.originDemo.SearchTest.driver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class SearchTest {
    @Test
    void testSearch() {
        assertThat(
                new MainPage()
                        .start().
                        search("selenium").
                        getFirstTitle(),
                containsString("网页"));
    }

    @Test
    void testSearch2() {
        MainPage main = new MainPage();
        SearchPage search = main.start().search("selenium");
        String title = search.getFirstTitle();
        assertThat(title, containsString("网页"));

    }

    @AfterAll
    void close() {
        driver.quit();
    }

}
