package guru.qa.lesson_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindSelenideTest {

    @Test
    void shouldFindSelenideRepository(){
        open("https://github.com");
        $("[name=q]").setValue("selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();
        $("h1").shouldHave(text("selenide / selenide"));
    }


}
