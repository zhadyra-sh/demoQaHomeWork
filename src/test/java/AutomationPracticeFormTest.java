import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @AfterAll
    static void setDown() {
        WebDriverRunner.closeWindow();
    }

    @Test
    void fillRegistrationFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

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
        $("#uploadPicture").uploadFromClasspath("img/picture.jpg");
        $("#currentAddress").setValue("Dostyk 111");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Test"));
        $(".table-responsive").shouldHave(text("Testing"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("7771234567"));
        $(".table-responsive").shouldHave(text("16 July,1996"));
        $(".table-responsive").shouldHave(text("Math"));
        $(".table-responsive").shouldHave(text("picture.jpg"));
        $(".table-responsive").shouldHave(text("Dostyk 111"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }
}
