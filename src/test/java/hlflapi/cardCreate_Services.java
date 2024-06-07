package hlflapi;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class cardCreate_Services {

    @Test
    public void cardResponseData() {
        RestAssured.baseURI = "https://dtpapitestv1.mloyalcapture.com";
        String response = given().log().all()
                .headers(ApiUtils.getHeaders())
                .body(HLFLPayloads.CreateCardPayload()).when().post("/hlflapi/Transaction/CreateCard")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
    }
}