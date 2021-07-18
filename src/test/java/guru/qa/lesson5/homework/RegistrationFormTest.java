package guru.qa.lesson5.homework;

import com.codeborne.selenide.Configuration;
import guru.qa.lesson5.homework.page.RegistrationPage;
import guru.qa.lesson5.homework.utils.TestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest {

    static RegistrationPage registrationPage;

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.startMaximized = true;
        TestData.initPositiveTestData();
        registrationPage = new RegistrationPage();
    }

    @Test
    public void fullPositiveTest() {
        registrationPage.openPage();
        registrationPage.fillAllPositiveData();
        registrationPage.clickSubmit();
        registrationPage.checkResult();
    }
}
