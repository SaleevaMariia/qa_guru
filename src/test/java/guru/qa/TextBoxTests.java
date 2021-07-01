package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTests {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest(){
        open("/text-box");
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("Egorov@mail.ru");
        $("#currentAddress", 0).setValue("some street");
        $("#permanentAddress").setValue("permanent address");

        $("#submit").click();

        $("#name").shouldHave(text("Alex"));
        $("#email").shouldHave(text("Egorov@mail.ru"));
        $("#currentAddress", 1).shouldHave(text("some street"));
        $("#permanentAddress", 1).shouldHave(text("permanent address"));


    }
}
