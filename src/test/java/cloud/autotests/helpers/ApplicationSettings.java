package cloud.autotests.helpers;

import cloud.autotests.config.Application;
import com.codeborne.selenide.Configuration;

public class ApplicationSettings {
    public static void configure() {
        Configuration.baseUrl = Application.config.baseUrl();
    }
}
