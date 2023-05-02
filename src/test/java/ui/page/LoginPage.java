package ui.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    SelenideElement authItem = $("[data-autotest-target-id=auth-popup-show-button-text]"),
            authPopUp = $("[data-autotest-target-id=user-profile-popup-auth]"),
            authTitle = $(".auth__block-title");

    public void openAuthPopup() {
        authItem.hover();
        authPopUp.click();
    }

    public void checkAuthTitle() {
        authTitle.shouldBe(visible);
    }

    public void sendPhoneNumber(){
        $("#auth-phone").setValue("9211234567");
        $("[data-autotest-target-id=auth-phone-popup-form-byphone-submit]").click();
    }
    public void checkPhoneNumber(){
        $(".auth__pincode-info").shouldHave(text("+7 (921) 123-45-67"));
    }
}
