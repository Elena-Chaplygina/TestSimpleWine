package ui.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    SelenideElement authItem = $("[data-autotest-target-id=auth-popup-show-button-text]"),
            authPopUp = $("[data-autotest-target-id=user-profile-popup-auth]"),
            authTitle = $(".auth__block-title");

   public void loginPopUp() {
        authItem.hover();
        authPopUp.click();
        authTitle.shouldBe(visible);
    }
}
