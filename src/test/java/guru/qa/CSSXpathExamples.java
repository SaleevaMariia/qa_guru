package guru.qa;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CSSXpathExamples {

    void cssXpathExamples(){
        //<input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="royal_email">

        $("[data-testid=royal_email]");
        $(by("data-testid", "royal_email"));
        $("#email");
        $("input[id=email]");
        $(byId("#email"));
        $x("//*[@id='email']");
        $(byXpath("//input[@id='email']"));

        $(byClassName("login_form_input_box"));
        $(".login_form_input_box");


    }
}
