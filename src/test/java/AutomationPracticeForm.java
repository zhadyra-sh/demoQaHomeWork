import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillRegistrationForm() {
        open("/automation-practice-form");

        $("#firstName").setValue("Test");
        $("#lastName").setValue("Testing");
        $("#userEmail").setValue("testing@gmail.com");

        $("label[for='gender-radio-1']").click();

        $("#userNumber").setValue("7771234567");


        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1996");
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__day--016").click();

        $("#subjectsInput").setValue("Math").pressEnter();

        $("label[for='hobbies-checkbox-1']").click();

        SelenideElement uploadPicture = $("#uploadPicture");
        File file = new File("/Users/shzhadyra/Desktop/IdeaProjects/qa_quru/demoQaHomeWork/src/test/resources/picture.jpg");
        uploadPicture.uploadFile(file);

        $("#currentAddress").setValue("Dostyk 111");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();
    }
}
