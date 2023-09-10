package tests.elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckBox {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://demoqa.com";
        Configuration.pageLoadTimeout = 50000;
    }

    @Test
    public void selectCheckboxTest() {
        open(baseUrl +"/checkbox");
        $(".check-box-tree-wrapper").$(byText("Home")).click();
        $(".check-box-tree-wrapper").shouldHave((text("You have selected :\n" +
                "home")));


        sleep(10000);
    }
}
