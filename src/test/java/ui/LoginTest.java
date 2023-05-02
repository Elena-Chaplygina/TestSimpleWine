package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tags({@Tag("ui"), @Tag("remote")})
public class LoginTest extends TestBaseUI {
    @Test
    @DisplayName("Check login popUp")
    void checkLoginPopUp() {
        step("Open auth popup", () -> {
            loginPage.openAuthPopup();
        });
        step("Check auth title", () -> {
            loginPage.checkAuthTitle();
        });
    }
    @Test
    @DisplayName("SMS sending check")
    void checkErrorMsg() {
        step("Open auth popup", () -> {
            loginPage.openAuthPopup();
        });
        step("Select phone number", () -> {
            loginPage.sendPhoneNumber();
        });
        step("Check send sms", () -> {
            loginPage.checkPhoneNumber();
        });
    }
}
