package ui.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Page {

    SelenideElement searchField = $("[data-autotest-target-id=header-search-input]"),
            resultPopup = $(".result-products"),
            outClick = $(".header-search__overlay"),
            btnSubscribe = $(".subscribe-input__button"),
            msgError = $(".subscribe-input__error-message"),
            iconFavorite = $("[data-autotest-target-id=header-favorite-icon]"),
            popupFavorite = $(".user-favorite__description");

    ElementsCollection snippet = $(".snippet-partners").$$(".snippet-partners__item");

    public void footerHasSnippet() {
        snippet.shouldBe(size(4));
    }

    public void afterClickSeachFieldShouldOpenPopup() {
        searchField.click();
        resultPopup.shouldBe(visible);
        outClick.click();
    }

    public void errorMessageAppearAfterClickIfInputEmpty() {
        btnSubscribe.click();
        msgError.shouldBe(visible);
    }

    public void afterHoverFavoritesIconPopupAppears() {
        iconFavorite.hover();
        popupFavorite.shouldBe(visible);
        popupFavorite.shouldHave(text("Войдите, чтобы увидеть свои персональные скидки в каталоге."));
    }


}