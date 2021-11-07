package com.selenium.hogwarts.wework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ExportTest {
    private static ContactPage contactPage;

    @BeforeAll
    static void beforeAll() {
        contactPage = new Wework().defaultPage().goToContact();
    }

    @Test
    void export() {
        try {
            contactPage.export("C:\\Users\\86189\\Desktop\\通讯录批量导入模板.xlsx");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
