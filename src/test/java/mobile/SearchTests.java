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
    void successfulSearchTestJava1() {
        System.out.println("");
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
    @DisplayName("1")
    @Test
    void successfulSearchTestSagradaFamilia() {
        step("Continue onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Sagrada Familia");
        });
        step("", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });
        step("", () -> {
            $(id("org.wikipedia.alpha:id/view_page_header_image")).click();
        });
        step("", () -> {
            $(id("org.wikipedia.alpha:id/description_text")).shouldHave(visible);
        });
        step("", () -> {
            $(id("org.wikipedia.alpha:id/image")).shouldHave(visible);
        });


    }
    @Tag("mobile_emulation")
    @DisplayName("2")
    @Test
    void successfulSearchTestSagradaFamilia2() {
        step("Continue onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Sagrada Familia");
        });
        step("", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });
        step("жмем на стрелочку", () -> {
            $x("//android.widget.ImageButton[@content-desc=\"Navigate up\"]").click();
        });

        step("жмем на крестик", () -> {
            $(id("org.wikipedia.alpha:id/search_close_btn")).click();
        });
        step("проверка что Recent searches: виден", () -> {
            $(id("org.wikipedia.alpha:id/list_title")).shouldHave(text("Recent searches:"));
            $(id("org.wikipedia.alpha:id/list_title")).shouldHave(visible);

        });
        step("удаление истории поиска", () -> {
            $(id("org.wikipedia.alpha:id/recent_searches_delete_button")).click();
        });
        step("подтверждение удаления истории поиска", () -> {
            $(id("android:id/button1")).click();
        });
        step("картинка пустого поиска видна", () -> {
            $(id("org.wikipedia.alpha:id/search_empty_image")).shouldHave(visible);
        });


    }
    @Tag("mobile_emulation")
    @DisplayName("3")
    @Test
    void successfulSearchTestSagradaFamilia3() {
        step("Continue onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Sagrada Familia");
        });
        step("", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });
        step("жмем на стрелочку", () -> {
            $x("//android.widget.ImageButton[@content-desc=\"Navigate up\"]").click();
        });

        step("жмем на крестик", () -> {
            $(id("org.wikipedia.alpha:id/search_close_btn")).click();
        });
        step("проверка что Recent searches: виден", () -> {
            $(id("org.wikipedia.alpha:id/list_title")).shouldHave(text("Recent searches:"));
            $(id("org.wikipedia.alpha:id/list_title")).shouldHave(visible);

        });
        step("удаление истории поиска", () -> {
            $(id("org.wikipedia.alpha:id/recent_searches_delete_button")).click();
        });
        step("подтверждение удаления истории поиска", () -> {
            $(id("android:id/button2")).click();
        });
        step("проверка что Recent searches: виден", () -> {
            $(id("org.wikipedia.alpha:id/list_title")).shouldHave(text("Recent searches:"));
            $(id("org.wikipedia.alpha:id/list_title")).shouldHave(visible);

        });

    }
    @Tag("mobile_emulation")
    @DisplayName("4")
    @Test
    void successfulSearchTestSagradaFamilia4() {
        step("Continue onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Sagrada Familia");
        });
        step("", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });
        step("жмем на три точки", () -> {
            $(id("org.wikipedia.alpha:id/page_toolbar_button_show_overflow_menu")).click();
        });
        step("выбираем пункт Edit history", () -> {
            $(id("org.wikipedia.alpha:id/page_view_edit_history")).click();
        });
        step("проверка что Recent searches: виден", () -> {
            $(id("org.wikipedia.alpha:id/articleTitleView")).shouldHave(text("Revision history: Sagrada Família"));
            $(id("org.wikipedia.alpha:id/articleTitleView")).shouldHave(visible);

        });
    }

    @Tag("mobile_emulation")
    @DisplayName("5")
    @Test
    void successfulSearchTestSagradaFamilia5() {
        step("Continue onboarding first screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Клик на иконку гамбургера в нижнем таббаре", () -> {
            $(id("org.wikipedia.alpha:id/menu_icon")).click();
        });
        step("Клик на кнопку log in ", () -> {
            $(id("org.wikipedia.alpha:id/main_drawer_account_avatar")).click();
        });
        step("проверка что Create an account виден", () -> {
            $(id("org.wikipedia.alpha:id/action_bar")).shouldHave(visible);

        });
    }


}