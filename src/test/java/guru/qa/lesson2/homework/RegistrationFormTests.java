package guru.qa.lesson2.homework;

import com.codeborne.selenide.SelenideElement;
import guru.qa.lesson2.BaseTest;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests extends BaseTest {

    @Test
    public void positiveFillTest(){
        open("/automation-practice-form");

        closeGoogleAdvert();

        $("#firstName").setValue("Mariia");
        $("#lastName").setValue("Saleeva");
        $("#userEmail").setValue("test@mail.ru");

        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("8888888888");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1993");
        $(".react-datepicker__month-select").selectOptionByValue("5");
        $("div[aria-label='Choose Tuesday, June 8th, 1993']").click();

        $("input#subjectsInput").setValue("Ma");
        $x("//div[contains(text(), \"Maths\")]").click();

        $("input#subjectsInput").setValue("Com");
        $x("//div[contains(text(), \"Computer\")]").click();

        $("label[for='hobbies-checkbox-2']").click();
        $("label[for='hobbies-checkbox-3']").click();

        File file = new File("src/test/resources/Smile.png");
        String path = file.getAbsolutePath();
        $("#uploadPicture").sendKeys(path);
        $("#currentAddress").setValue("Moscow");

        scrollToElement($("#state"));
        $("#state").click();
        $x("//div[contains(text(), \"H\")]").click();
        $("#city").click();
        $x("//div[contains(text(), \"Pa\")]").click();

        $("#submit").click();

        checkField("Student Name", "Mariia " + "Saleeva");
        checkField("Student Email", "test@mail.ru");
        checkField("Gender", "Female");
        checkField("Mobile", "8888888888");
        checkField("Date of Birth", "08 June,1993");
        checkField("Subjects", "Maths, Computer Science");
        checkField("Hobbies", "Reading, Music");
        checkField("Picture", "Smile.png");
        checkField("Address", "Moscow");
        checkField("State and City", "Haryana Panipat");
    }

    private void checkField(String fieldName, String expectedValue){
        $x("//tr/td[contains(text(), '" + fieldName + "')]/following-sibling::td").shouldHave(text(expectedValue));
    }

    private void closeGoogleAdvert(){
        String idCloseAdd = "#close-fixedban";
        if ($(idCloseAdd).exists()){
            $(idCloseAdd).click();
        }
    }
    private void scrollToElement(SelenideElement element){
        executeJavaScript("arguments[0].scrollIntoView(true);", element);
    }
}
