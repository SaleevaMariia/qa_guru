package guru.qa.lesson2.homework;

import guru.qa.lesson2.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests extends BaseTest {

    @Test
    public void positiveFillTest(){
        open("/automation-practice-form");

        closeGoogleAdvert();

        $("#firstName").setValue("Mariia");
        $("#lastName").setValue("Saleeva");
        $("#userEmail").setValue("test@mail.ru");

        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8888888888");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__day--008").click();

        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("Smile.png");
        $("#currentAddress").setValue("Moscow");

        $("#state").scrollTo().click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();

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
        $(".table-responsive tbody").$(byText(fieldName)).sibling(0).shouldHave(text(expectedValue));
    }

    private void closeGoogleAdvert(){
        String idCloseAdd = "#close-fixedban";
        if ($(idCloseAdd).exists()){
            $(idCloseAdd).click();
        }
    }
}
