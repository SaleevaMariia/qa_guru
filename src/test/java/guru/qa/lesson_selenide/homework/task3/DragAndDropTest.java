package guru.qa.lesson_selenide.homework.task3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl="https://the-internet.herokuapp.com";
        Configuration.startMaximized = true;
    }

    @Test
    public void dragAndDropTest() {
        open("/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(Condition.text("B"));
    }
}
