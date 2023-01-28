package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameImput = $("#firstName"),
            lastNameImput = $("#lastName"),
            userEmailImput = $("#userEmail"),
            userNumberImput = $("#userNumber"),
            genderRadioButton = $("#genterWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckBox = $("#hobbiesWrapper"),
            uploadPictureButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateOption = $("#stateCity-wrapper"),
            cityOption = $("#city"),
            submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameImput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameImput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailImput.setValue(value);

        return this;
    }

    public RegistrationPage setGenger(String value) {
        genderRadioButton.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberImput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesCheckBox.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPictureButton.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage selectState(String value) {
        $("#state").click();
        stateOption.$(byText(value)).click();

        return this;
    }

    public RegistrationPage selectCity(String value) {
        cityOption.click();
        cityOption.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();

        return this;
    }

    public RegistrationPage registrationResultsModal() {
        registrationResultsModal.verifyModalAppear();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
}
