package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("US"));
    private String getRandomValue(String... initialValues) {
        return faker.options().option(initialValues);
    }

    private String[] getRandomDate() {
        return new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH).
                format(faker.date().birthday(16, 45)).split(" ");
    }

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userPhoneNumber = faker.number().digits(10);
    String[] dayMonthYear = getRandomDate();
    String dateOfBirth = String.format("%s %s,%s", dayMonthYear[0], dayMonthYear[1], dayMonthYear[2]);
    String userGender = getRandomValue("Male","Female","Other");
    String subjects = getRandomValue("Computer Science","English","Maths","Arts");
    String hobbies = getRandomValue("Sports","Reading","Music");
    String address = faker.address().streetAddress();
    String state = getRandomValue("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    String city = setCityData(state);

    public String setCityData(String value) {
        String city = new String();
        switch (value) {
            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
            default:
        }
        return city;
    }
}
