package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormHW {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 50000;
    }


    @Test
    public void successfulRegistrationTest() {
        String userName = "John";

        open(baseUrl + "/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue(userName);
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("john-doe@mail.com");
        $("#userNumber").setValue("4673819232");
        $("#currentAddress").setValue("Street 35");

        //$("#gender-radio-1").selectRadio("Male"); // incorrect
        //$("#gender-radio-1").click(); // wrong
//        $("#gender-radio-1").parent().click(); // good
//        $(byText("Other")).click(); // not very good  - только для английской локали
        $("#genterWrapper").$(byText("Male")).click(); // best
//        $("label[for=gender-radio-1]").click(); // good

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1999");
        //$(".react-datepicker__day.react-datepicker__day--010").click(); // incorrect
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $x("//*[@class='react-datepicker__day--030'][not(contains(@class, 'react-datepicker__day--outside-month'))]").click();  // вариант с xpath

        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();

        //$("#hobbies-checkbox-3").selectRadio("Reading"); // incorrect
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        // File file = new File("\\src\\test\\resources\\img\\1.png");
        //$("#uploadPicture").uploadFile(new File("\\src\\test\\resources\\img\\1.png"));
        $("#uploadPicture").uploadFromClasspath("\\img\\1.png");  // работает только для элемента у которого есть type="file"

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        //        $("#react-select-3-option-0").click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();


        $(".modal-dialog").should(appear); // должен появиться
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Doe"),
                text("john-doe@mail.com"), text("4673819232"));


        $("#dateOfBirthInput").setValue("");
        //$("#dateOfBirthInput").setValue("").setValue("10 Mar 1999");

        //sleep(10000);

   /*
        //("#hobbies-checkbox-1").setValue("");
        //$("#hobbies-checkbox-3").setValue("");
        $("#hobbies-checkbox-1").selectRadio("Sports");
        $("#hobbies-checkbox-3").selectRadio("Reading");





        //$("#uploadPicture").setValue("");
        //File file = new File("src/test/resources/readme.txt");
        //$("#file-upload").uploadFile(file);
        //$("#file-upload").uploadFromClasspath("readme.txt");
        // don't forget to submit!
        //$("uploadButton").click();



        //$("#react-select-3-input").setValue("");
        //$("#react-select-4-input").setValue("");

        $("#react-select-3-input").selectOption("Rajasthan"); // для старых , а для новых просто ckick
        $("#react-select-4-input").selectOption("Jaiselmer"); // для старых , а для новых просто ckick
        //$("#react-select-4-input").click(). // для старых , а для новых просто ckick

        $("#submit").click();

        */

    }
}


/*
Name: John
        Last Name: Doe
        Email: john-doe@mail.com
Gender: Male
        Mobile(10 Digits): +4673819232
        Date of Birth: 10 Mar 1999   нужно выделить и заменить
        Subjects: Maths, Physics, Computer Science
        Hobbies: Sports, Reading
        Picture
        Current Address: Street 35
        State and City: Rajasthan
        Jaiselmer*/
