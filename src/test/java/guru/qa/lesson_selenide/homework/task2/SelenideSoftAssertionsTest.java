package guru.qa.lesson_selenide.homework.task2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSoftAssertionsTest {

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl="https://github.com";
        Configuration.startMaximized = true;
    }

    @Test
    public void junit5ExampleInSoftAssertionsExist() {
        open("/selenide/selenide");
        $("[data-content='Wiki']").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
