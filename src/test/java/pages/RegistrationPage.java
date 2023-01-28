package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameImput = $("#firstName"),
            lastNameImput = $("#lastName"),
            userEmailImput = $("#userEmail"),
            userNumberImput = $("#userNumber"),
            genderRadioButton = $("#genterWrapper");

    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public void setFirstName(String value) {
        firstNameImput.setValue(value);
    }

    public void setLastName(String value) {
        lastNameImput.setValue(value);
    }

    public void setUserEmail(String value) {
        userEmailImput.setValue(value);
    }

    public void setGenger(String value) {
        genderRadioButton.$(byText("Male")).click();
    }

    public void setUserNumber(String value) {
        userNumberImput.setValue(value);
    }

}
