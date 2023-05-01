package api;

import api.model.Cart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.spec.Spec.requestSpec;
import static api.spec.Spec.responseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("api")
public class CartTest extends TestBaseAPI {

    @Test
    @DisplayName("Add product to cart and check by id and quantity")
    void addProductToCart() {
        step("POST ajax/cart/add/190675/ check id and quantity", () -> {
            String body = "quantity=1";
            Cart cart = requestSpec
                    .header("X-Requested-With", "XMLHttpRequest")
                    .header("Referer", "https://simplewine.ru/catalog/vino/")
                    .body(body)
                    .when()
                    .post("ajax/cart/add/190675/")
                    .then()
                    .spec(responseSpec)
                    .log().body()
                    .extract().as(Cart.class);

            assertEquals(190675, cart.getData()[0].getProductId());
            assertEquals(1, cart.getData()[0].getQuantity());
        });
    }

    @Test
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
}
