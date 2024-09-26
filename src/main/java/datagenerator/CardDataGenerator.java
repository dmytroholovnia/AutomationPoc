package datagenerator;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CardDataGenerator {

    private static final Faker faker = new Faker();

    public static String getTestCardNumber() {
        return "4067429974719265";
    }

    public static String generateExpiryDate() {
        int month = faker.number().numberBetween(1, 13);
        int year = LocalDate.now().getYear() + faker.number().numberBetween(1, 50);

        LocalDate expiryDate = LocalDate.of(year, month, 1)
                .withDayOfMonth(LocalDate.of(year, month, 1).lengthOfMonth());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");

        return expiryDate.format(formatter);
    }

    public static String generateCvv() {
        return String.valueOf(faker.number().numberBetween(100, 1000));
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

}
