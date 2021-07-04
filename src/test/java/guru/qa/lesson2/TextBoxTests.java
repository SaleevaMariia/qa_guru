package guru.qa.lesson2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTests extends BaseTest{

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
