package ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.WebDriverProvider;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ui.page.Page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBaseUI {
    Page winePage=new Page();

    @BeforeAll
     static void init(){
        WebDriverProvider.initConfig();

        open("https://simplewine.ru/");
        $("[data-autotest-target-id=age-popup-btn]").click();
        $("[data-autotest-target-id=city-popup-city-close]").click();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
      void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

}
