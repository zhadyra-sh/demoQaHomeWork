package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class AutomationPracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillRegistrationFormTest() {
        registrationPage.openPage()
                .setFirstName("Test")
                .setLastName("Testing")
                .setUserEmail("testing@gmail.com")
                .setGender("Male")
                .setUserNumber("7771234567")
                .setDateOfBirth("16", "July", "1996")
                .setSubjectsInput("Math")
                .setHobbies("Sports")
                .setUploadPicture("img/picture.jpg")
                .setCurrentAddress("Dostyk 111")
                .setState("NCR")
                .setCity("Delhi")
                .pressSubmit();

        registrationPage.checkResult("Student Name", "Test Testing")
                .checkResult("Student Email", "testing@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7771234567")
                .checkResult("Date of Birth", "16 July,1996")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "picture.jpg")
                .checkResult("Address", "Dostyk 111")
                .checkResult("State and City", "NCR Delhi");

    }

    @Test
    void emptyFieldTest() {
        registrationPage.openPage()
                .setFirstName("")
                .setLastName("Testing")
                .setUserEmail("testing@gmail.com")
                .setGender("Male")
                .setUserNumber("7771234567")
                .setDateOfBirth("16", "July", "1996")
                .setSubjectsInput("Math")
                .setHobbies("Sports")
                .setUploadPicture("img/picture.jpg")
                .setCurrentAddress("Dostyk 111")
                .setState("NCR")
                .setCity("Delhi")
                .pressSubmit();
        registrationPage.checkResult("Student Name", "Test Testing")
                .checkResult("Student Email", "testing@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7771234567")
                .checkResult("Date of Birth", "16 July,1996")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "picture.jpg")
                .checkResult("Address", "Dostyk 111")
                .checkResult("State and City", "NCR Delhi");

    }

    @Test
    void wrongEmailTest() {
        registrationPage.openPage()
                .setFirstName("Test")
                .setLastName("Testing")
                .setUserEmail("testing")
                .setGender("Male")
                .setUserNumber("7771234567")
                .setDateOfBirth("16", "July", "1996")
                .setSubjectsInput("Math")
                .setHobbies("Sports")
                .setUploadPicture("img/picture.jpg")
                .setCurrentAddress("Dostyk 111")
                .setState("NCR")
                .setCity("Delhi")
                .pressSubmit();

        registrationPage.checkResult("Student Name", "Test Testing")
                .checkResult("Student Email", "testing@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7771234567")
                .checkResult("Date of Birth", "16 July,1996")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "picture.jpg")
                .checkResult("Address", "Dostyk 111")
                .checkResult("State and City", "NCR Delhi");

    }

}