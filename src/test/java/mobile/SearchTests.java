package mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBaseMobile {


    @Tag("browserstack")
    @DisplayName("Поиск статьи про Java в Википедии")
    @Test
    void successfulSearchTestJava() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("java");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Tag("mobile_emulation")
    @DisplayName("Checking the onboarding screen")
    @Test
    void successfulSearchTest() {
        step("Check onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("The Free Encyclopedia …in over 300 languages")));

        step("Continue onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check onboarding second screen", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("New ways to explore")));

        step("Continue onboarding second screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check onboarding third screen", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("Reading lists with sync")));

        step("Continue onboarding third screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check onboarding fourth screen", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("Send anonymous data")));

        step("Reject onboarding screen", () ->
                $(id("org.wikipedia.alpha:id/rejectButton")).click());
        step("Verify search field", () ->
                $(id("org.wikipedia.alpha:id/search_container"))
                        .isDisplayed());
    }

    @Tag("mobile_emulation")
    @DisplayName("Checking the opening of an image from an article")
    @Test
    void openImageFromArticle() {
        step("Continue onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Sagrada Familia");
        });
        step("Click title", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });
        step("Click image from article", () -> {
            $(id("org.wikipedia.alpha:id/view_page_header_image")).click();
        });
        step("Description text is visible", () -> {
            $(id("org.wikipedia.alpha:id/description_text")).shouldHave(visible);
        });
        step("Image is visble", () -> {
            $(id("org.wikipedia.alpha:id/image")).shouldHave(visible);
        });
    }

    @Tag("mobile_emulation")
    @DisplayName("Checking delete recent searches")
    @Test
    void deleteRecentSearches() {
        step("Continue onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Sagrada Familia");
        });
        step("Click title", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });
        step("Click on the continue button", () -> {
            $x("//android.widget.ImageButton[@content-desc=\"Navigate up\"]").click();
        });

        step("Click on the close button", () -> {
            $(id("org.wikipedia.alpha:id/search_close_btn")).click();
        });
        step("Checking that Recent searches is visible", () -> {
            $(id("org.wikipedia.alpha:id/list_title")).shouldHave(text("Recent searches:"));
            $(id("org.wikipedia.alpha:id/list_title")).shouldHave(visible);

        });
        step("Delete recent searches", () -> {
            $(id("org.wikipedia.alpha:id/recent_searches_delete_button")).click();
        });
        step("Confirmation of deleting recent searches", () -> {
            $(id("android:id/button1")).click();
        });
        step("Empty search image is visible", () -> {
            $(id("org.wikipedia.alpha:id/search_empty_image")).shouldHave(visible);
        });
    }

    @Tag("mobile_emulation")
    @DisplayName("Checking recent searches after click on the button No")
    @Test
    void safeRecentSearches() {
        step("Continue onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Sagrada Familia");
        });
        step("Click title", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });
        step("Click on the continue button", () -> {
            $x("//android.widget.ImageButton[@content-desc=\"Navigate up\"]").click();
        });

        step("Click on the close button", () -> {
            $(id("org.wikipedia.alpha:id/search_close_btn")).click();
        });
        step("Checking that Recent searches is visible", () -> {
            $(id("org.wikipedia.alpha:id/list_title")).shouldHave(text("Recent searches:"));
            $(id("org.wikipedia.alpha:id/list_title")).shouldHave(visible);

        });
        step("Delete recent searches", () -> {
            $(id("org.wikipedia.alpha:id/recent_searches_delete_button")).click();
        });
        step("Opt out of  of deleting recent searches", () -> {
            $(id("android:id/button2")).click();
        });
        step("Check that recent searches visible", () -> {
            $(id("org.wikipedia.alpha:id/list_title")).shouldHave(text("Recent searches:"));
            $(id("org.wikipedia.alpha:id/list_title")).shouldHave(visible);
        });
    }

    @Tag("mobile_emulation")
    @DisplayName("Checking that Revision history")
    @Test
    void checkRevisionHistory() {
        step("Continue onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Sagrada Familia");
        });
        step("Click title", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });
        step("Click on option button", () -> {
            $(id("org.wikipedia.alpha:id/page_toolbar_button_show_overflow_menu")).click();
        });
        step("Select the item Edit history", () -> {
            $(id("org.wikipedia.alpha:id/page_view_edit_history")).click();
        });
        step("Checking that revision history: is visible", () -> {
            $(id("org.wikipedia.alpha:id/articleTitleView")).shouldHave(text("Revision history: Sagrada Família"));
            $(id("org.wikipedia.alpha:id/articleTitleView")).shouldHave(visible);
        });
    }

    @Tag("mobile_emulation")
    @DisplayName("Checking auth item")
    @Test
    void checkAuthItem() {
        step("Continue onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Click on the hamburger icon in the bottom tabbar", () -> {
            $(id("org.wikipedia.alpha:id/menu_icon")).click();
        });
        step("Click on the log in button ", () -> {
            $(id("org.wikipedia.alpha:id/main_drawer_account_avatar")).click();
        });
        step("Checking that Create an account is visible", () -> {
            $(id("org.wikipedia.alpha:id/action_bar")).shouldHave(visible);

        });
    }
}