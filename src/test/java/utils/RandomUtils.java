package utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    Faker faker = new Faker();

    public String firstName() {
        return faker.name().firstName();
    }

    public String lastName() {
        return faker.name().lastName();
    }

    public String userEmail() {
        return faker.internet().emailAddress();
    }

    public String userGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String userPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String dayOfBirth() {
        return String.format("%02d", faker.number().numberBetween(1, 31));
    }

    public String monthOfBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public String yearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1950, 2010));
    }

    public String userSubject() {
        return faker.options().option("Hindi", "Arts", "Chemistry", "Computer Science", "Commerce", "Social Studies", "Civics", "English", "History", "Maths", "Phisics", "Biology");
    }

    public String userHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String userAddress() {
        return faker.address().streetAddress();
    }

    public String userState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String userCity(String userState) {
        if (userState.equals("NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        }
        if (userState.equals("Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        }
        if (userState.equals("Haryana")) {
            return faker.options().option("Karnal", "Panipat");
        }
        if (userState.equals("Rajasthan")) {
            return faker.options().option("Jaipur", "Jaiselmer");
        } else {
            return "";
        }
    }
}
