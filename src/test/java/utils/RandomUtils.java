package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String randomGender(String[] values) {
        int index = randomInt(0, values.length - 1);
        return values[index];
    }
}
