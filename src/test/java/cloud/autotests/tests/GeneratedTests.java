package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {

    @Test
    @DisplayName("Rus-Eng")
    void languageSwitcherTest() {
        step("Open home page", () -> {
            open("/");
        });

        step("Set Eng", () -> {
            $(".language-switcher-language-url").click();
        });

        step("Title should have text: Tsarskoe Selo State Museum and Heritage Site", () -> {
            $("#block-tzar-theme-branding").shouldHave(text("Tsarskoe Selo State Museum and Heritage Site"));
        });
    }

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://tzar.ru/'", () ->
                open("/"));

        step("Page title should have text 'Home | Государственный музей-заповедник «Царское Село»'", () -> {
            String expectedTitle = "Home | Государственный музей-заповедник «Царское Село»";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://tzar.ru/'", () ->
                open("/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @DisplayName("Open e-ticket page from block-magazin-menu")
    void generatedTest() {
        step("Open home page", () -> {
            open("/");
        });

        step("Set button 'Билеты' from 'block-magazin-menu'", () -> {
            $("#block-magazin").click();
        });

        step("Set button 'Купить билет'", () -> {
            $("#block-magazin").click();
        });

        step("Title should have text: Tsarskoe Selo State Museum and Heritage Site", () -> {
            $("#block-tzar-theme-branding").shouldHave(text("Tsarskoe Selo State Museum and Heritage Site"));
        });
    }

//    @Test
//    @DisplayName("Eng-Rus")
//    void generatedTestHh() {
//        step("Open home page", () -> {
//            open("/employer");
//        });
//
//        step("Registration page open correct", () -> {
//            $("#supernova-navi-item supernova-navi-item_lvl-2 " +
//                    "supernova-navi-item_no-mobile supernova-navi-item_dashboard").click();
//        });
//
//        step("Title should have text: Регистрация работодателя", () -> {
//            $("#light-page-content__title light-page-content__title_labeled-form").
//                    shouldHave(text("Регистрация работодателя"));
//        });
//    }
}