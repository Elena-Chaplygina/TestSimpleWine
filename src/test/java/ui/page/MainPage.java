package ui.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ui.page.components.AgeGatePopUp;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private AgeGatePopUp closePopUp = new AgeGatePopUp();
    private final String URL = "https://simplewine.ru/";
    SelenideElement searchField = $("[data-autotest-target-id=header-search-input]"),
            resultPopup = $(".result-products"),
            outClick = $(".header-search__overlay"),
            btnSubscribe = $(".subscribe-input__button"),
            msgError = $(".subscribe-input__error-message"),
            iconFavorite = $("[data-autotest-target-id=header-favorite-icon]"),
            popupFavorite = $(".user-favorite__description");
    ElementsCollection snippet = $(".snippet-partners").$$(".snippet-partners__item");


    public void openPage() {
        open(URL);
        closePopUp.checkGateAge();
    }

    public void footerHasSnippet() {
        snippet.shouldBe(size(4));
    }

    public void searchField() {
        searchField.click();
    }

    public void checkPopUp() {
        resultPopup.shouldBe(visible);
    }

    public void closePopup() {
        outClick.click();
    }

    public void selectBtnSubscribe() {
        btnSubscribe.click();
    }

    public void checkErrorMsg() {
        msgError.shouldBe(visible);
    }

    public void checkHref(String btn, String link) {
        $(withTagAndText("a", btn))
                .shouldHave(attribute("href", link));
    }

    public void afterHoverFavoritesIconPopupAppears() {
        iconFavorite.hover();
        popupFavorite.shouldBe(visible);
        popupFavorite.shouldHave(text("Войдите, чтобы увидеть свои персональные скидки в каталоге."));
    }




}