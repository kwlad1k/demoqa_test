package tests;

import org.junit.jupiter.api.Test;

public class RegistrationFormWithJavaFakerTest extends TestBase {

    @Test
    void successfulRegistration() {
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setUserEmail(data.userEmail)
                .setGenger(data.userGender)
                .setUserNumber(data.userPhoneNumber)
                .setBirthDate(
                        data.dayMonthYear[0],
                        data.dayMonthYear[1],
                        data.dayMonthYear[2])
                .setSubjects(data.subjects)
                .setHobbies(data.hobbies)
                .uploadPicture("img/kwoe.png")
                .setCurrentAddress(data.address)
                .selectState(data.state)
                .selectCity(data.city)
                .clickSubmitButton()
                .registrationResultsModal()
                .verifyResult("Student Name", data.firstName + " " + data.lastName)
                .verifyResult("Student Email", data.userEmail)
                .verifyResult("Gender", data.userGender)
                .verifyResult("Mobile", data.userPhoneNumber)
                .verifyResult("Date of Birth", data.dateOfBirth)
                .verifyResult("Subjects", data.subjects)
                .verifyResult("Hobbies", data.hobbies)
                .verifyResult("Picture", "kwoe.png")
                .verifyResult("Address", data.address)
                .verifyResult("State and City", data.state + " " + data.city);
    }
}
