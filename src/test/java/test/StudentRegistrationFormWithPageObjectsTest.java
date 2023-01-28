package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormWithPageObjectsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void successfulRegistration() {
        new RegistrationPage().openPage();
        new RegistrationPage().setFirstName("Vladislav");
        new RegistrationPage().setLastName("Kadyrov");
        new RegistrationPage().setUserEmail("vlad-kad00@mail.ru");

        new RegistrationPage().setUserNumber("79992484958");
        $("#genterWrapper").$(byText("Male")).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjects-label").$(byText("Sports"));
        $("#uploadPicture").uploadFromClasspath("img/kwoe.png");
        $("#currentAddress").setValue("London, United Kingdom, SD9H 1JQ");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#city").$(byText("Lucknow")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
}
