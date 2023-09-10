package tests.elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class TextBox {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://demoqa.com";
        Configuration.pageLoadTimeout = 50000;
    }

    @Test
    public void fillFormTest() {
        String userName = "John Doe";
        String userEmail = "john-doe@mail.com";

        open("https://demoqa.com/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        //$("[class=main-header]").shouldHave(text("Text Box"));

        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue("Street 35");
        $("#permanentAddress").setValue("Street other 36");
        $("#submit").click();

       /* $("#name").shouldHave(text("John Doe"));
        $("#email").shouldHave(text("john-doe@mail.com"));
        $("#currentAddress").shouldHave(text("Street 35"));
        $("#permanentAddress").shouldHave(text("Street other 36"));*/


        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave((text(userName)));
        $("#output #email").shouldHave((text(userEmail)));

        $("#output").$("#currentAddress").shouldHave((text("Street 35")));
        $("#output #permanentAddress").shouldHave((text("Street other 36")));

        sleep(10000);




    }
}
