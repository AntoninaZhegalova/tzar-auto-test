package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {

    @Test
    @DisplayName("Rus-Eng switcher")
    void languageSwitcherTest() {
        step("Open home page", () -> open("/"));

        step("Set Eng", () -> $(".language-switcher-language-url").click());

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
    @DisplayName("Open e-ticket page from secondary-menu")
    void ticketPageTest() {
        step("Open home page", () -> open("/"));

        step("Set button 'Билеты' from 'block-magazin-menu'", () -> $("#block-magazin").click());

        step("Set button 'Купить билет'", () -> $(byAttribute("href", "/event/597BFBF1F62946E0EC6768D9326B3407BD417633")).click());

        step("Title should have text: Экскурсионное обслуживание предоставляется при формировании группы от 15 до 20 человек.", () -> {
            $(".row").shouldHave(text("Екатерининский дворец (Маршрут 1) и посещение парка"));
        });
    }

    @Test
    @DisplayName("Search from secondary-menu")
    void searchSimpleTest() {
        step("Open home page", () -> open("/"));

        step("Set search icon", () -> $(".search-toggele").click());

        step("", () -> {
            $("#edit-keys--2").setValue("екатерининский дворец");
        });

        step("Submit", () -> $("#edit-submit--2").click());

        step("Title should have text: Искать екатерининский дворец.", () -> {
            $("#block-tzar-theme-page-title").shouldHave(text("Искать екатерининский дворец"));
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
}