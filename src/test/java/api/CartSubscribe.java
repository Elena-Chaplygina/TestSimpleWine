package api;

import api.model.Cart;
import api.model.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static api.spec.Spec.requestSpec;
import static api.spec.Spec.responseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartSubscribe extends TestBaseAPI {

    @Test
    @Tag("api")
    @DisplayName("Add product to cart and check by id and quantity")
    void addProductToCart() {
        step("POST ajax/cart/add/193694/ check id and quantity", () -> {
            String body = "quantity=1";
            Cart cart = requestSpec
                    .header("X-Requested-With", "XMLHttpRequest")
                    .header("Referer", "https://simplewine.ru/catalog/vino/")
                    .body(body)
                    .when()
                    .post("ajax/cart/add/193694/")
                    .then()
                    .spec(responseSpec)
                    .log().body()
                    .extract().as(Cart.class);

            assertEquals(193694, cart.getData()[0].getProductId());
            assertEquals(1, cart.getData()[0].getQuantity());
        });
    }

    @Test
    @Tag("api")
    @DisplayName("Clear cart")
    void clearCard() {
        step("GET ajax/cart/clear/ check response model", () -> {
            Cart cart = requestSpec
                    .header("X-Requested-With", "XMLHttpRequest")
                    .header("Referer", "https://simplewine.ru/personal/cart/")
                    .when()
                    .get("ajax/cart/clear/")
                    .then()
                    .spec(responseSpec)
                    .log().body()
                    .extract().as(Cart.class);
            assertEquals("Clear basket item", cart.getMessage());
        });
    }

    @Test
    @Tag("api")
    @DisplayName("Send a request for the contents of the cart")
    void returnCart() {
        step("GET ajax/cart/ check response model", () -> {
            given()
                    .spec(requestSpec)
                    .header("X-Requested-With", "XMLHttpRequest")
                    .header("Referer", "https://simplewine.ru/catalog/vino/")
                    .when()
                    .get("ajax/cart/")
                    .then()
                    .spec(responseSpec)
                    .log().body();
        });
    }


    @Test
    @Tag("api")
    @DisplayName("Send an email to subscribe, check the message")
    void sendEmailForSubscribe() {
        step("POST ajax/subscribe/user/ with email check message", () -> {
            String email = "qwerty@mail.com";
            boolean agreement = true;
            String body = "email=" + URLEncoder.encode(email, StandardCharsets.UTF_8)
                    + "&agreement=" + URLEncoder.encode(String.valueOf(agreement), StandardCharsets.UTF_8);
            Message message = requestSpec
                    .header("bx-ajax", "Y")
                    .header("Referer", "https://simplewine.ru/")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .body(body)
                    .when()
                    .post("ajax/subscribe/user/")
                    .then()
                    .spec(responseSpec)
                    .log().body()
                    .extract().as(Message.class);
            assertEquals("Спасибо за подписку! ", message.getMessage());
        });
    }

    @Test
    @Tag("api")
    @DisplayName("Send empty email to subscribe, check the message")
    void sendEmailForSubscribeWithountEmail() {
        step("POST ajax/subscribe/user/ withount email check message", () -> {
            String email = "";
            boolean agreement = true;
            String body = "email=" + URLEncoder.encode(email, StandardCharsets.UTF_8)
                    + "&agreement=" + URLEncoder.encode(String.valueOf(agreement), StandardCharsets.UTF_8);
            Message message = requestSpec
                    .header("bx-ajax", "Y")
                    .header("Referer", "https://simplewine.ru/")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .body(body)
                    .when()
                    .post("ajax/subscribe/user/")
                    .then()
                    .spec(responseSpec)
                    .log().body()
                    .extract().as(Message.class);
            assertEquals("Введите email", message.getMessage());
        });
    }


}
