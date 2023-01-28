package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormWithPageObjectsTest extends TestBase {

    @Test
    void successfulRegistration() {
        registrationPage.openPage()
                .setFirstName("Vladislav")
                .setLastName("Kadyrov")
                .setUserEmail("vlad-kad00@mail.ru")
                .setGenger("Male")
                .setUserNumber("9992484959")
                .setBirthDate("10","July","2000")
                .setSubjects("Computer Science")
                .setHobbies("Sports")
                .uploadPicture("img/kwoe.png")
                .setCurrentAddress("SD9H 1JQ")
                .selectState("Uttar Pradesh")
                .selectCity("Lucknow")
                .clickSubmitButton()
                .registrationResultsModal()
                .verifyResult("Student Name","Vladislav Kadyrov")
                .verifyResult("Student Email","vlad-kad00@mail.ru")
                .verifyResult("Gender","Male")
                .verifyResult("Mobile","9992484959")
                .verifyResult("Date of Birth","10 July,2000")
                .verifyResult("Subjects","Computer Science")
                .verifyResult("Hobbies","Sports")
                .verifyResult("Picture","kwoe.png")
                .verifyResult("Address","SD9H 1JQ")
                .verifyResult("State and City","Uttar Pradesh Lucknow");
    }
}
