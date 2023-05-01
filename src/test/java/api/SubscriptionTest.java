package api;

import api.model.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static api.spec.Spec.requestSpec;
import static api.spec.Spec.responseSpec;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("api")
public class SubscriptionTest extends TestBaseAPI {
    @Test
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
