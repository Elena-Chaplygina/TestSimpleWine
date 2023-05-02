package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.step;

@Tags({@Tag("ui"), @Tag("remote")})
public class MainPageTest extends TestBaseUI {
    @CsvSource({
            "Пользовательское соглашение и условия, https://simplewine.ru/terms/",
            "Обработка персональных данных, https://simplewine.ru/privacy_policy/"
    })
    @ParameterizedTest(name = "Checking that {1} contain the correct link {2}")
    void checkLink(String item, String href) {
        step("Check {1} contain link {2}", () -> {
            winePage.checkHref(item,href);
        });
    }

    @Test
    @DisplayName("There are snippets from partners' logos in the page footer")
    void footerHasSnippet() {
        step("Check partners'logo in footer page", () -> {
            winePage.footerHasSnippet();
        });
    }

    @Test
    @DisplayName("After clicking in the search field, a popup with recommendations appears")
    void afterClickSeachFieldShouldOpenPopup() {
        step("Click on the search field", () -> {
            winePage.searchField();
        });
        step("Checking that a popup has appeared", () -> {
            winePage.checkPopUp();
        });
        step("Close popup", () -> {
            winePage.closePopup();
        });
    }

    @Test
    @DisplayName("After clicking on the send email button for subscription, if the field is empty, an error text appears")
    void errorMessageAppearAfterClickIfInputEmpty() {
        step("Click on send button", () -> {
            winePage.selectBtnSubscribe();
        });
        step("Checking for an error message", () -> {
            winePage.checkErrorMsg();
        });
    }

    @Test
    @DisplayName("After hovering over the favorites icon, a popup appears")
    void afterHoverFavoritesIconPopupAppears() {
        step("Check popup after hover the favorites icon", () -> {
            winePage.afterHoverFavoritesIconPopupAppears();
        });
    }
}