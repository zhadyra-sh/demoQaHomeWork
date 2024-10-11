package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class RegistrationPageWithFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    String firstName = randomUtils.firstName(),
            lastName = randomUtils.lastName(),
            userEmail = randomUtils.userEmail(),
            userGender = randomUtils.userGender(),
            userPhoneNumber = randomUtils.userPhoneNumber(),
            dayOfBirth = randomUtils.dayOfBirth(),
            monthOfBirth = randomUtils.monthOfBirth(),
            yearOfBirth = randomUtils.yearOfBirth(),
            userSubject = randomUtils.userSubject(),
            userHobby = randomUtils.userHobby(),
            userAddress = randomUtils.userAddress(),
            userState = randomUtils.userState(),
            userCity = randomUtils.userCity(userState);

    @Test
    void fillRegistrationFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userPhoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjectsInput(userSubject)
                .setHobbies(userHobby)
                .setUploadPicture("img/picture.jpg")
                .setCurrentAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .pressSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userPhoneNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth +"," + yearOfBirth)
                .checkResult("Subjects", userSubject)
                .checkResult("Hobbies", userHobby)
                .checkResult("Picture", "picture.jpg")
                .checkResult("Address", userAddress)
                .checkResult("State and City", userState + " " + userCity);

    }

    @Test
    void minDataTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userPhoneNumber)
                .pressSubmit();
        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userPhoneNumber);
    }
    @Test
    void wrongEmailTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail("testing")
                .setGender(userGender)
                .setUserNumber(userPhoneNumber)
                .pressSubmit();
        registrationPage.checkModalNotVisible();

    }
}
