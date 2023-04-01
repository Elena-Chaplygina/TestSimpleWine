package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class UiTest extends TestBaseUI {
    @Test
    @DisplayName("Checking that Пользовательское соглашение и условия contain the correct link")
    void checkPopup() {
        step("Check Пользовательское соглашение и условия contain link", () -> {
            $(withTagAndText("a","Пользовательское соглашение и условия"))
                    .shouldHave(attribute("href","https://simplewine.ru/terms/"));

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
        step("Check popup with recommendations appears after click search field", () -> {
            winePage.afterClickSeachFieldShouldOpenPopup();
        });
    }

    @Test
    @DisplayName("After clicking on the send email button for subscription, if the field is empty, an error text appears")
    void errorMessageAppearAfterClickIfInputEmpty() {
        step("Check error message after send empty field", () -> {
            winePage.errorMessageAppearAfterClickIfInputEmpty();
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