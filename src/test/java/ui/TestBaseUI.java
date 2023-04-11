package ui;

import com.codeborne.selenide.Configuration;
import drivers.WebDriverProvider;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.page.Page;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBaseUI {
    Page winePage=new Page();

    @BeforeAll
     static void init(){
        WebDriverProvider.initConfig();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true));

        Configuration.browserCapabilities = capabilities;
        open("https://simplewine.ru/");
        $("[data-autotest-target-id=age-popup-btn]").click();
        $("[data-autotest-target-id=city-popup-city-close]").click();
    }

    @AfterEach
      void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

}
