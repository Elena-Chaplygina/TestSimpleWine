package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static helpers.CustomApiListener.withCustomTemplates;

public class TestBaseAPI {


    @BeforeAll
    public static void getCookies(){
    RestAssured.baseURI="https://simplewine.ru/";
        RestAssured.filters(withCustomTemplates());

}


}
