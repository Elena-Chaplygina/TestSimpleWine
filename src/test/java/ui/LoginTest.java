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
        step("Click auth item and check login popup", () -> {
            loginPage.loginPopUp();
        });
    }
}
