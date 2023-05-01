package ui.page.components;

import static com.codeborne.selenide.Selenide.$;

public class AgeGatePopUp {
    public void checkGateAge() {
        $("[data-autotest-target-id=age-popup-btn]").click();
        $("[data-autotest-target-id=city-popup-city-close]").click();
    }

}
