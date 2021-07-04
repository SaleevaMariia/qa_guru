package guru.qa.lesson2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.startMaximized = true;
    }
}
