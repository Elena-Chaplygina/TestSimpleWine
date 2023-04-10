package ui;

import drivers.WebDriverProvider;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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

    @AfterEach
      void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

}
